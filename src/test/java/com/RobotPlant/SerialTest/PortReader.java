package com.RobotPlant.SerialTest;


import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RobotPlant.JDBC.InsereDadosDAO;

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
		ModeloTeste modeloTeste = new ModeloTeste();
		InsereDadosDAO dadosDAO = new InsereDadosDAO();

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
	    		modeloTeste.setTemperatura(nome);
	            modeloTeste.setTempvalue(valor);
	            try {
	            	Thread.sleep(1000);
					dadosDAO.insertDados(nome.toLowerCase(), valor);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}

	    	} else if (nome.equals("Umidade_solo")) {
	    		modeloTeste.setUmidadeSolo(nome);
	            modeloTeste.setSoloValue(valor);
	            try {
	            	Thread.sleep(1000);
					dadosDAO.insertDados(nome.toLowerCase(), valor);
				} catch (SQLException | InterruptedException e) {
					e.printStackTrace();
				}

	    	} else if (nome.equals("Umidade_ar")) {
	    		modeloTeste.setUmidadeAr(nome);
	            modeloTeste.setArValue(valor);
	            try {
	            	Thread.sleep(1000);
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


