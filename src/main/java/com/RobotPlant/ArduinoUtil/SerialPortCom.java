
package com.RobotPlant.ArduinoUtil;

import javafx.collections.ObservableList;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

	public class SerialPortCom {
	    private SerialPort serialPort;


	    public ObservableList<String> initialize(String serialPortName, ObservableList<String> arduinoDados) throws Exception {

	        serialPort = new SerialPort(serialPortName);

	        serialPort.openPort();

	        serialPort.setParams(SerialPort.BAUDRATE_9600, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
	        serialPort.setFlowControlMode(SerialPort.FLOWCONTROL_RTSCTS_IN | SerialPort.FLOWCONTROL_RTSCTS_OUT);
	        // Set a listener to read the ARDUINO output
	        serialPort.addEventListener(new PortReader(serialPort, arduinoDados), SerialPort.MASK_RXCHAR);
	        
	        return arduinoDados;
	    }

	    public void closeConnection() throws Exception {
	        serialPort.closePort();
	    }

	    public void sendData(String data) {
	        try {
	            serialPort.writeString(data);
	        } catch (SerialPortException e) {
	            e.printStackTrace();
	        }
	    }

	    public String[] getAvailableSerialPorts() {
	        String[] ports = SerialPortList.getPortNames();
	        return ports;
	    }

	}
