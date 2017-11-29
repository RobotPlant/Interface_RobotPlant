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

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JRTemperaturaDao {

	Connection conn = new Conexaodb().getConnection();

	public List<JRTemperaturaModel> buscaTemperatura(Date dtInicio, Date dtFim) throws SQLException {
		List<JRTemperaturaModel> dados = new ArrayList<>();
		JRTemperaturaModel temperatura = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
        StringBuilder query = new StringBuilder();
		query.append("SELECT plantacao.id_plantacao, plant.id_planta, plant.tipo_amostra, temp.id_temperatura, temp.temperatura,temp.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_temperatura plant_temp on plant.id_planta = plant_temp.Planta_id_planta ");
		query.append("inner join tb_temperatura temp on plant_temp.temperatura_id_temperatura = temp.id_temperatura ");
		query.append("inner join tb_plantacao plantacao on plant.plantacao_id_plantacao = plantacao.id_plantacao ");
		query.append("where temp.hora_amostra BETWEEN ? and ? ;");

        try {
            stmt = conn.prepareStatement(query.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	temperatura = new JRTemperaturaModel();
            	temperatura.setIdPlantacao(rs.getInt(1));
            	temperatura.setIdPlanta(rs.getInt(2));
            	temperatura.setIdTemperatura(rs.getInt(4));
            	temperatura.setTipoAmostra(rs.getString(3));
            	temperatura.setValorTemperatura(rs.getDouble(5));
            	temperatura.setDataTemperatura(rs.getDate(6));
            	dados.add(temperatura);
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

	public ObservableList<JRTemperaturaModel> listaTemperatura(Date dtInicio, Date dtFim) throws SQLException {
		ObservableList<JRTemperaturaModel> dados = FXCollections.observableArrayList();
		JRTemperaturaModel temperatura = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
        StringBuilder query = new StringBuilder();
		query.append("SELECT plantacao.id_plantacao, plant.id_planta, plant.tipo_amostra, temp.id_temperatura, temp.temperatura,temp.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_temperatura plant_temp on plant.id_planta = plant_temp.Planta_id_planta ");
		query.append("inner join tb_temperatura temp on plant_temp.temperatura_id_temperatura = temp.id_temperatura ");
		query.append("inner join tb_plantacao plantacao on plant.plantacao_id_plantacao = plantacao.id_plantacao ");
		query.append("where temp.hora_amostra BETWEEN ? and ? ;");

        try {
            stmt = conn.prepareStatement(query.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	temperatura = new JRTemperaturaModel();
            	temperatura.setIdPlantacao(rs.getInt(1));
            	temperatura.setIdPlanta(rs.getInt(2));
            	temperatura.setIdTemperatura(rs.getInt(4));
            	temperatura.setTipoAmostra(rs.getString(3));
            	temperatura.setValorTemperatura(rs.getDouble(5));
            	temperatura.setDataTemperatura(rs.getDate(6));
            	dados.add(temperatura);
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
