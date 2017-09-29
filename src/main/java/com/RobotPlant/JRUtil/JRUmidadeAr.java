package com.RobotPlant.JRUtil;

import java.util.Date;

public class JRUmidadeAr {

	private int idUmidadeAr;
	private double valorUmidadeAr;
	private Date dataUmidadeAr;
	public JRUmidadeAr() {
		super();
	}
	public JRUmidadeAr(int idUmidadeAr, double valorUmidadeAr, Date dataUmidadeAr) {
		super();
		this.idUmidadeAr = idUmidadeAr;
		this.valorUmidadeAr = valorUmidadeAr;
		this.dataUmidadeAr = dataUmidadeAr;
	}
	public int getIdUmidadeAr() {
		return idUmidadeAr;
	}
	public void setIdUmidadeAr(int idUmidadeAr) {
		this.idUmidadeAr = idUmidadeAr;
	}
	public double getValorUmidadeAr() {
		return valorUmidadeAr;
	}
	public void setValorUmidadeAr(double valorUmidadeAr) {
		this.valorUmidadeAr = valorUmidadeAr;
	}
	public Date getDataUmidadeAr() {
		return dataUmidadeAr;
	}
	public void setDataUmidadeAr(Date dataUmidadeAr) {
		this.dataUmidadeAr = dataUmidadeAr;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUmidadeAr == null) ? 0 : dataUmidadeAr.hashCode());
		result = prime * result + idUmidadeAr;
		long temp;
		temp = Double.doubleToLongBits(valorUmidadeAr);
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
		JRUmidadeAr other = (JRUmidadeAr) obj;
		if (dataUmidadeAr == null) {
			if (other.dataUmidadeAr != null)
				return false;
		} else if (!dataUmidadeAr.equals(other.dataUmidadeAr))
			return false;
		if (idUmidadeAr != other.idUmidadeAr)
			return false;
		if (Double.doubleToLongBits(valorUmidadeAr) != Double.doubleToLongBits(other.valorUmidadeAr))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRUmidadeAr [idUmidadeAr=");
		builder.append(idUmidadeAr);
		builder.append(", valorUmidadeAr=");
		builder.append(valorUmidadeAr);
		builder.append(", dataUmidadeAr=");
		builder.append(dataUmidadeAr);
		builder.append("]");
		return builder.toString();
	}



}
