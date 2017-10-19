package com.RobotPlant.Model;

import java.io.Serializable;
import java.sql.Date;
import java.sql.Time;

public class RelacionamentoModel implements Serializable {

	/**
	 * @author 14208 - João Luiz Gadelha Dias Junior;
	 * @category JavaBean;
	 * @since 2017
	 */
	
	private static final long serialVersionUID = 1L;
	private TemperaturaModel temperaturaModel;
	private UmidadeArModel umidadeArModel;
	private UmidadeSoloModel umidadeSoloModel;
	public RelacionamentoModel() {
		super();
		// TODO Auto-generated constructor stub
	}
	public RelacionamentoModel(TemperaturaModel temperaturaModel, UmidadeArModel umidadeArModel,
			UmidadeSoloModel umidadeSoloModel) {
		super();
		this.temperaturaModel = temperaturaModel;
		this.umidadeArModel = umidadeArModel;
		this.umidadeSoloModel = umidadeSoloModel;
	}
	public TemperaturaModel getTemperaturaModel() {
		return temperaturaModel;
	}
	public void setTemperaturaModel(TemperaturaModel temperaturaModel) {
		this.temperaturaModel = temperaturaModel;
	}
	public UmidadeArModel getUmidadeArModel() {
		return umidadeArModel;
	}
	public void setUmidadeArModel(UmidadeArModel umidadeArModel) {
		this.umidadeArModel = umidadeArModel;
	}
	public UmidadeSoloModel getUmidadeSoloModel() {
		return umidadeSoloModel;
	}
	public void setUmidadeSoloModel(UmidadeSoloModel umidadeSoloModel) {
		this.umidadeSoloModel = umidadeSoloModel;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((temperaturaModel == null) ? 0 : temperaturaModel.hashCode());
		result = prime * result + ((umidadeArModel == null) ? 0 : umidadeArModel.hashCode());
		result = prime * result + ((umidadeSoloModel == null) ? 0 : umidadeSoloModel.hashCode());
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
		RelacionamentoModel other = (RelacionamentoModel) obj;
		if (temperaturaModel == null) {
			if (other.temperaturaModel != null)
				return false;
		} else if (!temperaturaModel.equals(other.temperaturaModel))
			return false;
		if (umidadeArModel == null) {
			if (other.umidadeArModel != null)
				return false;
		} else if (!umidadeArModel.equals(other.umidadeArModel))
			return false;
		if (umidadeSoloModel == null) {
			if (other.umidadeSoloModel != null)
				return false;
		} else if (!umidadeSoloModel.equals(other.umidadeSoloModel))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("RelacionamentoModel [temperaturaModel=");
		builder.append(temperaturaModel);
		builder.append(", umidadeArModel=");
		builder.append(umidadeArModel);
		builder.append(", umidadeSoloModel=");
		builder.append(umidadeSoloModel);
		builder.append("]");
		return builder.toString();
	}
	
	
}
