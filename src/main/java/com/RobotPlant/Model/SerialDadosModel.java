package com.RobotPlant.Model;

public class SerialDadosModel {

	private String temperatura;
	private Double tempvalue;
	private String umidadeAr;
	private Double arValue;
	private String umidadeSolo;
	private Double soloValue;



	public void insert(String tipo, String valor) {



	}

	public SerialDadosModel() {
		super();
		// TODO Auto-generated constructor stub
	}



	public SerialDadosModel(String temperatura, Double tempvalue, String umidadeAr, Double arValue, String umidadeSolo,
			Double soloValue) {
		super();
		this.temperatura = temperatura;
		this.tempvalue = tempvalue;
		this.umidadeAr = umidadeAr;
		this.arValue = arValue;
		this.umidadeSolo = umidadeSolo;
		this.soloValue = soloValue;
	}



	public String getTemperatura() {
		return temperatura;
	}
	public void setTemperatura(String temperatura) {
		this.temperatura = temperatura;
	}
	public Double getTempvalue() {
		return tempvalue;
	}
	public void setTempvalue(Double tempvalue) {
		this.tempvalue = tempvalue;
	}
	public String getUmidadeAr() {
		return umidadeAr;
	}
	public void setUmidadeAr(String umidadeAr) {
		this.umidadeAr = umidadeAr;
	}
	public Double getArValue() {
		return arValue;
	}
	public void setArValue(Double arValue) {
		this.arValue = arValue;
	}
	public String getUmidadeSolo() {
		return umidadeSolo;
	}
	public void setUmidadeSolo(String umidadeSolo) {
		this.umidadeSolo = umidadeSolo;
	}
	public Double getSoloValue() {
		return soloValue;
	}
	public void setSoloValue(Double soloValue) {
		this.soloValue = soloValue;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((arValue == null) ? 0 : arValue.hashCode());
		result = prime * result + ((soloValue == null) ? 0 : soloValue.hashCode());
		result = prime * result + ((temperatura == null) ? 0 : temperatura.hashCode());
		result = prime * result + ((tempvalue == null) ? 0 : tempvalue.hashCode());
		result = prime * result + ((umidadeAr == null) ? 0 : umidadeAr.hashCode());
		result = prime * result + ((umidadeSolo == null) ? 0 : umidadeSolo.hashCode());
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
		SerialDadosModel other = (SerialDadosModel) obj;
		if (arValue == null) {
			if (other.arValue != null)
				return false;
		} else if (!arValue.equals(other.arValue))
			return false;
		if (soloValue == null) {
			if (other.soloValue != null)
				return false;
		} else if (!soloValue.equals(other.soloValue))
			return false;
		if (temperatura == null) {
			if (other.temperatura != null)
				return false;
		} else if (!temperatura.equals(other.temperatura))
			return false;
		if (tempvalue == null) {
			if (other.tempvalue != null)
				return false;
		} else if (!tempvalue.equals(other.tempvalue))
			return false;
		if (umidadeAr == null) {
			if (other.umidadeAr != null)
				return false;
		} else if (!umidadeAr.equals(other.umidadeAr))
			return false;
		if (umidadeSolo == null) {
			if (other.umidadeSolo != null)
				return false;
		} else if (!umidadeSolo.equals(other.umidadeSolo))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ModeloTeste [temperatura=");
		builder.append(temperatura);
		builder.append(", tempvalue=");
		builder.append(tempvalue);
		builder.append(", umidadeAr=");
		builder.append(umidadeAr);
		builder.append(", arValue=");
		builder.append(arValue);
		builder.append(", umidadeSolo=");
		builder.append(umidadeSolo);
		builder.append(", soloValue=");
		builder.append(soloValue);
		builder.append("]");
		return builder.toString();
	}



}
