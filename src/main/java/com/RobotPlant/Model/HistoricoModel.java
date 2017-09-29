package com.RobotPlant.Model;

import java.sql.Date;

public class HistoricoModel {

	private int id;
	private String tipo;
	private double valor;
	private String planta;
	private Date dataAmostra;

	public HistoricoModel() {
		super();
	}

	public HistoricoModel(int id, String tipo, double valor, String planta, Date dataAmostra) {
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.planta = planta;
		this.dataAmostra = dataAmostra;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public double getValor() {
		return valor;
	}
	public void setValor(double valor) {
		this.valor = valor;
	}
	public String getPlanta() {
		return planta;
	}
	public void setPlanta(String planta) {
		this.planta = planta;
	}
	public Date getDataAmostra() {
		return dataAmostra;
	}
	public void setDataAmostra(Date dataAmostra) {
		this.dataAmostra = dataAmostra;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dataAmostra == null) ? 0 : dataAmostra.hashCode());
		result = prime * result + id;
		result = prime * result + ((planta == null) ? 0 : planta.hashCode());
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		long temp;
		temp = Double.doubleToLongBits(valor);
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
		HistoricoModel other = (HistoricoModel) obj;
		if (dataAmostra == null) {
			if (other.dataAmostra != null)
				return false;
		} else if (!dataAmostra.equals(other.dataAmostra))
			return false;
		if (id != other.id)
			return false;
		if (planta == null) {
			if (other.planta != null)
				return false;
		} else if (!planta.equals(other.planta))
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (Double.doubleToLongBits(valor) != Double.doubleToLongBits(other.valor))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HistoricoModel [id=");
		builder.append(id);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", planta=");
		builder.append(planta);
		builder.append(", dataAmostra=");
		builder.append(dataAmostra);
		builder.append("]");
		return builder.toString();
	}




}
