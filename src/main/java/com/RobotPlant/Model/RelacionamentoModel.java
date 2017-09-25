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
	private int 	id;
	private String	tipo;
	private Double	valor;
	private Date	hora;

	public RelacionamentoModel() {
		super();
	}
	
	public RelacionamentoModel(int id, String tipo, Double valor, Date hora) {
		super();
		this.id = id;
		this.tipo = tipo;
		this.valor = valor;
		this.hora = hora;
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
	public Double getValor() {
		return valor;
	}
	public void setValor(Double valor) {
		this.valor = valor;
	}
	public Date getHora() {
		return hora;
	}
	public void setHora(Date hora) {
		this.hora = hora;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((hora == null) ? 0 : hora.hashCode());
		result = prime * result + id;
		result = prime * result + ((tipo == null) ? 0 : tipo.hashCode());
		result = prime * result + ((valor == null) ? 0 : valor.hashCode());
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
		if (hora == null) {
			if (other.hora != null)
				return false;
		} else if (!hora.equals(other.hora))
			return false;
		if (id != other.id)
			return false;
		if (tipo == null) {
			if (other.tipo != null)
				return false;
		} else if (!tipo.equals(other.tipo))
			return false;
		if (valor == null) {
			if (other.valor != null)
				return false;
		} else if (!valor.equals(other.valor))
			return false;
		return true;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("TesteDados [id=");
		builder.append(id);
		builder.append(", tipo=");
		builder.append(tipo);
		builder.append(", valor=");
		builder.append(valor);
		builder.append(", hora=");
		builder.append(hora);
		builder.append("]");
		return builder.toString();
	}



}
