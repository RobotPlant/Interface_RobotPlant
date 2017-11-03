package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.RobotPlant.Model.QuerysModel;

public class InsereDadosDAO {

	private Connection conn = new Conexaodb().getConnection();

	@SuppressWarnings({ "static-access", "deprecation" })
	public void insertDados(String idPlanta, String tipo, Double valor) throws SQLException {
		PreparedStatement stmt = null;
		String query = null;
		query = new QuerysModel().selectQueryInsertDados(tipo);
		try {

			stmt = conn.prepareStatement(query);

			stmt.setDouble(1, valor);

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

	public void insertPlantacao() {

	}

	public void insertPlanta() {

	}

	public void insertPlantaDado(String idPlanta, String tipo) {

	}

}
