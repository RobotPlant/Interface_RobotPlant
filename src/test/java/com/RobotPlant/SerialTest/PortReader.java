package com.RobotPlant.SerialTest;

import java.util.ArrayList;
import java.util.List;

import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

	public class PortReader implements SerialPortEventListener {

		int i = 0;

		boolean teste = false;

		private String regra = "";
		private String nome = "";

		Double valor[] = new Double[4];

		ModeloTeste modeloTeste = new ModeloTeste();

		List<ModeloTeste> modeloTestes = new ArrayList<ModeloTeste>();

	    private SerialPort serialPort;

	    public PortReader(SerialPort serialPort) {

	        this.serialPort = serialPort;

	    }
	    public synchronized void serialEvent(SerialPortEvent event) {

	        if (event.isRXCHAR()) {

	            try {
	                byte[] buffer = serialPort.readBytes(1);


	                nome += new String(buffer);
	               // System.out.println(buffer);
	                //System.out.print(new String(buffer));
	                System.out.println(nome);


	                if(nome.equals("Temperatura") || teste) {

	                	if (regra.equals("Temperatura")) {


	                		valor[i] = Double.valueOf(nome);



	                		if(i>3) {
	                			modeloTeste.setTempvalue(Double.valueOf(nome));
	                			i=0;
	                		}

	                		i++;

	                	}

	                	if (nome.equals("Temperatura")) {

	                		modeloTeste.setTemperatura(nome);
	                		regra = nome;

	                	}



	                	nome = "";
	                }

	                if(nome.equals("\r\nnan\r\n")) {
	                	nome = "";
	                	teste = false;

	                }

	                if(nome.equals("\r\n")) {
	                	nome = "";
	                	teste = true;
	                }

	               // Float valor = Float.parseFloat(new String(buffer));
	                //System.out.println(nome + " "+ valor);

	            } catch (Exception e) {
	                e.printStackTrace();
	            }
	        }
	    }
	}


