package com.RobotPlant.SerialTest;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class ModeloDAO implements Serializable {

	//private static final Logger LOG = Logger.getLogger(ModeloDAO.class);
	private static final long serialVersionUID = 1L;

	private static Connection conexao;

	private  ModeloDAO() {

	}

	public static Connection getConexao() {
		 try {

			Class.forName("com.mysql.jdbc.Driver");
			//LOG.info("Carregando conexao");
			try {
				conexao = DriverManager.getConnection("jdbc:mysql://localhost:3306/rp_bd", "root", "");
			} catch (SQLException e) {
				e.printStackTrace();
			}
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
          return conexao;
	}

	public void insereDados(String tipo, double valor, Date horaAmostra) {

		StringBuilder sql = new StringBuilder();
		sql.append("insert into"+sql+"("+tipo+", hora_amostra) values (?, ?)");

		try {
			PreparedStatement stmt = conexao.prepareStatement(sql.toString());
			stmt.setDouble(1, valor);
			stmt.setDate(2, horaAmostra);

			stmt.execute();
			stmt.close();
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

	}

}
