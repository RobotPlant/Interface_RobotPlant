package com.RobotPlant.Model;

import java.io.Serializable;
import java.sql.Date;

public class TemperaturaModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double temperaturaValor;
	private Date temperaturaData;
	public TemperaturaModel() {
		super();
	}
	public TemperaturaModel(double temperaturaValor, Date temperaturaData) {
		super();
		this.temperaturaValor = temperaturaValor;
		this.temperaturaData = temperaturaData;
	}
	public double getTemperaturaValor() {
		return temperaturaValor;
	}
	public void setTemperaturaValor(double temperaturaValor) {
		this.temperaturaValor = temperaturaValor;
	}
	public Date getTemperaturaData() {
		return temperaturaData;
	}
	public void setTemperaturaData(Date temperaturaData) {
		this.temperaturaData = temperaturaData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((temperaturaData == null) ? 0 : temperaturaData.hashCode());
		long temp;
		temp = Double.doubleToLongBits(temperaturaValor);
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
		TemperaturaModel other = (TemperaturaModel) obj;
		if (temperaturaData == null) {
			if (other.temperaturaData != null)
				return false;
		} else if (!temperaturaData.equals(other.temperaturaData))
			return false;
		if (Double.doubleToLongBits(temperaturaValor) != Double.doubleToLongBits(other.temperaturaValor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TemperaturaModel [temperaturaValor=");
		builder.append(temperaturaValor);
		builder.append(", temperaturaData=");
		builder.append(temperaturaData);
		builder.append("]");
		return builder.toString();
	}
	
	

}
