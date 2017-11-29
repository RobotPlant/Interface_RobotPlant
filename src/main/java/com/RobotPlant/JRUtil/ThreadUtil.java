package com.RobotPlant.JRUtil;

import com.RobotPlant.Interface.Report;

public class ThreadUtil implements Runnable {

	private StringBuffer status;
	private Integer progresso;
	private Report report;

	public ThreadUtil(Report report) {
		this.report = report;
	}

	@Override
	public void run() {
		this.report.setProcessando(true);
		status = new StringBuffer();

		try {
			setProgresso(new Integer(0));
			report.iniciarImportacao();

			// TODO: esse controle deve ser dentro do método que processa
			if (!this.report.isProcessando()) {
				status = new StringBuffer("Operação cancelada pelo usuário!");
				return;
			}

			setProgresso(new Integer(100));
			this.report.setProcessando(false);
			status = new StringBuffer("Operação realizada com sucesso!");
		} catch (Exception e) {
			this.report.setProcessando(false);
			status = new StringBuffer("Erro no processamento: ");
			status.append(e.getMessage());
		}
	}

	public void stop() {
		this.report.setProcessando(false);
	}

	public StringBuffer getStatus() {
		return status;
	}

	public void setStatus(StringBuffer status) {
		this.status = status;
	}

	public Integer getProgresso() {
		return progresso;
	}

	public void setProgresso(Integer progresso) {
		this.progresso = progresso;
	}

}
