package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

public class InsereDadosDAO {

	private Connection conn = null;


	@SuppressWarnings({ "static-access", "deprecation" })
	public void insertDados(String nomeTabela, Double valor) throws SQLException {

		System.out.println("Setando dados");
		conn = new Conexaodb().getConnection();

		try {
			//Falta adicionar o metodo de busca do ultimo id
			String query = "insert into tb_"+nomeTabela+"("+nomeTabela+", hora_amostra) values ( ?, CURRENT_TIMESTAMP)";

			PreparedStatement stmt = null;

			stmt = conn.prepareStatement(query);


			stmt.setDouble(1, valor);
			//stmt.setDate(2, dt);

			System.out.println("Enviando dados db");
			stmt.execute();
			System.out.println("Dados inseridos");
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}

	}

}
