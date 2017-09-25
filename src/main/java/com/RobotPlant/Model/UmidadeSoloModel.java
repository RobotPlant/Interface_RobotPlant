package com.RobotPlant.Model;

import java.io.Serializable;
import java.sql.Date;

public class UmidadeSoloModel implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private double umidadeSoloValor;
	private Date umidadeSoloData;
	public UmidadeSoloModel() {
		super();
	}
	public UmidadeSoloModel(double umidadeSoloValor, Date umidadeSoloData) {
		super();
		this.umidadeSoloValor = umidadeSoloValor;
		this.umidadeSoloData = umidadeSoloData;
	}
	public double getUmidadeSoloValor() {
		return umidadeSoloValor;
	}
	public void setUmidadeSoloValor(double umidadeSoloValor) {
		this.umidadeSoloValor = umidadeSoloValor;
	}
	public Date getUmidadeSoloData() {
		return umidadeSoloData;
	}
	public void setUmidadeSoloData(Date umidadeSoloData) {
		this.umidadeSoloData = umidadeSoloData;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((umidadeSoloData == null) ? 0 : umidadeSoloData.hashCode());
		long temp;
		temp = Double.doubleToLongBits(umidadeSoloValor);
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
		UmidadeSoloModel other = (UmidadeSoloModel) obj;
		if (umidadeSoloData == null) {
			if (other.umidadeSoloData != null)
				return false;
		} else if (!umidadeSoloData.equals(other.umidadeSoloData))
			return false;
		if (Double.doubleToLongBits(umidadeSoloValor) != Double.doubleToLongBits(other.umidadeSoloValor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UmidadeSoloModel [umidadeSoloValor=");
		builder.append(umidadeSoloValor);
		builder.append(", umidadeSoloData=");
		builder.append(umidadeSoloData);
		builder.append("]");
		return builder.toString();
	}
	
	

}
