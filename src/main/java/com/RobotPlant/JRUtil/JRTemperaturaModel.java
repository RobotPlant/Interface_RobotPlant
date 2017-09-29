package com.RobotPlant.JRUtil;

import java.util.Date;

public class JRTemperaturaModel {

	private int idtemperatura;
	private double valorTemperatura;
	private Date dataTemperatura;
	public JRTemperaturaModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public JRTemperaturaModel(int idtemperatura, double valorTemperatura, Date dataTemperatura) {
		super();
		this.idtemperatura = idtemperatura;
		this.valorTemperatura = valorTemperatura;
		this.dataTemperatura = dataTemperatura;
	}
	public int getIdtemperatura() {
		return idtemperatura;
	}
	public void setIdtemperatura(int idtemperatura) {
		this.idtemperatura = idtemperatura;
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
		result = prime * result + idtemperatura;
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
		if (idtemperatura != other.idtemperatura)
			return false;
		if (Double.doubleToLongBits(valorTemperatura) != Double.doubleToLongBits(other.valorTemperatura))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRTemperaturaModel [idtemperatura=");
		builder.append(idtemperatura);
		builder.append(", valorTemperatura=");
		builder.append(valorTemperatura);
		builder.append(", dataTemperatura=");
		builder.append(dataTemperatura);
		builder.append("]");
		return builder.toString();
	}



}
