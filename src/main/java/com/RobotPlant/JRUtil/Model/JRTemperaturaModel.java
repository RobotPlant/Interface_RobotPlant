package com.RobotPlant.JRUtil.Model;

import java.util.Date;

public class JRTemperaturaModel {

	private int 	idTemperatura;
	private int		idPlantacao;
	private int 	idPlanta;
	private String 	tipoAmostra;
	private double	valorTemperatura;
	private Date 	dataTemperatura;

	public JRTemperaturaModel() {
		super();
	}

	public JRTemperaturaModel(int idTemperatura, int idPlantacao, int idPlanta, String tipoAmostra,
			double valorTemperatura, Date dataTemperatura) {
		super();
		this.idTemperatura = idTemperatura;
		this.idPlantacao = idPlantacao;
		this.idPlanta = idPlanta;
		this.tipoAmostra = tipoAmostra;
		this.valorTemperatura = valorTemperatura;
		this.dataTemperatura = dataTemperatura;
	}

	public int getIdTemperatura() {
		return idTemperatura;
	}

	public void setIdTemperatura(int idTemperatura) {
		this.idTemperatura = idTemperatura;
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

	public double getValorTemperatura() {
		return valorTemperatura;
	}

	public void setValorTemperatura(double valorTemperatura) {
		this.valorTemperatura = valorTemperatura;
	}

	public Date getDataTemperatura() {
		return dataTemperatura;
	}

	public void setDataTemperatura(Date dataTemperatura) {
		this.dataTemperatura = dataTemperatura;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataTemperatura == null) ? 0 : dataTemperatura.hashCode());
		result = prime * result + idPlanta;
		result = prime * result + idPlantacao;
		result = prime * result + idTemperatura;
		result = prime * result + ((tipoAmostra == null) ? 0 : tipoAmostra.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valorTemperatura);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		JRTemperaturaModel other = (JRTemperaturaModel) obj;
		if (dataTemperatura == null) {
			if (other.dataTemperatura != null)
				return false;
		} else if (!dataTemperatura.equals(other.dataTemperatura))
			return false;
		if (idPlanta != other.idPlanta)
			return false;
		if (idPlantacao != other.idPlantacao)
			return false;
		if (idTemperatura != other.idTemperatura)
			return false;
		if (tipoAmostra == null) {
			if (other.tipoAmostra != null)
				return false;
		} else if (!tipoAmostra.equals(other.tipoAmostra))
			return false;
		if (Double.doubleToLongBits(valorTemperatura) != Double.doubleToLongBits(other.valorTemperatura))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRTemperaturaModel [idTemperatura=");
		builder.append(idTemperatura);
		builder.append(", idPlantacao=");
		builder.append(idPlantacao);
		builder.append(", idPlanta=");
		builder.append(idPlanta);
		builder.append(", tipoAmostra=");
		builder.append(tipoAmostra);
		builder.append(", valorTemperatura=");
		builder.append(valorTemperatura);
		builder.append(", dataTemperatura=");
		builder.append(dataTemperatura);
		builder.append("]");
		return builder.toString();
	}



}
