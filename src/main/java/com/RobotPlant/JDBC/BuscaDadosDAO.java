package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.RobotPlant.Model.HistoricoModel;
import com.RobotPlant.Model.RelacionamentoModel;
import com.RobotPlant.Model.TemperaturaModel;
import com.RobotPlant.Model.UmidadeArModel;
import com.RobotPlant.Model.UmidadeSoloModel;

import javafx.collections.ObservableList;

public class BuscaDadosDAO {

	private Connection conn = new Conexaodb().getConnection();

	public int buscaUltimoID(String nomeTabela) throws SQLException {

		int idTabela = 0;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "Select MAX(id_"+nomeTabela+") tb_"+nomeTabela+"";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {

				idTabela = (rs.getInt("MAX(id_"+nomeTabela+")"));

			}
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}



		return idTabela;
	}

	public TemperaturaModel buscaTemperatura(int i) throws SQLException {

		TemperaturaModel temperaturaModel = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "Select temperatura, hora_amostra from tb_temperatura where id_temperatura = "+i+"";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				temperaturaModel = new TemperaturaModel();

				temperaturaModel.setTemperaturaValor(rs.getDouble("temperatura"));
				temperaturaModel.setTemperaturaData(rs.getDate("hora_amostra"));

			}
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}

		return temperaturaModel;
	}

	public UmidadeSoloModel buscaUmidadeSolo(int i) throws SQLException {

		UmidadeSoloModel soloModel = new UmidadeSoloModel();
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "Select umidade_solo, hora_amostra from tb_umidade_solo where id_umidade_solo ="+i+"";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				soloModel = new UmidadeSoloModel();

				soloModel.setUmidadeSoloValor(rs.getInt("umidade_solo"));
				soloModel.setUmidadeSoloData(rs.getDate("hora_amostra"));

			}
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}

		return soloModel;
	}

	public UmidadeArModel buscaUmidadeAr(int i) throws SQLException {

		UmidadeArModel arModel = null;
		PreparedStatement stmt = null;
		ResultSet rs = null;
		try {

			String sql = "Select umidade_ar, hora_amostra from tb_umidade_ar where id_umidade_ar = "+i+"";

			stmt = conn.prepareStatement(sql);
			rs = stmt.executeQuery();
			while(rs.next()) {
				arModel = new UmidadeArModel();

				arModel.setUmidadeArValor(rs.getInt("umidade_ar"));
				arModel.setUmidadeArData(rs.getDate("hora_amostra"));

			}
			stmt.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}

		return arModel;

	}

	public ObservableList<HistoricoModel> listaDados(ObservableList<HistoricoModel> data) throws SQLException {

		HistoricoModel historicoModel = null;

		String sql = "SELECT p.tipo_amostra, us.id_umidade_solo, us.umidade_solo,us.hora_amostra FROM tb_planta p " +
				"inner join tb_dados_key dk on p.id_planta = dk.Planta_id_Planta " +
				"inner join tb_umidade_solo us on dk.umidade_solo_id_umidade_solo = us.id_umidade_solo;";

		PreparedStatement stmt = null;
		ResultSet rs = null;

		try {
			stmt = conn.prepareStatement(sql);

			rs = stmt.executeQuery();

			while(rs.next()) {
				historicoModel = new HistoricoModel();

				historicoModel.setId(rs.getInt("us.id_umidade_solo"));
				historicoModel.setTipo("Umidade Solo");
				historicoModel.setValor(rs.getDouble("us.umidade_solo"));
				historicoModel.setPlanta(rs.getString("p.tipo_amostra"));
				historicoModel.setDataAmostra(rs.getDate("us.hora_amostra"));

				data.add(historicoModel);

			}

			stmt.close();
			rs.close();

		} catch (Exception e) {
			throw new RuntimeException(e);
		} finally {
			conn.close();
		}

		return data;
	}


}