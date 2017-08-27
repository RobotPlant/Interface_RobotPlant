package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import com.RobotPlant.Model.TesteDados;

public class InsereDadosDAO {

	public void insertDado(TesteDados dados) throws SQLException {

		Connection conn = new Conexaodb().getConnection();

		try {


			String query = "insert into td_teste_dados(id, 	tipo, valor, hora) values (?, ?, ?, ?)";

			PreparedStatement stmt = null;

			stmt = conn.prepareStatement(query);

			stmt.setInt(1, dados.getId());
			stmt.setString(2, dados.getTipo());
			stmt.setInt(3, dados.getValor());
			stmt.setInt(4, dados.getHora());

			stmt.execute();

			stmt.close();



		} catch (Exception e) {
			System.out.println(e);
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}

	}

}
