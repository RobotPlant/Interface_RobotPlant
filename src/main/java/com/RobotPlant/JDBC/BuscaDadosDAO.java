package com.RobotPlant.JDBC;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.GregorianCalendar;
import com.RobotPlant.Model.HistoricoModel;
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


    public TemperaturaModel buscaTemperatura(int i) throws SQLException {

        TemperaturaModel temperaturaModel = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	//String sql = "Select temperatura, hora_amostra from tb_temperatura";
        	String sql = "Select temperatura, hora_amostra from tb_temperatura where id_temperatura = "+i+"";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                temperaturaModel = new TemperaturaModel();
                temperaturaModel.setTemperaturaValor(rs.getDouble("temperatura"));
                this.calendario.setTime(rs.getTimestamp("hora_amostra"));
                temperaturaModel.setTemperaturaData(this.calendario.getTime());
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return temperaturaModel;
    }


    public UmidadeArModel buscaUmidadeAr(int i) throws SQLException {

        UmidadeArModel arModel = null;
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	//String sql = "Select umidade, hora_amostra from tb_umidade_ar";
            String sql = "Select umidade, hora_amostra from tb_umidade_ar where id_umidade_ar = "+i+"";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                arModel = new UmidadeArModel();
                arModel.setUmidadeArValor(rs.getInt("umidade"));
                this.calendario.setTime(rs.getTimestamp("hora_amostra"));
                arModel.setUmidadeArData(this.calendario.getTime());
            }
            stmt.close();
        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }
        return arModel;
    }

    public UmidadeSoloModel buscaUmidadeSolo(int i) throws SQLException {

        UmidadeSoloModel soloModel = new UmidadeSoloModel();
        PreparedStatement stmt = null;
        ResultSet rs = null;
        try {
        	//String sql = "Select umidade, hora_amostra from tb_umidade_solo";
        	String sql = "Select umidade, hora_amostra from tb_umidade_solo where id_umidade_solo ="+i+"";
            stmt = conn.prepareStatement(sql);
            rs = stmt.executeQuery();
            while(rs.next()) {
                soloModel = new UmidadeSoloModel();
                soloModel.setUmidadeSoloValor(rs.getInt("umidade"));
                this.calendario.setTime(rs.getTimestamp("hora_amostra"));
                soloModel.setUmidadeSoloData(this.calendario.getTime());
            }
            stmt.close();

        } catch (Exception e) {
            throw new RuntimeException(e);
        } finally {
            conn.close();
        }

        return soloModel;
    }


    public ObservableList<HistoricoModel> listaDados(ObservableList<HistoricoModel> data) throws SQLException {

        HistoricoModel historicoModel = null;

        String sql = "SELECT p.tipo_amostra, us.id_umidade_solo, us.umidade,us.hora_amostra FROM tb_planta p " +
                "inner join tb_planta_umidadesolo pus on p.id_planta = pus.Planta_id_Planta " +
                "inner join tb_umidade_solo us on pus.umidade_solo_id_umidade_solo = us.id_umidade_solo;";

        PreparedStatement stmt = null;
        ResultSet rs = null;

        try {
            stmt = conn.prepareStatement(sql);

            rs = stmt.executeQuery();

            while(rs.next()) {
                historicoModel = new HistoricoModel();

                historicoModel.setId(rs.getInt("us.id_umidade_solo"));
                historicoModel.setTipo("Umidade Solo");
                historicoModel.setValor(rs.getDouble("us.umidade"));
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
