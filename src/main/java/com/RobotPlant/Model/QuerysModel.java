package com.RobotPlant.Model;

import java.util.ArrayList;
import java.util.List;

public class QuerysModel {
	
	public String planta() {
		StringBuilder query = new StringBuilder();
		query.append("Select * from tb_planta");
		return query.toString();
	}
	
	public String plantacao() {
		StringBuilder query = new StringBuilder();
		query.append("Select * from tb_plantacao");	
		return query.toString();
	}

	public String temperatura() {
		StringBuilder query = new StringBuilder();
		query.append("Select temperatura, hora_amostra from tb_temperatura");	
		return query.toString();
	}
	
	public String umidadeAr() {
		StringBuilder query = new StringBuilder();
		query.append("Select umidade_ar, hora_amostra from tb_umidade_ar");	
		return query.toString();
	}
	
	public String umidadeSolo() {
		StringBuilder query = new StringBuilder();
		query.append("Select umidade_solo, hora_amostra from tb_umidade_solo");	
		return query.toString();
	}
	
	public String ativacao() {
		StringBuilder query = new StringBuilder();
		query.append("Select * from tb_ativacao");	
		return query.toString();
	}
	
	private static String historicoTemperatura() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT plant.tipo_amostra, temp.id_temperatura, temp.temperatura,temp.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_temperatura plant_temp on plant.id_planta = plant_temp.Planta_id_planta ");
		query.append("inner join tb_temperatura temp on plant_temp.temperatura_id_temperatura = temp.id_temperatura ");
		query.append("where temp.hora_amostra BETWEEN ? and ? ;");
		return query.toString();		
	}
	
	private static String historicoUmidadeAr() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT plant.tipo_amostra, umiAr.id_umidade_ar, umiAr.umidade_ar, umiAr.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeAr plant_umiAr on plant.id_planta = plant_umiAr.planta_id_Planta ");
		query.append("inner join tb_umidade_ar umiAr on plant_umiAr.umidade_ar_id_umidade_ar = umiAr.id_umidade_ar ");
		query.append("where umiAr.hora_amostra BETWEEN ? and ? ;");
		return query.toString();	
	}
	
	private static String historicoUmidadeSolo() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT plant.tipo_amostra, umiSolo.id_umidade_solo, umiSolo.umidade_solo,umiSolo.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeSolo plant_umiSolo on plant.id_planta = plant_umiSolo.Planta_id_planta ");
		query.append("inner join tb_umidade_solo umiSolo on plant_umiSolo.umidade_solo_id_umidade_solo = umiSolo.id_umidade_solo ");
		query.append("where umiSolo.hora_amostra BETWEEN ? and ? ;");
		return query.toString();	
	}
	
	public String configuracao() {
		StringBuilder query = new StringBuilder();
		query.append("Select * from tb_configuracao_arduino");
		
		return query.toString();
	}
	

	public List<String> selectQuery(String tipo) {
		
		List<String> values = new ArrayList<String>();
		String query = null;
		
		if(tipo.equals("Temperatura")) {
			query = historicoTemperatura();
			values.add(0, query);
			values.add(1, "plant.tipo_amostra");
			values.add(2, "temp.id_temperatura");
			values.add(3, "temp.temperatura");
			values.add(4, "temp.hora_amostra");
		} if(tipo.equals("Umidade Ar")) {
			query = historicoUmidadeAr();
			values.add(0, query);
			values.add(1, "plant.tipo_amostra");
			values.add(2, "umiAr.id_umidade_ar");
			values.add(3, "umiAr.umidade_ar");
			values.add(4, "umiAr.hora_amostra");
		} if(tipo.equals("Umidade Solo")) {
			query = historicoUmidadeSolo();
			values.add(0, query);
			values.add(1, "plant.tipo_amostra");
			values.add(2, "umiSolo.id_umidade_solo");
			values.add(3, "umiSolo.umidade_solo");
			values.add(4, "umiSolo.hora_amostra");
		}
		
		return values;
		
	}

}
