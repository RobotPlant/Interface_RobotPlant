package com.RobotPlant.JRUtil.Model;

import java.util.List;

public class JRRelatorioModel {

	private	List<JRUsuarioModel>	usuarioModels;
	private List<JREmpresaModel>	empresaModels;
	private List<JRTemperaturaModel>	temperaturaModels;
	private List<JRUmidadeArModel>	umidadeArModels;
	private List<JRUmidadeSoloModel>	umidadeSoloModels;
	public JRRelatorioModel() {
		super();
	}
	public JRRelatorioModel(List<JRUsuarioModel> usuarioModels, List<JREmpresaModel> empresaModels,
			List<JRTemperaturaModel> temperaturaModels, List<JRUmidadeArModel> umidadeArModels,
			List<JRUmidadeSoloModel> umidadeSoloModels) {
		super();
		this.usuarioModels = usuarioModels;
		this.empresaModels = empresaModels;
		this.temperaturaModels = temperaturaModels;
		this.umidadeArModels = umidadeArModels;
		this.umidadeSoloModels = umidadeSoloModels;
	}
	public List<JRUsuarioModel> getUsuarioModels() {
		return usuarioModels;
	}
	public void setUsuarioModels(List<JRUsuarioModel> usuarioModels) {
		this.usuarioModels = usuarioModels;
	}
	public List<JREmpresaModel> getEmpresaModels() {
		return empresaModels;
	}
	public void setEmpresaModels(List<JREmpresaModel> empresaModels) {
		this.empresaModels = empresaModels;
	}
	public List<JRTemperaturaModel> getTemperaturaModels() {
		return temperaturaModels;
	}
	public void setTemperaturaModels(List<JRTemperaturaModel> temperaturaModels) {
		this.temperaturaModels = temperaturaModels;
	}
	public List<JRUmidadeArModel> getUmidadeArModels() {
		return umidadeArModels;
	}
	public void setUmidadeArModels(List<JRUmidadeArModel> umidadeArModels) {
		this.umidadeArModels = umidadeArModels;
	}
	public List<JRUmidadeSoloModel> getUmidadeSoloModels() {
		return umidadeSoloModels;
	}
	public void setUmidadeSoloModels(List<JRUmidadeSoloModel> umidadeSoloModels) {
		this.umidadeSoloModels = umidadeSoloModels;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((empresaModels == null) ? 0 : empresaModels.hashCode());
		result = prime * result + ((temperaturaModels == null) ? 0 : temperaturaModels.hashCode());
		result = prime * result + ((umidadeArModels == null) ? 0 : umidadeArModels.hashCode());
		result = prime * result + ((umidadeSoloModels == null) ? 0 : umidadeSoloModels.hashCode());
		result = prime * result + ((usuarioModels == null) ? 0 : usuarioModels.hashCode());
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
		JRRelatorioModel other = (JRRelatorioModel) obj;
		if (empresaModels == null) {
			if (other.empresaModels != null)
				return false;
		} else if (!empresaModels.equals(other.empresaModels))
			return false;
		if (temperaturaModels == null) {
			if (other.temperaturaModels != null)
				return false;
		} else if (!temperaturaModels.equals(other.temperaturaModels))
			return false;
		if (umidadeArModels == null) {
			if (other.umidadeArModels != null)
				return false;
		} else if (!umidadeArModels.equals(other.umidadeArModels))
			return false;
		if (umidadeSoloModels == null) {
			if (other.umidadeSoloModels != null)
				return false;
		} else if (!umidadeSoloModels.equals(other.umidadeSoloModels))
			return false;
		if (usuarioModels == null) {
			if (other.usuarioModels != null)
				return false;
		} else if (!usuarioModels.equals(other.usuarioModels))
			return false;
		return true;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("JRRelatorioModel [usuarioModels=");
		builder.append(usuarioModels);
		builder.append(", empresaModels=");
		builder.append(empresaModels);
		builder.append(", temperaturaModels=");
		builder.append(temperaturaModels);
		builder.append(", umidadeArModels=");
		builder.append(umidadeArModels);
		builder.append(", umidadeSoloModels=");
		builder.append(umidadeSoloModels);
		builder.append("]");
		return builder.toString();
	}



}
