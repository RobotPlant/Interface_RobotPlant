package com.RobotPlant.Model;

public class ReportPath {

	private String caminho;
	private String packageCaminho;

	public ReportPath() {
		super();
	}

	public ReportPath(String caminho, String packageCaminho) {
		this.caminho = getClass().getClassLoader().getResource("").getPath();
		this.packageCaminho = this.caminho + "com/RobotPlant/JRUtil/reports";
	}

	public String getCaminho() {
		return caminho;
	}

	public void setCaminho(String caminho) {
		this.caminho = caminho;
	}

	public String getPackageCaminho() {
		return packageCaminho;
	}

	public void setPackageCaminho(String packageCaminho) {
		this.packageCaminho = packageCaminho;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((caminho == null) ? 0 : caminho.hashCode());
		result = prime * result + ((packageCaminho == null) ? 0 : packageCaminho.hashCode());
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
		ReportPath other = (ReportPath) obj;
		if (caminho == null) {
			if (other.caminho != null)
				return false;
		} else if (!caminho.equals(other.caminho))
			return false;
		if (packageCaminho == null) {
			if (other.packageCaminho != null)
				return false;
		} else if (!packageCaminho.equals(other.packageCaminho))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("ReportPath [caminho=");
		builder.append(caminho);
		builder.append(", packageCaminho=");
		builder.append(packageCaminho);
		builder.append("]");
		return builder.toString();
	}


}
