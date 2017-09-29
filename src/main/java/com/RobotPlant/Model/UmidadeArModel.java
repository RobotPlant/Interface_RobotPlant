package com.RobotPlant.Model;

import java.io.Serializable;
import java.util.Date;

public class UmidadeArModel implements Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	private double umidadeArValor;
	private Date umidadeArData;
	public UmidadeArModel() {
		super();
	}
	public UmidadeArModel(double umidadeArValor, Date umidadeArData) {
		super();
		this.umidadeArValor = umidadeArValor;
		this.umidadeArData = umidadeArData;
	}
	public double getUmidadeArValor() {
		return umidadeArValor;
	}
	public void setUmidadeArValor(double umidadeArValor) {
		this.umidadeArValor = umidadeArValor;
	}
	public Date getUmidadeArData() {
		return umidadeArData;
	}
	public void setUmidadeArData(Date date) {
		this.umidadeArData = date;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((umidadeArData == null) ? 0 : umidadeArData.hashCode());
		long temp;
		temp = Double.doubleToLongBits(umidadeArValor);
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
		UmidadeArModel other = (UmidadeArModel) obj;
		if (umidadeArData == null) {
			if (other.umidadeArData != null)
				return false;
		} else if (!umidadeArData.equals(other.umidadeArData))
			return false;
		if (Double.doubleToLongBits(umidadeArValor) != Double.doubleToLongBits(other.umidadeArValor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UmidadeArModel [umidadeArValor=");
		builder.append(umidadeArValor);
		builder.append(", umidadeArData=");
		builder.append(umidadeArData);
		builder.append("]");
		return builder.toString();
	}



}
