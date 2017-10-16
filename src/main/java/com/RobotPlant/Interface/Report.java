package com.RobotPlant.Interface;

import java.sql.Date;
import java.sql.SQLException;

import org.eclipse.jdt.internal.compiler.ast.ThrowStatement;

import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.Model.HistoricoModel;
import com.RobotPlant.Model.TemperaturaModel;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Report extends Application {

	public static void main(String[] args) {
		  launch();
		 }
	
	String[] tipo = null;

	@SuppressWarnings("unchecked")
	@Override
	public void start(Stage primaryStage) throws Exception {

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.prefHeight(600);
		anchorPane.prefWidth(800);

		Pane pane = new Pane();
//		pane.prefWidth(800);
	//	pane.prefHeight(600);
		//pane.setLayoutX(0);
	//	pane.setLayoutY(0);		

		TabPane tabPane = new TabPane();
		tabPane.prefWidth(760);
		tabPane.prefHeight(400);
		tabPane.setLayoutX(20);
		tabPane.setLayoutY(150);
		tabPane.setPrefSize(760, 400);

		Tab tab = new Tab();
		tab.setText("Dados");
		tab.closableProperty().set(false);

		ScrollPane scrollPane = new ScrollPane();	//<--- Falta fazer tabs para cada tipo de arquivo.
		scrollPane.prefWidth(760);
		scrollPane.prefHeight(1000);
		scrollPane.setPrefSize(760, 1000);
//		scrollPane.setLayoutX(0);
//		scrollPane.setLayoutY(0);

		VBox cbVbox = new VBox();
//		cbVbox.prefWidth(100);
//		cbVbox.prefHeight(105);
		cbVbox.setLayoutX(50);
		cbVbox.setLayoutY(50);
//		cbVbox.setPadding(new Insets(10, 10, 10, 10));
		cbVbox.setSpacing(10);

		VBox lblVbox = new VBox();
//		lblVbox.prefWidth(52);
//		lblVbox.prefHeight(75);
		lblVbox.setLayoutX(225);
		lblVbox.setLayoutY(50);
//		lblVbox.setPadding(new Insets(10, 5, 5, 5));
		lblVbox.setSpacing(20);

		VBox dpVbox = new VBox();
//		dpVbox.prefWidth(193);
//		dpVbox.prefHeight(89);
		dpVbox.setLayoutX(350);
		dpVbox.setLayoutY(50);
//		dpVbox.setPadding(new Insets(10, 10, 10, 10));
		dpVbox.setSpacing(10);

		VBox vBoxBtn = new VBox();
//		vBoxBtn.prefWidth(200);
//		vBoxBtn.prefHeight(25);
		vBoxBtn.setLayoutX(650);
		vBoxBtn.setLayoutY(30);
//		vBoxBtn.setPadding(new Insets(10, 10, 10, 10));
		vBoxBtn.setSpacing(10);

		VBox vBoxStts = new VBox();
		vBoxStts.prefWidth(220);
		vBoxStts.prefHeight(40);
		vBoxStts.setPrefSize(220, 30);
		vBoxStts.setLayoutX(350);
		vBoxStts.setLayoutY(118);
//		vBoxStts.setPadding(new Insets(5, 5, 5, 0));
//		vBoxStts.setSpacing(10);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidth(800);
		menuBar.prefHeight(25);
		menuBar.setPrefSize(800, 25);
		menuBar.setLayoutX(0);
		menuBar.setLayoutY(0);

		Menu file = new Menu();
		file.setText("Arquivo");
		Menu edit = new Menu();
		edit.setText("Edite");
		Menu help = new Menu();
		help.setText("Ajuda");
		menuBar.getMenus().addAll(file,edit,help);

		ProgressBar pbStatus = new ProgressBar();
		pbStatus.prefWidth(200);
		pbStatus.prefHeight(30);
		pbStatus.setPrefSize(200, 30);

		TableView<TemperaturaModel> tvDados = new TableView<TemperaturaModel>();
		tvDados.prefWidth(600);
		tvDados.prefHeight(100);
		tvDados.setPrefSize(760, 100);
		tvDados.setLayoutX(0);
		tvDados.setLayoutY(0);
		
		//Criar método de fábrica de celulas.

		TableColumn<TemperaturaModel, ?> tab1 = new TableColumn<>("Tab1");
		tab1.setPrefWidth(100);
		TableColumn<TemperaturaModel, ?> tab2 = new TableColumn<>("Tab1");
		tab2.setPrefWidth(100);
		TableColumn<TemperaturaModel, ?> tab3 = new TableColumn<>("Tab1");
		tab3.setPrefWidth(100);
		TableColumn<TemperaturaModel, ?> tab4 = new TableColumn<>("Tab1");
		tab4.setPrefWidth(100);
		tvDados.getColumns().addAll(tab1, tab2, tab3, tab4);

		CheckBox cbTemperatura = new CheckBox();
		cbTemperatura.setText("Temperatura");
		cbTemperatura.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tipo[0] = cbTemperatura.getText(); 
			}
		});
		
		CheckBox cbUmidadeAr = new CheckBox();
		cbUmidadeAr.setText("Umidade ar");
		cbUmidadeAr.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tipo[1] = cbUmidadeAr.getText();				
			}
		});
		
		CheckBox cbUmidadeSolo = new CheckBox();
		cbUmidadeSolo.setText("Umidade solo");
		cbUmidadeSolo.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				tipo[2] = cbUmidadeSolo.getText();				
			}
		});

		Label lblDtInicio = new Label();
		lblDtInicio.setText("Periodo inicial");

		Label lblDtFim = new Label();
		lblDtFim.setText("Periodo final");

		DatePicker dpDtInicio = new DatePicker();

		DatePicker dpDtFim = new DatePicker();

		Button btnBuscar = new Button();
		btnBuscar.setText("Buscar");
		btnBuscar.getStyleClass().setAll("btn","btn-success");
		btnBuscar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {
				 BuscaDadosDAO buscaDadosDAO = new BuscaDadosDAO();
				 ObservableList<HistoricoModel> dados = FXCollections.observableArrayList();
				 for(int i =0; i < tipo.length; i++) {
					 try {
						buscaDadosDAO.listaDados(dados, tipo[i], Date.valueOf(dpDtInicio.getValue()), Date.valueOf(dpDtFim.getValue()));
					} catch (SQLException e) {
						throw new RuntimeException(e);
					}
				 }
			 }
		 });
		
		Button btnGerar = new Button();
		btnGerar.setText("Gerar");
		btnGerar.getStyleClass().setAll("btn","btn-primary");
		btnGerar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

			 }
		 });
		
		Button btnVoltar = new Button();
		btnVoltar.setText("Voltar");
		btnVoltar.getStyleClass().setAll("btn","btn-danger");
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

		vBoxBtn.getChildren().addAll(btnBuscar, btnGerar, btnVoltar);

		vBoxStts.getChildren().addAll(pbStatus);
		
		scrollPane.setContent(tvDados);
		
		tab.setContent(scrollPane);

		tabPane.getTabs().add(tab);

		pane.getChildren().addAll(vBoxStts, vBoxBtn, tabPane, menuBar, lblVbox, dpVbox, cbVbox);

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
