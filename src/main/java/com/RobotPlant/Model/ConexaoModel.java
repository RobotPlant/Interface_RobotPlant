package com.RobotPlant.Model;

import java.sql.Connection;

public class ConexaoModel {

	private Connection conn;
	private String url;
	private String user;
	private String senha;
	private String drive;
	private String caminhoDrive;

	public ConexaoModel() {
		super();
	}

	public ConexaoModel(Connection conn, String url, String user, String senha, String drive, String caminhoDrive) {
		super();
		this.conn = conn;
		this.url = url;
		this.user = user;
		this.senha = senha;
		this.drive = drive;
		this.caminhoDrive = caminhoDrive;
	}

	public Connection getConn() {
		return conn;
	}

	public void setConn(Connection conn) {
		this.conn = conn;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	public String getUser() {
		return user;
	}

	public void setUser(String user) {
		this.user = user;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getDrive() {
		return drive;
	}

	public void setDrive(String drive) {
		this.drive = drive;
	}

	public String getCaminhoDrive() {
		return caminhoDrive;
	}

	public void setCaminhoDrive(String caminhoDrive) {
		this.caminhoDrive = caminhoDrive;
	}





}
