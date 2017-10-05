package com.RobotPlant.Interface;

import com.RobotPlant.Model.TemperaturaModel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.InsetsBuilder;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
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

		AnchorPane anchorDados = new AnchorPane();
//		anchorDados.prefHeight(787);
	//	anchorDados.prefWidth(200);

		AnchorPane scrollDados = new AnchorPane();
//		scrollDados.prefHeight(787);
	//	scrollDados.prefWidth(200);

		AnchorPane anchorRelatorio = new AnchorPane();
//		anchorRelatorio.prefHeight(200);
	//	anchorRelatorio.prefWidth(180);

		Pane pane = new Pane();
//		pane.prefWidth(800);
	//	pane.prefHeight(600);
		//pane.setLayoutX(0);
	//	pane.setLayoutY(0);

		BorderPane borderPane = new BorderPane();
	//	borderPane.prefWidth(800);
	//	borderPane.prefHeight(10);
		borderPane.setLayoutX(1);
		borderPane.setLayoutY(168);

		TabPane tabPane = new TabPane();
	//	tabPane.prefWidth(800);
	//	tabPane.prefHeight(200);
		tabPane.setLayoutX(1);
		tabPane.setLayoutY(150);

		Tab tab = new Tab();
		tab.setText("Dados");
		tab.closableProperty().set(false);

		ScrollPane scrollPane = new ScrollPane();	//<--- Falta fazer tabs para cada tipo de arquivo.
		scrollPane.prefWidth(800);
		scrollPane.prefHeight(100);
		scrollPane.setLayoutX(0);
		scrollPane.setLayoutY(0);

		VBox cbVbox = new VBox();
		cbVbox.prefWidth(100);
		cbVbox.prefHeight(105);
		cbVbox.setLayoutX(65);
		cbVbox.setLayoutY(44);
		cbVbox.setPadding(new Insets(10, 10, 10, 10));
		cbVbox.setSpacing(10);

		VBox lblVbox = new VBox();
		lblVbox.prefWidth(52);
		lblVbox.prefHeight(75);
		lblVbox.setLayoutX(214);
		lblVbox.setLayoutY(44);
		lblVbox.setPadding(new Insets(10, 5, 5, 5));
		lblVbox.setSpacing(20);

		VBox dpVbox = new VBox();
		dpVbox.prefWidth(193);
		dpVbox.prefHeight(89);
		dpVbox.setLayoutX(310);
		dpVbox.setLayoutY(39);
		dpVbox.setPadding(new Insets(10, 10, 10, 10));
		dpVbox.setSpacing(15);

		HBox hBoxBtn = new HBox();
		hBoxBtn.prefWidth(200);
		hBoxBtn.prefHeight(25);
		hBoxBtn.setLayoutX(550);
		hBoxBtn.setLayoutY(40);
		hBoxBtn.setPadding(new Insets(10, 10, 10, 10));
		hBoxBtn.setSpacing(20);

		VBox vBoxStts = new VBox();
		vBoxStts.prefWidth(400);
		vBoxStts.prefHeight(100);
		vBoxStts.setLayoutX(550);
		vBoxStts.setLayoutY(90);
		vBoxStts.setPadding(new Insets(5, 5, 5, 0));
		vBoxStts.setSpacing(10);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidth(800);
		menuBar.prefHeight(25);
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
		pbStatus.prefHeight(25);

		TableView<TemperaturaModel> tvTemperatura = new TableView<TemperaturaModel>();
		tvTemperatura.prefWidth(774);
		tvTemperatura.prefHeight(400);
		tvTemperatura.setLayoutX(0);
		tvTemperatura.setLayoutY(0);

		TableColumn<TemperaturaModel, ?> tab1 = new TableColumn<>("Tab1");
		tab1.setPrefWidth(200);
		TableColumn<TemperaturaModel, ?> tab2 = new TableColumn<>("Tab1");
		tab2.setPrefWidth(200);
		TableColumn<TemperaturaModel, ?> tab3 = new TableColumn<>("Tab1");
		tab3.setPrefWidth(200);
		TableColumn<TemperaturaModel, ?> tab4 = new TableColumn<>("Tab1");
		tab4.setPrefWidth(200);
		tvTemperatura.getColumns().addAll(tab1, tab2, tab3, tab4);

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
		btnBuscar.setText("Buscar");

		Button btnGerar = new Button();
		btnGerar.setText("Gerar");

		Button btnVoltar = new Button();
		btnVoltar.setText("Voltar");
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

		vBoxStts.getChildren().addAll(pbStatus);

		scrollDados.getChildren().add(tvTemperatura);

		scrollPane.setContent(scrollDados);

		anchorDados.getChildren().add(scrollPane);

		tab.setContent(anchorDados);

		tabPane.getTabs().add(tab);

		borderPane.setCenter(tabPane);

		pane.getChildren().addAll(vBoxStts, hBoxBtn, borderPane, menuBar, lblVbox, dpVbox, cbVbox);

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
