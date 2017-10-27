package com.RobotPlant.JRUtil.Model;

import java.util.Date;

public class JRUmidadeArModel {

	private int 	idUmidadeAr;
	private int		idPlantacao;
	private int 	idPlanta;
	private String 	tipoAmostra;
	private double 	valorUmidadeAr;
	private Date 	dataUmidadeAr;

	public JRUmidadeArModel() {
		super();
	}

	public JRUmidadeArModel(int idUmidadeAr, int idPlantacao, int idPlanta, String tipoAmostra, double valorUmidadeAr,
			Date dataUmidadeAr) {
		super();
		this.idUmidadeAr = idUmidadeAr;
		this.idPlantacao = idPlantacao;
		this.idPlanta = idPlanta;
		this.tipoAmostra = tipoAmostra;
		this.valorUmidadeAr = valorUmidadeAr;
		this.dataUmidadeAr = dataUmidadeAr;
	}

	public int getIdUmidadeAr() {
		return idUmidadeAr;
	}

	public void setIdUmidadeAr(int idUmidadeAr) {
		this.idUmidadeAr = idUmidadeAr;
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
		result = prime * result + idPlanta;
		result = prime * result + idPlantacao;
		result = prime * result + idUmidadeAr;
		result = prime * result + ((tipoAmostra == null) ? 0 : tipoAmostra.hashCode());
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
		JRUmidadeArModel other = (JRUmidadeArModel) obj;
		if (dataUmidadeAr == null) {
			if (other.dataUmidadeAr != null)
				return false;
		} else if (!dataUmidadeAr.equals(other.dataUmidadeAr))
			return false;
		if (idPlanta != other.idPlanta)
			return false;
		if (idPlantacao != other.idPlantacao)
			return false;
		if (idUmidadeAr != other.idUmidadeAr)
			return false;
		if (tipoAmostra == null) {
			if (other.tipoAmostra != null)
				return false;
		} else if (!tipoAmostra.equals(other.tipoAmostra))
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
		builder.append(", idPlantacao=");
		builder.append(idPlantacao);
		builder.append(", idPlanta=");
		builder.append(idPlanta);
		builder.append(", tipoAmostra=");
		builder.append(tipoAmostra);
		builder.append(", valorUmidadeAr=");
		builder.append(valorUmidadeAr);
		builder.append(", dataUmidadeAr=");
		builder.append(dataUmidadeAr);
		builder.append("]");
		return builder.toString();
	}



}
