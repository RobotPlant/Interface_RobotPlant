package com.RobotPlant.Interface;

import com.RobotPlant.Model.ConexaoModel;

import javafx.application.Application;
import javafx.scene.control.ButtonBar.ButtonData;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Dialog;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;
import javafx.util.Callback;

public class DBConfiguration extends Application{

	@Override
	public void start(Stage palco) throws Exception {

		GridPane gpDados = new GridPane();

		Dialog<ConexaoModel> dialog = new Dialog<>();
		dialog.setTitle("Configure a Conexao");
		dialog.setHeaderText("Digite as configurações válidas de banco de dados MySQL");
		dialog.setResizable(false);

		TextField tfUsuario = new TextField();
		tfUsuario.setPromptText("Digite o nome de usuario");

		TextField tfSenha = new TextField();
		tfSenha.setPromptText("Digite a senha de usuario");

		gpDados.add(tfUsuario, 1, 1);
		gpDados.add(tfSenha, 1, 2);

		dialog.getDialogPane().setContent(gpDados);

		ButtonType btnTestar = new ButtonType("Testar Conexao", ButtonData.OK_DONE);
		dialog.getDialogPane().getButtonTypes().add(btnTestar);

		dialog.setResultConverter(new Callback<ButtonType, ConexaoModel>() {

			@Override
			public ConexaoModel call(ButtonType param) {

				return null;
			}
		});


	}



}
