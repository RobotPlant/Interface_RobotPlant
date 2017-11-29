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
import com.RobotPlant.JRUtil.Model.JRUmidadeArModel;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class JRUmidadeArDao {

	Connection conn = new Conexaodb().getConnection();

	public List<JRUmidadeArModel> buscaUmidadeAr(Date dtInicio, Date dtFim) throws SQLException {
		List<JRUmidadeArModel> dados = new ArrayList<>();
		JRUmidadeArModel umidade = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
		StringBuilder query = new StringBuilder();
		query.append("SELECT plantacao.id_plantacao, plant.id_planta, plant.tipo_amostra, umiAr.id_umidade_ar, umiAr.umidade_ar, umiAr.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeAr plant_umiAr on plant.id_planta = plant_umiAr.planta_id_Planta ");
		query.append("inner join tb_umidade_ar umiAr on plant_umiAr.umidade_ar_id_umidade_ar = umiAr.id_umidade_ar ");
		query.append("inner join tb_plantacao plantacao on plant.plantacao_id_plantacao = plantacao.id_plantacao ");
		query.append("where umiAr.hora_amostra BETWEEN ? and ? ;");
        try {
            stmt = conn.prepareStatement(query.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	umidade = new JRUmidadeArModel();
            	umidade.setIdPlantacao(rs.getInt(1));
            	umidade.setIdPlanta(rs.getInt(2));
            	umidade.setIdUmidadeAr(rs.getInt(4));
            	umidade.setTipoAmostra(rs.getString(3));
            	umidade.setValorUmidadeAr(rs.getDouble(5));
            	umidade.setDataUmidadeAr(rs.getDate(6));
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

	public ObservableList<JRUmidadeArModel> listaUmidadeAr(Date dtInicio, Date dtFim) throws SQLException {
		ObservableList<JRUmidadeArModel> dados = FXCollections.observableArrayList();
		JRUmidadeArModel umidade = null;
		PreparedStatement stmt = null;
        ResultSet rs = null;
		StringBuilder query = new StringBuilder();
		query.append("SELECT plantacao.id_plantacao, plant.id_planta, plant.tipo_amostra, umiAr.id_umidade_ar, umiAr.umidade_ar, umiAr.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeAr plant_umiAr on plant.id_planta = plant_umiAr.planta_id_Planta ");
		query.append("inner join tb_umidade_ar umiAr on plant_umiAr.umidade_ar_id_umidade_ar = umiAr.id_umidade_ar ");
		query.append("inner join tb_plantacao plantacao on plant.plantacao_id_plantacao = plantacao.id_plantacao ");
		query.append("where umiAr.hora_amostra BETWEEN ? and ? ;");
        try {
            stmt = conn.prepareStatement(query.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	umidade = new JRUmidadeArModel();
            	umidade.setIdPlantacao(rs.getInt(1));
            	umidade.setIdPlanta(rs.getInt(2));
            	umidade.setIdUmidadeAr(rs.getInt(4));
            	umidade.setTipoAmostra(rs.getString(3));
            	umidade.setValorUmidadeAr(rs.getDouble(5));
            	umidade.setDataUmidadeAr(rs.getDate(6));
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
