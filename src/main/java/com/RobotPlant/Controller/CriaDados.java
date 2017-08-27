package com.RobotPlant.Controller;

import java.sql.SQLException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;

import com.RobotPlant.JDBC.InsereDadosDAO;
import com.RobotPlant.Model.TesteDados;

public class CriaDados {

	public static void main(String[] args) throws SQLException {
		CriaDadoBD();
	}

	public static void CriaDadoBD() throws SQLException {

		TesteDados testeDados;

		List<TesteDados> dados = new ArrayList<TesteDados>();

		InsereDadosDAO dadosDAO = new InsereDadosDAO();

		Random random = new Random(1);

		int nrAlertorio = 0;

		String[] tipo = {"Temperatura", "Umidade do solo", "Umidade ar"};

		int valor = 0;

		GregorianCalendar calendar = new GregorianCalendar();

		int hora = 0;

		for(int i = 0; i<100; i++) {

			testeDados = new TesteDados();

			nrAlertorio = 0 + random.nextInt(3);

			String dado = tipo[nrAlertorio];
			valor = random.nextInt()+i;
			hora = calendar.get(calendar.SECOND);
			testeDados.setId(i);
			testeDados.setTipo(dado);
			testeDados.setValor(valor);
			testeDados.setHora(hora);

			//dados.add(i, testeDados);

			dadosDAO.insertDado(testeDados);

		}


	}

}
