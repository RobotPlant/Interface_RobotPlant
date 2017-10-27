package com.RobotPlant.JRUtil.Model;

import java.util.Date;

public class JRUmidadeSoloModel {

	private int 	idUmidadeSolo;
	private int		idPlantacao;
	private int 	idPlanta;
	private String 	tipoAmostra;
	private double 	valorUmidadeSolo;
	private Date 	dataUmidadeSolo;

	public JRUmidadeSoloModel() {
		super();
	}

	public JRUmidadeSoloModel(int idUmidadeSolo, int idPlantacao, int idPlanta, String tipoAmostra, double valorUmidadeSolo,
			Date dataUmidadeSolo) {
		super();
		this.idUmidadeSolo = idUmidadeSolo;
		this.idPlantacao = idPlantacao;
		this.idPlanta = idPlanta;
		this.tipoAmostra = tipoAmostra;
		this.valorUmidadeSolo = valorUmidadeSolo;
		this.dataUmidadeSolo = dataUmidadeSolo;
	}

	public int getIdUmidadeSolo() {
		return idUmidadeSolo;
	}

	public void setIdUmidadeSolo(int idUmidadeSolo) {
		this.idUmidadeSolo = idUmidadeSolo;
	}

	public int getIdPlantacao() {
		return idPlantacao;
	}

	public void setIdPlantacao(int idPlantacao) {
		this.idPlantacao = idPlantacao;
	}

	public int getIdPlanta() {
		return idPlanta;
	}

	public void setIdPlanta(int idPlanta) {
		this.idPlanta = idPlanta;
	}

	public String getTipoAmostra() {
		return tipoAmostra;
	}

	public void setTipoAmostra(String tipoAmostra) {
		this.tipoAmostra = tipoAmostra;
	}

	public double getValorUmidadeSolo() {
		return valorUmidadeSolo;
	}

	public void setValorUmidadeSolo(double valorUmidadeSolo) {
		this.valorUmidadeSolo = valorUmidadeSolo;
	}

	public Date getDataUmidadeSolo() {
		return dataUmidadeSolo;
	}

	public void setDataUmidadeSolo(Date dataUmidadeSolo) {
		this.dataUmidadeSolo = dataUmidadeSolo;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRUmidadeSolo [idUmidadeSolo=");
		builder.append(idUmidadeSolo);
		builder.append(", idPlantacao=");
		builder.append(idPlantacao);
		builder.append(", idPlanta=");
		builder.append(idPlanta);
		builder.append(", tipoAmostra=");
		builder.append(tipoAmostra);
		builder.append(", valorUmidadeSolo=");
		builder.append(valorUmidadeSolo);
		builder.append(", dataUmidadeSolo=");
		builder.append(dataUmidadeSolo);
		builder.append("]");
		return builder.toString();
	}



}
