package com.RobotPlant.ArduinoUtil;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ArduinoSC {

	SerialPort arduinoPort = null;
	ObservableList<String> portList;
	int i = 0;
	int group[] = new int[10];
	

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public int[] SerialConnection(String port, XYChart.Series series1) {

		SerialPort serialPort = new SerialPort(port);
		boolean success = false;
		

		try {

			serialPort.openPort();
			serialPort.setParams(
					SerialPort.BAUDRATE_9600,
					SerialPort.DATABITS_8,
					SerialPort.STOPBITS_1,
					SerialPort.PARITY_NONE);
			serialPort.setEventsMask(MASK_RXCHAR);

			serialPort.addEventListener((SerialPortEvent serialPortEvent) -> {


				if(serialPortEvent.isRXCHAR()) {


					try {


						byte[] b = serialPort.readBytes();
						int value = b[0] & 0xff;
						String st = String.valueOf(value);
						
						//Update label in ui thread
                        Platform.runLater(() -> {
                        	try {
                        		
                        		if (value <= 10) {
                                    group[0]++;
                                    series1.getData().set(0, new XYChart.Data("0-10", group[0]));
                                } else if (value <= 20) {
                                    group[1]++;
                                    series1.getData().set(1, new XYChart.Data("10-20", group[1]));
                                } else if (value <= 30) {
                                    group[2]++;
                                    series1.getData().set(2, new XYChart.Data("20-30", group[2]));
                                } else if (value <= 40) {
                                    group[3]++;
                                    series1.getData().set(3, new XYChart.Data("30-40", group[3]));
                                } else if (value <= 50) {
                                    group[4]++;
                                    series1.getData().set(4, new XYChart.Data("40-50", group[4]));
                                } else if (value <= 60) {
                                    group[5]++;
                                    series1.getData().set(5, new XYChart.Data("50-60", group[5]));
                                } else if (value <= 70) {
                                    group[6]++;
                                    series1.getData().set(6, new XYChart.Data("60-70", group[6]));
                                } else if (value <= 80) {
                                    group[7]++;
                                    series1.getData().set(7, new XYChart.Data("70-80", group[7]));
                                } else if (value <= 90) {
                                    group[8]++;
                                    series1.getData().set(8, new XYChart.Data("80-90", group[8]));
                                } else if (value <= 100) {
                                    group[9]++;
                                    series1.getData().set(9, new XYChart.Data("10-100", group[9]));
                                }
                        		
                        	
                        	} catch (NullPointerException e) {
        						System.err.println(i + value );
        					}
                        });

					} catch (SerialPortException ex) {
						Logger.getLogger(ArduinoSC.class.getName()).log(Level.SEVERE, null, ex);
					} catch (NullPointerException e) {
						System.err.println(i);
					} catch (IndexOutOfBoundsException e) {
						System.err.println(i);
					}

				}

			});

			arduinoPort = serialPort;
			success = true;

		} catch (SerialPortException ex) {
			Logger.getLogger(ArduinoSC.class.getName()).log(Level.SEVERE, null, ex);
			System.out.println("SerialPortException: " + ex.toString());
		}

		return group;

	}


	public ObservableList<String> DetectaPorta() {

		portList = FXCollections.observableArrayList();
		String[] serialPortNames = SerialPortList.getPortNames();

		for(String name: serialPortNames) {
			System.out.println(name);
			portList.add(name);
		}
		
		return portList;
	}

	public void DisconectaArduino(){

        System.out.println("disconnectArduino()");
        if(arduinoPort != null){
            try {
                arduinoPort.removeEventListener();

                if(arduinoPort.isOpened()){
                    arduinoPort.closePort();
                }

            } catch (SerialPortException ex) {
                Logger.getLogger(ArduinoSC.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    public void Stop() throws Exception {
    	DisconectaArduino();
  //      super.Stop();
    }

}
