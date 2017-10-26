package com.RobotPlant.ArduinoUtil;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RobotPlant.JDBC.InsereDadosDAO;
import com.RobotPlant.Model.SerialDadosModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortEventListener;

	public class PortReader implements SerialPortEventListener {

		int i = 0;

		String teste = "";

		private String regra = "";
		private String nome = "";

		String [] valor = new String[6];
		Double [] dado = new Double[6];
		StringBuffer strbuff = new StringBuffer("");
		SerialDadosModel serialDadosModel = new SerialDadosModel();
		InsereDadosDAO dadosDAO = new InsereDadosDAO();

		List<SerialDadosModel> modeloTestes = new ArrayList<SerialDadosModel>();
		
		ObservableList<String> arduinoDados = FXCollections.observableArrayList();

	    private SerialPort serialPort;

	    public PortReader(SerialPort serialPort, ObservableList<String> arduinoDados) {

	        this.serialPort = serialPort;
	        this.arduinoDados = arduinoDados;

	    }
	    public synchronized void serialEvent(SerialPortEvent event) {

	        if (event.isRXCHAR()) {

	            try {
		            byte[] buffer = serialPort.readBytes(1);
		            nome += new String(buffer);
		            System.out.println(nome);
		            strbuff.append(nome);
		            nome = "";
		            

	            	Thread.sleep(100);
	            	System.out.println(strbuff.toString());

	                if(strbuff.toString().equals("Temperatura:") || strbuff.toString().equals("Umidade_solo:")
	                		|| strbuff.toString().equals("Umidade_ar:")) {

	                	for(int i = 0; i<6 ; i++) {
	                		byte[] temp = serialPort.readBytes(1);
	                		nome += new String(temp);
			                Thread.sleep(1000);

			                if(nome.equals("\r\n") || nome.equals(" ")) {
			                	for(int j = 0; j < 6; j++) {
			                		byte[] usb = serialPort.readBytes(1);
			                		nome += new String(usb);
			                		Thread.sleep(1000);
			                		if(nome.equals("n") || nome.equals("a") || nome.equals("n") ||nome.equals("\r") || nome.equals("\n")) {
			                			nome = "";
			                		} else {
			                			valor[j] = nome;
			                			nome = "";
			                		}


			                	}
			                	if(valor.length > 0) {
			                		for (int k = 0; k < valor.length; k++) {
			                			teste += String.valueOf(valor[k]).replaceAll("null", "0");
			                			Thread.sleep(1000);
			                		}
			                		System.out.println("Preparando e enviando dados");
			                		this.verificaValor(strbuff.toString().replace(":", ""), Double.valueOf(teste));
			                		teste = "";
			                		Thread.sleep(1000);
			                	}
			                	strbuff = new StringBuffer("");
			                	nome = "";
			                	i=7;
			                }
	                	}
	                }
	                if(strbuff.toString().equals("\r\n") || strbuff.toString().equals("\n") || strbuff.toString().equals("\r")) {
	                	strbuff =  new StringBuffer("");;
	                }
	            } catch (Exception e) {
	                e.printStackTrace();
	                nome = "";
	            }
	        }
	    }

	    public void verificaValor(String nome, Double valor) {

	    	if (nome.equals("Temperatura")) {
	    		serialDadosModel.setTemperatura(nome);
	    		serialDadosModel.setTempvalue(valor);
	            try {
	            	Thread.sleep(1000);
	            	arduinoDados.addAll(new String(nome+" "+String.valueOf(valor)));
					dadosDAO.insertDados(nome.toLowerCase(), valor);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}

	    	} else if (nome.equals("Umidade_solo")) {
	    		serialDadosModel.setUmidadeSolo(nome);
	    		serialDadosModel.setSoloValue(valor);
	            try {
	            	Thread.sleep(1000);
	            	arduinoDados.addAll(new String(nome+" "+String.valueOf(valor)));
					dadosDAO.insertDados(nome.toLowerCase(), valor);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}

	    	} else if (nome.equals("Umidade_ar")) {
	    		serialDadosModel.setUmidadeAr(nome);
	    		serialDadosModel.setArValue(valor);
	            try {
	            	Thread.sleep(1000);
	            	arduinoDados.addAll(new String(nome+" "+String.valueOf(valor)));
					dadosDAO.insertDados(nome.toLowerCase(), valor);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}
	    	} else {
	    		System.out.println("String inválida!!!");
	    	}
	    	strbuff = new StringBuffer("");
	    }
	}


