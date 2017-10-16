package com.RobotPlant.Interface;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;

import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.Model.HistoricoModel;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
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
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Historico extends Application {

	public static void main(String[] args) {
		  launch();
		 }
	
	String chValue = null;

	@SuppressWarnings({ "unchecked" })
	@Override
	public void start(Stage primaryStage) throws Exception {

		AnchorPane anchorPane = new AnchorPane();
		anchorPane.prefWidth(800);
		anchorPane.prefHeight(600);
		anchorPane.setLayoutX(0);
		anchorPane.setLayoutY(0);

		Pane pane1 = new Pane();
		pane1.prefWidth(800);
		pane1.prefHeight(600);
		pane1.setLayoutX(0);
		pane1.setLayoutY(0);

		Pane pane2 = new Pane();
		pane2.prefWidth(774);
		pane2.prefHeight(427);
		pane2.setLayoutX(14);
		pane2.setLayoutY(160);

		HBox hBox = new HBox();
		hBox.prefWidth(800);
		hBox.prefHeight(25);
		hBox.setLayoutX(-2);
		hBox.setLayoutY(575);
		
		VBox vbCheckBox = new VBox();
		vbCheckBox.setLayoutX(50);
		vbCheckBox.setLayoutY(50);
		vbCheckBox.setSpacing(10);
		
		VBox vbLabel = new VBox();
		vbLabel.setLayoutX(275);
		vbLabel.setLayoutY(50);
		vbLabel.setSpacing(20);
		
		VBox vbDatePicker = new VBox();
		vbDatePicker.setLayoutX(350);
		vbDatePicker.setLayoutY(50);
		vbDatePicker.setSpacing(10);
		
		VBox vbButtons = new VBox();
		vbButtons.setLayoutX(650);
		vbButtons.setLayoutY(35);
		vbButtons.setSpacing(10);

		Separator separator = new Separator();
		separator.prefWidth(800);
		separator.prefHeight(0);
		separator.setLayoutX(0);
		separator.setLayoutY(573);

		TableView<HistoricoModel> lvDados = new TableView<HistoricoModel>();
		lvDados.prefWidth(774);
		lvDados.prefHeight(427);
		lvDados.setLayoutX(0);
		lvDados.setLayoutY(0);

		TableColumn<HistoricoModel, Integer> column1 = new TableColumn<HistoricoModel, Integer>("Id");
		column1.setPrefWidth(155);
		column1.setCellValueFactory(new PropertyValueFactory<HistoricoModel, Integer>("id"));
		TableColumn<HistoricoModel, String> column2 = new TableColumn<HistoricoModel, String>("Tipo");
		column2.setPrefWidth(155);
		column2.setCellValueFactory(new PropertyValueFactory<HistoricoModel, String>("tipo"));
		TableColumn<HistoricoModel, Double> column3 = new TableColumn<HistoricoModel, Double>("Valor");
		column3.setPrefWidth(155);
		column3.setCellValueFactory(new PropertyValueFactory<HistoricoModel, Double>("valor"));
		TableColumn<HistoricoModel, String> column4 = new TableColumn<HistoricoModel, String>("Planta");
		column4.setPrefWidth(155);
		column4.setCellValueFactory(new PropertyValueFactory<HistoricoModel, String>("planta"));
		TableColumn<HistoricoModel, Date> column5 = new TableColumn<HistoricoModel, Date>("Data/Hora Amostra");
		column5.setPrefWidth(155);
		column5.setCellValueFactory(new PropertyValueFactory<HistoricoModel, Date>("dataAmostra"));		

		lvDados.getColumns().addAll(column1, column2, column3, column4, column5);

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

		Label lblStatus = new Label();
		lblStatus.setText("Status");
		Font font = new Font("System", 14);
		lblStatus.setFont(font);
		lblStatus.setLayoutX(0);
		lblStatus.setLayoutY(0);
		
		Label lblDtInicio = new Label();
		lblDtInicio.setText("Data Inicio");
		
		Label lblDtFim = new Label();
		lblDtFim.setText("Data Fim");
		
		CheckBox cbTemperatura = new CheckBox();
		cbTemperatura.setText("Temperatura");
//		cbTemperatura.setLayoutX(100);
//		cbTemperatura.setLayoutY(550);
		
		CheckBox cbUmidadeAr = new CheckBox();
		cbUmidadeAr.setText("Umidade Ar");
//		cbUmidadeAr.setLayoutX(100);
//		cbUmidadeAr.setLayoutY(500);
		
		CheckBox cbUmidadeSolo = new CheckBox();
		cbUmidadeSolo.setText("Umidade Solo");
//		cbUmidadeSolo.setLayoutX(100);
//		cbUmidadeSolo.setLayoutY(450);
		
		cbTemperatura.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(cbTemperatura.isSelected()) {
					cbUmidadeAr.setSelected(false);
					cbUmidadeSolo.setSelected(false);
					chValue = cbTemperatura.getText();
				}
				
			}
		});
		
		
		
		cbUmidadeAr.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(cbUmidadeAr.isSelected()) {
					cbTemperatura.setSelected(false);
					cbUmidadeSolo.setSelected(false);
					chValue = cbUmidadeAr.getText();
				}
				
			}
		});
		
		cbUmidadeSolo.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(cbUmidadeSolo.isSelected()) {
					cbTemperatura.setSelected(false);
					cbUmidadeAr.setSelected(false);
					chValue = cbUmidadeSolo.getText();
				}
				
			}
		});
/*		
		cbTemperatura.selectedProperty().addListener(new ChangeListener<Boolean>() {
			
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				cbUmidadeAr.setSelected(false);
				cbUmidadeSolo.setSelected(false);
			}
			
			
		});
		
		cbUmidadeAr.selectedProperty().addListener(new ChangeListener<Boolean>() {

			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				cbTemperatura.setSelected(false);
				cbUmidadeSolo.setSelected(false);
			}
			
			
		});
		
		cbUmidadeSolo.selectedProperty().addListener(new ChangeListener<Boolean>() {
			
			@Override
			public void changed(ObservableValue<? extends Boolean> observable, Boolean oldValue, Boolean newValue) {
				cbTemperatura.setSelected(false);
				cbUmidadeAr.setSelected(false);
			}
			
			
		});
*/		
			
		DatePicker dpDtInicio = new DatePicker();
		
		DatePicker dpDtFim = new DatePicker();
		
		Button btnBuscar = new Button();
		btnBuscar.setText("Buscar");
		btnBuscar.getStyleClass().setAll("btn","btn-success");
		//btnBuscar.setDisable(true);
		btnBuscar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {
				 SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
				 lvDados.setItems(TablePop(chValue, Date.valueOf(dpDtInicio.getValue()), Date.valueOf(dpDtFim.getValue())));

			 }
		 });
		
		Button btnLimpar = new Button();
		btnLimpar.setText("Limpar");
		btnLimpar.getStyleClass().setAll("btn","btn-primary");
		btnLimpar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {
				 
			 }
		 });
		
		Button btnVoltar = new Button();
		btnVoltar.setText("Voltar");
		btnVoltar.setLayoutX(14);
		btnVoltar.setLayoutY(62);
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


		pane2.getChildren().add(lvDados);

		hBox.getChildren().add(lblStatus);
		
		vbCheckBox.getChildren().addAll(cbTemperatura, cbUmidadeAr, cbUmidadeSolo);

		vbLabel.getChildren().addAll(lblDtInicio, lblDtFim );
		
		vbDatePicker.getChildren().addAll(dpDtInicio, dpDtFim);
		
		vbButtons.getChildren().addAll(btnBuscar, btnLimpar, btnVoltar);
		
		pane1.getChildren().addAll(pane2, hBox, vbCheckBox, vbLabel, vbDatePicker, vbButtons, separator, menuBar);

		anchorPane.getChildren().add(pane1);

		Scene cena = new Scene(anchorPane, 800, 600);

		cena.getStylesheets().add("bootstrapfx.css");


		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon.png")));
		primaryStage.setTitle("RobotPlant - 0.1 ");
		primaryStage.setResizable(false);
		primaryStage.setScene(cena);
		primaryStage.show();

	}

	public ObservableList<HistoricoModel> TablePop(String tipo, Date dtInicio, Date dtFim) {
		ObservableList<HistoricoModel> data = FXCollections.observableArrayList();
		BuscaDadosDAO dadosDAO = new BuscaDadosDAO();
		try {
			data = dadosDAO.listaDados(data, tipo, dtInicio, dtFim);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return data;


	}
}
