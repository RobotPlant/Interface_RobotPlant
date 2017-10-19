package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.GregorianCalendar;
import java.util.List;

import com.RobotPlant.Model.HistoricoModel;
import com.RobotPlant.Model.QuerysModel;
import com.RobotPlant.Model.TemperaturaModel;
import com.RobotPlant.Model.UmidadeArModel;
import com.RobotPlant.Model.UmidadeSoloModel;

import javafx.collections.ObservableList;

public class BuscaDadosDAO {

    private Connection conn = new Conexaodb().getConnection();
    GregorianCalendar calendario = new GregorianCalendar();

    public boolean verificaId(int i, String nomeTabela) throws SQLException {
    	boolean resposta = false;
    	PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
            String sql = "Select * from tb_"+nomeTabela+" where (id_"+nomeTabela+")="+i+"";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                resposta = true;
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return resposta;
    }

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

    public List<TemperaturaModel> buscaTemperatura() throws SQLException {
    	
    	List<TemperaturaModel> temperaturaModels = null;
        TemperaturaModel temperaturaModel = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	//String sql = "Select temperatura, hora_amostra from tb_temperatura";
        	String sql = "Select temperatura, hora_amostra from tb_temperatura";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                temperaturaModel = new TemperaturaModel();
                temperaturaModel.setTemperaturaValor(rs.getDouble("temperatura"));
                this.calendario.setTime(rs.getTimestamp("hora_amostra"));
                temperaturaModel.setTemperaturaData(this.calendario.getTime());
                temperaturaModels.add(temperaturaModel);
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return temperaturaModels;
    }


    public List<UmidadeArModel> buscaUmidadeAr() throws SQLException {
    	
    	List<UmidadeArModel> umidadeArModels = null;
        UmidadeArModel arModel = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	//String sql = "Select umidade, hora_amostra from tb_umidade_ar";
            String sql = "Select umidade_ar, hora_amostra from tb_umidade_ar";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	umidadeArModels = new ArrayList<UmidadeArModel>();
                arModel = new UmidadeArModel();
                arModel.setUmidadeArValor(rs.getInt("umidade_ar"));
                this.calendario.setTime(rs.getTimestamp("hora_amostra"));
                arModel.setUmidadeArData(this.calendario.getTime());
                umidadeArModels.add(arModel);
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return umidadeArModels;
    }

    public List<UmidadeSoloModel> buscaUmidadeSolo() throws SQLException {
    	
    	List<UmidadeSoloModel> umidadeSoloModels = null;
        UmidadeSoloModel soloModel = new UmidadeSoloModel();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	//String sql = "Select umidade, hora_amostra from tb_umidade_solo";
        	String sql = "Select umidade_solo, hora_amostra from tb_umidade_solo";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
            	umidadeSoloModels = new ArrayList<UmidadeSoloModel>();
                soloModel = new UmidadeSoloModel();
                soloModel.setUmidadeSoloValor(rs.getInt("umidade_solo"));
                this.calendario.setTime(rs.getTimestamp("hora_amostra"));
                soloModel.setUmidadeSoloData(this.calendario.getTime());
                umidadeSoloModels.add(soloModel);
            }
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }

        return umidadeSoloModels;
    }


    public ObservableList<HistoricoModel> listaDados(ObservableList<HistoricoModel> data, String tipo, Date dtInicio, Date dtFim) throws SQLException {

        HistoricoModel historicoModel = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        QuerysModel qmodel = new QuerysModel();
        StringBuilder sql = new StringBuilder();
        List<String> values = new ArrayList<String>();
        values = qmodel.selectQuery(tipo);
        sql.append(values.get(0));
        try {
            stmt = conn.prepareStatement(sql.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
                historicoModel = new HistoricoModel();
                historicoModel.setId(rs.getInt(values.get(2)));
                historicoModel.setTipo(tipo);
                historicoModel.setValor(rs.getDouble(values.get(3)));
                historicoModel.setPlanta(rs.getString(values.get(1)));
                historicoModel.setDataAmostra(rs.getDate(values.get(4)));
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

	public List<HistoricoModel> listaDadosGrafico(List<HistoricoModel> data, String tipo, Date dtInicio, Date dtFim) throws SQLException {
		HistoricoModel historicoModel = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        QuerysModel qmodel = new QuerysModel();
        StringBuilder sql = new StringBuilder();
        List<String> values = new ArrayList<String>();
        values = qmodel.selectQuery(tipo);
        sql.append(values.get(0));
        try {
            stmt = conn.prepareStatement(sql.toString());
            stmt.setDate(1, dtInicio);
            stmt.setDate(2, dtFim);
            rs = stmt.executeQuery();
            while(rs.next()) {
                historicoModel = new HistoricoModel();
                historicoModel.setId(rs.getInt(values.get(2)));
                historicoModel.setTipo(tipo);
                historicoModel.setValor(rs.getDouble(values.get(3)));
                historicoModel.setPlanta(rs.getString(values.get(1)));
                historicoModel.setDataAmostra(rs.getDate(values.get(4)));
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
