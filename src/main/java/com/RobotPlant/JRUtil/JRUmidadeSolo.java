package com.RobotPlant.JRUtil;

import java.util.Date;

public class JRUmidadeSolo {

	private int idUmidadeSolo;
	private double valorUmidadeSolo;
	private Date dataUmidadeSolo;
	public JRUmidadeSolo() {
		super();
	}
	public JRUmidadeSolo(int idUmidadeSolo, double valorUmidadeSolo, Date dataUmidadeSolo) {
		super();
		this.idUmidadeSolo = idUmidadeSolo;
		this.valorUmidadeSolo = valorUmidadeSolo;
		this.dataUmidadeSolo = dataUmidadeSolo;
	}
	public int getIdUmidadeSolo() {
		return idUmidadeSolo;
	}
	public void setIdUmidadeSolo(int idUmidadeSolo) {
		this.idUmidadeSolo = idUmidadeSolo;
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
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataUmidadeSolo == null) ? 0 : dataUmidadeSolo.hashCode());
		result = prime * result + idUmidadeSolo;
		long temp;
		temp = Double.doubleToLongBits(valorUmidadeSolo);
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
		JRUmidadeSolo other = (JRUmidadeSolo) obj;
		if (dataUmidadeSolo == null) {
			if (other.dataUmidadeSolo != null)
				return false;
		} else if (!dataUmidadeSolo.equals(other.dataUmidadeSolo))
			return false;
		if (idUmidadeSolo != other.idUmidadeSolo)
			return false;
		if (Double.doubleToLongBits(valorUmidadeSolo) != Double.doubleToLongBits(other.valorUmidadeSolo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRUmidadeSolo [idUmidadeSolo=");
		builder.append(idUmidadeSolo);
		builder.append(", valorUmidadeSolo=");
		builder.append(valorUmidadeSolo);
		builder.append(", dataUmidadeSolo=");
		builder.append(dataUmidadeSolo);
		builder.append("]");
		return builder.toString();
	}



}
