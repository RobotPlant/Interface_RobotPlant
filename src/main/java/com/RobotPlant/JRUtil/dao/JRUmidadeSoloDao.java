package com.RobotPlant.JRUtil.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RobotPlant.JDBC.Conexaodb;
import com.RobotPlant.JRUtil.Model.JRTemperaturaModel;
import com.RobotPlant.JRUtil.Model.JRUmidadeSoloModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JRUmidadeSoloDao {

	Connection conn = new Conexaodb().getConnection();

	public List<JRUmidadeSoloModel> buscaUmidadeSolo(Date dtInicio, Date dtFim) throws SQLException {
		List<JRUmidadeSoloModel> dados = new ArrayList<>();
		JRUmidadeSoloModel umidade = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
		StringBuilder query = new StringBuilder();
		query.append("SELECT plantacao.id_plantacao, plant.id_planta, plant.tipo_amostra, umiSolo.id_umidade_solo, umiSolo.umidade_solo,umiSolo.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeSolo plant_umiSolo on plant.id_planta = plant_umiSolo.Planta_id_planta ");
		query.append("inner join tb_umidade_solo umiSolo on plant_umiSolo.umidade_solo_id_umidade_solo = umiSolo.id_umidade_solo ");
		query.append("inner join tb_plantacao plantacao on plant.plantacao_id_plantacao = plantacao.id_plantacao ");
		query.append("where umiSolo.hora_amostra BETWEEN ? and ? ;");
        try {
            stmt = conn.prepareStatement(query.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	umidade = new JRUmidadeSoloModel();
            	umidade.setIdPlantacao(rs.getInt(1));
            	umidade.setIdPlanta(rs.getInt(2));
            	umidade.setIdUmidadeSolo(rs.getInt(4));
            	umidade.setTipoAmostra(rs.getString(3));
            	umidade.setValorUmidadeSolo(rs.getDouble(5));
            	umidade.setDataUmidadeSolo(rs.getDate(6));
            	dados.add(umidade);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }

		return dados;

	}
	public ObservableList<JRUmidadeSoloModel> listaUmidadeSolo(Date dtInicio, Date dtFim) throws SQLException {
		ObservableList<JRUmidadeSoloModel> dados = FXCollections.observableArrayList();
		JRUmidadeSoloModel umidade = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
		StringBuilder query = new StringBuilder();
		query.append("SELECT plantacao.id_plantacao, plant.id_planta, plant.tipo_amostra, umiSolo.id_umidade_solo, umiSolo.umidade_solo,umiSolo.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeSolo plant_umiSolo on plant.id_planta = plant_umiSolo.Planta_id_planta ");
		query.append("inner join tb_umidade_solo umiSolo on plant_umiSolo.umidade_solo_id_umidade_solo = umiSolo.id_umidade_solo ");
		query.append("inner join tb_plantacao plantacao on plant.plantacao_id_plantacao = plantacao.id_plantacao ");
		query.append("where umiSolo.hora_amostra BETWEEN ? and ? ;");
        try {
            stmt = conn.prepareStatement(query.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	umidade = new JRUmidadeSoloModel();
            	umidade.setIdPlantacao(rs.getInt(1));
            	umidade.setIdPlanta(rs.getInt(2));
            	umidade.setIdUmidadeSolo(rs.getInt(4));
            	umidade.setTipoAmostra(rs.getString(3));
            	umidade.setValorUmidadeSolo(rs.getDouble(5));
            	umidade.setDataUmidadeSolo(rs.getDate(6));
            	dados.add(umidade);
            }
            stmt.close();
            rs.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }

		return dados;

	}

}
