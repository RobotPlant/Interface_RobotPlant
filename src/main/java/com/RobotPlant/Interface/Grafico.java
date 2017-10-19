package com.RobotPlant.Interface;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.Model.HistoricoModel;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

	public class Grafico extends Application {
	
	public static void main(String[] args) {
		launch();
	
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
	
		AnchorPane anchorPane = new AnchorPane();
		anchorPane.prefHeight(600);
		anchorPane.prefWidth(800);

		Pane pane = new Pane();

		TabPane tabPane = new TabPane();
		tabPane.prefWidth(760);
		tabPane.prefHeight(400);
		tabPane.setLayoutX(20);
		tabPane.setLayoutY(150);
		tabPane.setPrefSize(760, 400);

		VBox cbVbox = new VBox();
		cbVbox.setLayoutX(50);
		cbVbox.setLayoutY(50);
		cbVbox.setSpacing(10);

		VBox lblVbox = new VBox();
		lblVbox.setLayoutX(225);
		lblVbox.setLayoutY(50);
		lblVbox.setSpacing(20);

		VBox dpVbox = new VBox();
		dpVbox.setLayoutX(350);
		dpVbox.setLayoutY(50);
		dpVbox.setSpacing(10);

		VBox vBoxBtn = new VBox();
		vBoxBtn.setLayoutX(650);
		vBoxBtn.setLayoutY(30);
		vBoxBtn.setSpacing(10);

		VBox vBoxStts = new VBox();
		vBoxStts.setPrefSize(220, 30);
		vBoxStts.setLayoutX(350);
		vBoxStts.setLayoutY(118);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidth(800);
		menuBar.prefHeight(25);
		menuBar.setPrefSize(800, 25);
		menuBar.setLayoutX(0);
		menuBar.setLayoutY(0);
		
		ProgressBar pbStatus = new ProgressBar();
		pbStatus.prefWidth(200);
		pbStatus.prefHeight(30);
		pbStatus.setPrefSize(200, 30);

		Menu file = new Menu();
		file.setText("Arquivo");
		Menu edit = new Menu();
		edit.setText("Edite");
		Menu help = new Menu();
		help.setText("Ajuda");
		menuBar.getMenus().addAll(file,edit,help);
		
		CheckBox cbTemperatura = new CheckBox();
		cbTemperatura.setText("Temperatura");

		CheckBox cbUmidadeAr = new CheckBox();
		cbUmidadeAr.setText("Umidade Ar");

		CheckBox cbUmidadeSolo = new CheckBox();
		cbUmidadeSolo.setText("Umidade Solo");

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
		
			@Override
			public void handle(ActionEvent event) {
				int index = tabPane.getTabs().lastIndexOf(null);
				if(cbTemperatura.isSelected()) {
					index++;
					tabPane.getTabs().add(index, tabFactory(cbTemperatura.getText(), Date.valueOf(dpDtInicio.getValue()),Date.valueOf(dpDtFim.getValue())));
				} if(cbUmidadeAr.isSelected()) {
					index++;
					tabPane.getTabs().add(index, tabFactory(cbUmidadeAr.getText(), Date.valueOf(dpDtInicio.getValue()),Date.valueOf(dpDtFim.getValue())));
				} if (cbUmidadeSolo.isSelected()) {
					index++;
					tabPane.getTabs().add(index, tabFactory(cbUmidadeSolo.getText(), Date.valueOf(dpDtInicio.getValue()),Date.valueOf(dpDtFim.getValue())));
				} /*if (cbAtividade.isSelected()) {
					index++;
					tabPane.getTabs().add(index, tabFactory(cbAtividade.getText(), Date.valueOf(dpDtInicio.getValue()),Date.valueOf(dpDtFim.getValue())));
				}*/
				
				}
		});
		
		Button btnLimpar = new Button();
		btnLimpar.setText("Limpar");
		btnLimpar.getStyleClass().setAll("btn","btn-primary");
		btnLimpar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 try {
					 tabPane.getTabs().clear();
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
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

		vBoxBtn.getChildren().addAll(btnBuscar, btnLimpar, btnVoltar);

		vBoxStts.getChildren().addAll(pbStatus);

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
	
	private static List<HistoricoModel> listDados(String tipo, Date dtInicio, Date dtFim) {
		List<HistoricoModel> historicoModels = new ArrayList<HistoricoModel>();
		BuscaDadosDAO buscaDadosDAO = new BuscaDadosDAO();
		try {
			historicoModels = buscaDadosDAO.listaDadosGrafico(historicoModels, tipo, dtInicio, dtFim);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
		return historicoModels;
		
	}
	
	
	private static LineChart<String, Number> chartFactory(List<HistoricoModel> dados, String tipo) {
	
		final CategoryAxis xAxis = new CategoryAxis();
	    final NumberAxis yAxis = new NumberAxis();
	    final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis,yAxis);
	    lineChart.setTitle(tipo);
	
	    HistoricoModel model = null;
	
	    //defining a series
	    @SuppressWarnings("rawtypes")
		final XYChart.Series series = new XYChart.Series();
	    series.setName(tipo);
	
	    //populating the series with data
	    for(int i = 0; i < dados.size(); i++) {
	    	model = new HistoricoModel();
	        model = dados.get(i);
	        series.getData().add(new XYChart.Data(model.getDataAmostra().toString(), model.getValor()));
	    }
	    lineChart.getData().add(series);
	
	    return lineChart;
	
	}
	
	private static Tab tabFactory(String tipo, Date dtInicio, Date dtFim) {
	
	switch (tipo) {
	case "Temperatura":
		Tab tabTemperatura = new Tab("Temperatura");
	// 	tabTemperatura.setClosable(false);
		tabTemperatura.setContent(chartFactory(listDados(tipo, dtInicio, dtFim), tipo));
		return tabTemperatura;
	
	case "Umidade Ar":
		Tab tabUmidadeAr = new Tab("Umidade Ar");
	// 	tabUmidadeAr.setClosable(false);
		tabUmidadeAr.setContent(chartFactory(listDados(tipo, dtInicio, dtFim), tipo));
	return tabUmidadeAr;
	
	case "Umidade Solo":
		Tab tabUmidadeSolo = new Tab("Umidade Solo");
	// 	tabUmidadeSolo.setClosable(false);
		tabUmidadeSolo.setContent(chartFactory(listDados(tipo, dtInicio, dtFim), tipo));
	return tabUmidadeSolo;
	
	case "Ativações":
		Tab tabAtivacao = new Tab("Ativações");
	// 	tabAtivacao.setClosable(false);
		tabAtivacao.setContent(chartFactory(listDados(tipo, dtInicio, dtFim), tipo));
	return tabAtivacao;
	
	default:
		System.out.println("Nenhuma tabela gerada!");
	break;
	}
	
	return null;
	
	}

}
