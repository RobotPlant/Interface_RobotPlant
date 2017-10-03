package com.RobotPlant.Interface;

import com.RobotPlant.Model.TemperaturaModel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Report extends Application {

	public static void main(String[] args) {
		  launch();
		 }

	@Override
	public void start(Stage primaryStage) throws Exception {

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.prefHeight(600);
		anchorPane.prefWidth(800);

		Pane pane = new Pane();
		pane.prefWidth(800);
		pane.prefHeight(600);
		pane.setLayoutX(1);
		pane.setLayoutY(0);

		TabPane tabPane = new TabPane();
		tabPane.prefWidth(800);
		tabPane.prefHeight(388);
		tabPane.setLayoutX(1);
		tabPane.setLayoutY(186);

		Tab tab = new Tab();
		tab.setText("Dados");
		tab.closableProperty().set(false);

		ScrollPane scrollPane = new ScrollPane();	//<--- Falta fazer tabs para cada tipo de arquivo.
		scrollPane.prefWidth(800);
		scrollPane.prefHeight(357);
		scrollPane.setLayoutX(0);
		scrollPane.setLayoutY(0);

		VBox cbVbox = new VBox();
		cbVbox.prefWidth(100);
		cbVbox.prefHeight(105);
		cbVbox.setLayoutX(65);
		cbVbox.setLayoutY(44);
		cbVbox.spacingProperty().add(10);

		VBox lblVbox = new VBox();
		lblVbox.prefWidth(52);
		lblVbox.prefHeight(75);
		lblVbox.setLayoutX(214);
		lblVbox.setLayoutY(46);
		lblVbox.spacingProperty().add(20);

		VBox dpVbox = new VBox();
		dpVbox.prefWidth(193);
		dpVbox.prefHeight(89);
		dpVbox.setLayoutX(294);
		dpVbox.setLayoutY(39);
		dpVbox.spacingProperty().add(15);

		HBox hBoxBtn = new HBox();
		hBoxBtn.prefWidth(200);
		hBoxBtn.prefHeight(25);
		hBoxBtn.setLayoutX(566);
		hBoxBtn.setLayoutY(146);
		hBoxBtn.spacingProperty().add(20);

		HBox hBoxStts = new HBox();
		hBoxStts.prefWidth(800);
		hBoxStts.prefHeight(34);
		hBoxStts.setLayoutX(-1);
		hBoxStts.setLayoutY(571);
		hBoxBtn.spacingProperty().add(20);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidth(800);
		menuBar.prefWidth(25);
		menuBar.setLayoutX(1);
		menuBar.setLayoutY(2);

		Menu file = new Menu();
		file.setText("Arquivo");
		Menu edit = new Menu();
		edit.setText("Edite");
		Menu help = new Menu();
		help.setText("Ajuda");
		menuBar.getMenus().addAll(file,edit,help);

		ProgressBar pbStatus = new ProgressBar();
		pbStatus.prefWidth(200);
		pbStatus.prefHeight(41);
		pbStatus.setLayoutX(0);
		pbStatus.setLayoutY(0);

		TableView<TemperaturaModel> tvTemperatura = new TableView<TemperaturaModel>();
		tvTemperatura.prefWidth(787);
		tvTemperatura.prefHeight(359);
		tvTemperatura.setLayoutX(0);
		tvTemperatura.setLayoutY(0);

		CheckBox cbTemperatura = new CheckBox();
		cbTemperatura.setText("Temperatura");


		CheckBox cbUmidadeAr = new CheckBox();
		cbUmidadeAr.setText("Umidade do ar");

		CheckBox cbUmidadeSolo = new CheckBox();
		cbUmidadeSolo.setText("Umidade do solo");

		Label lblDtInicio = new Label();
		lblDtInicio.setText("Inicio do periodo");

		Label lblDtFim = new Label();
		lblDtFim.setText("Final do periodo");

		DatePicker dpDtInicio = new DatePicker();

		DatePicker dpDtFim = new DatePicker();

		Button btnBuscar = new Button();
		btnBuscar.setText("Final do periodo");

		Button btnGerar = new Button();
		btnGerar.setText("Final do periodo");

		Button btnVoltar = new Button();
		btnVoltar.setText("Final do periodo");
		btnVoltar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 Home home = new Home();

				 try {
					 home.start(primaryStage);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		cbVbox.getChildren().addAll(cbTemperatura, cbUmidadeAr, cbUmidadeSolo);

		lblVbox.getChildren().addAll(lblDtInicio, lblDtFim);

		dpVbox.getChildren().addAll(dpDtInicio, dpDtFim);

		hBoxBtn.getChildren().addAll(btnBuscar, btnGerar, btnVoltar);

		hBoxStts.getChildren().addAll(pbStatus);

		scrollPane.setContent(tvTemperatura);

		tab.setContent(scrollPane);

		tabPane.getTabs().add(tab);

		pane.getChildren().addAll(hBoxStts, hBoxBtn, tabPane, menuBar, lblVbox, dpVbox, cbVbox);

		anchorPane.getChildren().add(pane);

		Scene cena = new Scene(anchorPane, 800, 600);

		cena.getStylesheets().add("bootstrapfx.css");


		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon.png")));
		primaryStage.setTitle("RobotPlant - 0.1 ");
		primaryStage.setResizable(false);
		primaryStage.setScene(cena);
		primaryStage.show();

	}
}
