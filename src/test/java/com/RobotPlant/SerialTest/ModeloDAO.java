package com.RobotPlant.SerialTest;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

import org.apache.log4j.Logger;

public class ModeloDAO implements Serializable {

	private static final Logger LOG = Logger.getLogger(ModeloDAO.class);
	private static final long serialVersionUID = 1L;

	private static Connection conexao;

	public Connection connectionFactory () {

		try {

			Class.forName("com.mysql.jdbc.Driver");
			LOG.info("Carregando conexao");
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

}
