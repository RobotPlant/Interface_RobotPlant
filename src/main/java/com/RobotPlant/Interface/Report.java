package com.RobotPlant.Interface;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TabPane;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
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

		ScrollPane scrollPane = new ScrollPane();	//<--- Falta fazer tabs para cada tipo de arquivo.


		HBox hBoxBtn = new HBox();


		HBox hBoxStts = new HBox();


		ProgressBar pbStatus = new ProgressBar();

	//	TableView<S> tvTemperatura = new TableView<>(); <

		CheckBox cbExample1 = new CheckBox();

		CheckBox cbExample2 = new CheckBox();

		CheckBox cbExample3 = new CheckBox();

		Label lblDtInicio = new Label();

		Label lblDtFim = new Label();

		DatePicker dpDtInicio = new DatePicker();

		DatePicker dpDtFim = new DatePicker();

		Button btnBuscar = new Button();

		Button btnGerar = new Button();

		Button btnVoltar = new Button();
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


		pane.getChildren().addAll();

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
