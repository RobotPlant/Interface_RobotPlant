package com.RobotPlant.Model;

import java.util.ArrayList;
import java.util.List;

public class QuerysModel {

	public String planta() {
		StringBuilder query = new StringBuilder();
		query.append("Select * from tb_planta where id_planta = ?");
		return query.toString();
	}

	public String plantacao() {
		StringBuilder query = new StringBuilder();
		query.append("Select * from tb_plantacao where id_plantacao = ?");
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

	private static String graficoTemperatura() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT plant.tipo_amostra, temp.id_temperatura, temp.temperatura,temp.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_temperatura plant_temp on plant.id_planta = plant_temp.Planta_id_planta ");
		query.append("inner join tb_temperatura temp on plant_temp.temperatura_id_temperatura = temp.id_temperatura;");
		return query.toString();
	}

	private static String graficoUmidadeAr() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT plant.tipo_amostra, umiAr.id_umidade_ar, umiAr.umidade_ar, umiAr.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeAr plant_umiAr on plant.id_planta = plant_umiAr.planta_id_Planta ");
		query.append("inner join tb_umidade_ar umiAr on plant_umiAr.umidade_ar_id_umidade_ar = umiAr.id_umidade_ar;");
		return query.toString();
	}

	private static String graficoUmidadeSolo() {
		StringBuilder query = new StringBuilder();
		query.append("SELECT plant.tipo_amostra, umiSolo.id_umidade_solo, umiSolo.umidade_solo,umiSolo.hora_amostra FROM tb_planta plant ");
		query.append("inner join tb_planta_umidadeSolo plant_umiSolo on plant.id_planta = plant_umiSolo.Planta_id_planta ");
		query.append("inner join tb_umidade_solo umiSolo on plant_umiSolo.umidade_solo_id_umidade_solo = umiSolo.id_umidade_solo;");
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

	public List<String> selectQueryGrafico(String tipo) {

		List<String> values = new ArrayList<String>();
		String query = null;

		if(tipo.equals("Temperatura")) {
			query = graficoTemperatura();
			values.add(0, query);
			values.add(1, "plant.tipo_amostra");
			values.add(2, "temp.id_temperatura");
			values.add(3, "temp.temperatura");
			values.add(4, "temp.hora_amostra");
		} if(tipo.equals("Umidade Ar")) {
			query = graficoUmidadeAr();
			values.add(0, query);
			values.add(1, "plant.tipo_amostra");
			values.add(2, "umiAr.id_umidade_ar");
			values.add(3, "umiAr.umidade_ar");
			values.add(4, "umiAr.hora_amostra");
		} if(tipo.equals("Umidade Solo")) {
			query = graficoUmidadeSolo();
			values.add(0, query);
			values.add(1, "plant.tipo_amostra");
			values.add(2, "umiSolo.id_umidade_solo");
			values.add(3, "umiSolo.umidade_solo");
			values.add(4, "umiSolo.hora_amostra");
		}

		return values;

	}

	private static String insertTemperatura() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_temperatura(temperatura, hora_amostra) values (?, CURRENT_TIMESTAMP)");
		return query.toString();
	}

	private static String insertUmidadeAr() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_umidade_ar(umidade_ar, hora_amostra) values (?, CURRENT_TIMESTAMP)");
		return query.toString();
	}

	private static String insertUmidadeSolo() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_umidade_solo(umidade_solo, hora_amostra) values (?, CURRENT_TIMESTAMP)");
		return query.toString();
	}

	private static String insertAtivacao() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_ativacao(tempo_ativacao, hora_amostra) values (?, CURRENT_TIMESTAMP)");
		return query.toString();
	}

	private static String insertPlantacao() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_plantacao(id_plantacao) values (?)");
		return query.toString();
	}

	private static String insertPlanta() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_planta(tipo_amostra, dt_plantacao, plantacao_id_plantacao) values (?, ?, ?)");
		return query.toString();
	}

	private static String insertPlantaTemperatura() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_planta_temperatura(temperatura_id_temperatura, planta_id_planta) values (?, ?)");
		return query.toString();
	}

	private static String insertPlantaUmidadeAr() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_planta_umidadear(umidade_ar_id_umidade_ar, planta_id_planta) values (?, ?)");
		return query.toString();
	}

	private static String insertPlantaUmidadeSolo() {
		StringBuilder query = new StringBuilder();
		query.append("insert into tb_planta_umidadesolo(umidade_solo_id_umidade_solo, planta_id_planta) values (?, ?)");
		return query.toString();
	}

	public static String selectQueryInsertDados(String tipo) {

		String query = null;

		if(tipo.equals("Temperatura")) {
			query = insertTemperatura();

		} if(tipo.equals("Umidade Ar")) {
			query = insertUmidadeAr();

		} if(tipo.equals("Umidade Solo")) {
			query = insertUmidadeSolo();

		} if(tipo.equals("Ativacao")) {
			query = insertAtivacao();
		}

		return query;

	}

}
