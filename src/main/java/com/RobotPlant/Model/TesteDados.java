package com.RobotPlant.Model;

import java.io.Serializable;
import java.sql.Time;

public class TesteDados implements Serializable {

	/**
	 * @author 14208 - Joao Luiz Gadelha Dias Junior;
	 * @category JavaBean;
	 * @since 2017
	 */
	private static final long serialVersionUID = 1L;
	private int 	id;
	private String	tipo;
	private double	valor;
	private Time	hora;

	public TesteDados() {
		super();
	}
	public TesteDados(int id, String tipo, double valor, Time hora) {
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
	public double getValor() {
		return valor;
	}
	public void setValor(int valor) {
		this.valor = valor;
	}
	public Time getHora() {
		return hora;
	}
	public void setHora(Time hora) {
		this.hora = hora;
	}



	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		//result = prime * result + hora;
		result = prime * result + id;
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
		TesteDados other = (TesteDados) obj;
		if (hora != other.hora)
			return false;
		if (id != other.id)
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
