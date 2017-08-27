package com.RobotPlant.SerialTest;

import java.util.logging.Level;
import java.util.logging.Logger;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
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

public class teste extends Application {

    SerialPort arduinoPort = null;
    ObservableList<String> portList;

    Label labelValue;
    

    private void detectPort(){

        portList = FXCollections.observableArrayList();

        String[] serialPortNames = SerialPortList.getPortNames();
        for(String name: serialPortNames){
            System.out.println(name);
            portList.add(name);
        }
    }

    @Override
    public void start(Stage primaryStage) {

    	final CategoryAxis xAxis = new CategoryAxis();
    	
    	final NumberAxis yAxis = new NumberAxis();
    	final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
    	xAxis.setLabel("Hora");
    	yAxis.setLabel("Temperatura");
    	
    	XYChart.Series series1 = new XYChart.Series();
    	series1.setName("Histograma");
    	
		 series1.getData().add(new XYChart.Data("0-10", 0));
		 series1.getData().add(new XYChart.Data("0-20", 0));
		 series1.getData().add(new XYChart.Data("0-30", 0));
		 series1.getData().add(new XYChart.Data("0-40", 0));
		 series1.getData().add(new XYChart.Data("0-50",0));
		 series1.getData().add(new XYChart.Data("0-60", 0));
		 series1.getData().add(new XYChart.Data("0-70", 0));
    	
    	lineChart.getData().addAll(series1);
    	
        labelValue = new Label();
        labelValue.setFont(new Font("Arial", 150));

        detectPort();
        final ComboBox comboBoxPorts = new ComboBox(portList);
        comboBoxPorts.valueProperty()
                .addListener(new ChangeListener<String>() {

            @Override
            public void changed(ObservableValue<? extends String> observable,
                    String oldValue, String newValue) {

                System.out.println(newValue);
                disconnectArduino();
                connectArduino(newValue, series1);
            }

        });

        VBox vBox = new VBox();
        vBox.getChildren().addAll(
                comboBoxPorts, labelValue, lineChart);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 300, 250);

        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    public boolean connectArduino(String port, XYChart.Series series1){

        System.out.println("connectArduino");

        boolean success = false;
        SerialPort serialPort = new SerialPort(port);
        try {
            serialPort.openPort();
            serialPort.setParams(
                    SerialPort.BAUDRATE_9600,
                    SerialPort.DATABITS_8,
                    SerialPort.STOPBITS_1,
                    SerialPort.PARITY_NONE);
            serialPort.setEventsMask(MASK_RXCHAR);
            serialPort.addEventListener((SerialPortEvent serialPortEvent) -> {
                if(serialPortEvent.isRXCHAR()){
                    try {

                        byte[] b = serialPort.readBytes();
                        int value = b[0] & 0xff;    //convert to int
                        String st = String.valueOf(value);


                        //Update label in ui thread
                        Platform.runLater(() -> {
                            labelValue.setText(st);
                            int i = 0;
                            		i++;
                            		
                            		 Timeline timeline = new Timeline();	
                            		 if (value <= 10) {
                 	  	  //              group[0]++;
                 	  	               series1.getData().set(0, new XYChart.Data("0-10", value));
                 	  	              
                 	  	            } else if (value <= 20) {
                 	  	    //            group[1]++;
                 	  	                series1.getData().set(1, new XYChart.Data("10-20", value));
                 	  	           
                 	  	            } else if (value <= 30) {
                 	  	     //           group[2]++;
                 	  	                series1.getData().set(2, new XYChart.Data("20-30", value));
                 	  	             
                 	  	            } else if (value <= 40) {
                 	  	   //             group[3]++;
                 	  	                series1.getData().set(3, new XYChart.Data("30-40", value));
                 	  	            
                 	  	            } else if (value <= 50) {
                 	  	 //               group[4]++;
                 	  	                series1.getData().set(4, new XYChart.Data("40-50", value));
                 	  	         } else if (value <= 60) {    
                 	  	 //               group[5]++;
                 	 	                series1.getData().set(5, new XYChart.Data("50-60", value));

                 	  	            } else if (value <= 70) {
                 //	  	                group[6]++;
                 		                series1.getData().set(6, new XYChart.Data("60-70", value));

                 	  	            }
                            		 
                            		 timeline.setCycleCount(1000);
                     	  	        timeline.setAutoReverse(true);  //!?
                     	  	        timeline.play();

                     	  	        
                        });

                    } catch (SerialPortException ex) {
                        Logger.getLogger(JavaFX_jssc_Uno.class.getName())
                                .log(Level.SEVERE, null, ex);
                    } catch (NullPointerException e) {

					}

                }
            });

            arduinoPort = serialPort;
            success = true;
        } catch (SerialPortException ex) {
            Logger.getLogger(JavaFX_jssc_Uno.class.getName())
                    .log(Level.SEVERE, null, ex);
            System.out.println("SerialPortException: " + ex.toString());
        }

        return success;
    }

    public void disconnectArduino(){

        System.out.println("disconnectArduino()");
        if(arduinoPort != null){
            try {
                arduinoPort.removeEventListener();

                if(arduinoPort.isOpened()){
                    arduinoPort.closePort();
                }

            } catch (SerialPortException ex) {
                Logger.getLogger(JavaFX_jssc_Uno.class.getName())
                        .log(Level.SEVERE, null, ex);
            }
        }
    }

    @Override
    public void stop() throws Exception {
        disconnectArduino();
        super.stop();
    }

  public static void main(String[] args) {
	  launch(args);
}

}