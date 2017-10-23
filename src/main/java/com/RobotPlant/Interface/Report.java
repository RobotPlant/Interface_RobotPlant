package com.RobotPlant.Interface;

import java.sql.Date;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.JRUtil.ReportsFactory;
import com.RobotPlant.Model.HistoricoModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Service;
import javafx.concurrent.Task;
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
import javafx.scene.control.cell.PropertyValueFactory;
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
					tabPane.getTabs().add(index, tabFactory(cbAtividade.getText(), Date.valueOf(dtinicio.getValue()),Date.valueOf(dtfim.getValue())));
				}*/
				Service service = new Service() {
		            @Override
		            protected Task createTask() {
		                return new Task() {
		                    @Override
		                    protected Object call() throws Exception {
		                        for(int i=0; i<100; i++){
		                            updateProgress(i, 100);
		                            try {
		                                Thread.sleep(100);
		                            } catch (InterruptedException e) {
		                                e.printStackTrace();
		                            }
		                        }
		                        return null;
		                    }
		                };
		            }
		        };
		        pbStatus.progressProperty().bind(service.progressProperty());
		        service.start();

			}
		 });

		Button btnGerar = new Button();
		btnGerar.setText("Gerar");
		btnGerar.getStyleClass().setAll("btn","btn-primary");
		btnGerar.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {
				 ReportsFactory reportsFactory = new ReportsFactory();
				 String caminho = null;
				 String pkg;
				 caminho = this.getClass().getClassLoader().getResource("").getPath();
				 pkg = caminho+"com/RobotPlant/JRUtil/reports/";
				 reportsFactory.createReport(pkg, "Temperatura.jrxml");
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

	private static ObservableList<HistoricoModel> listDados(String tipo, Date dtInicio, Date dtFim) {
		List<HistoricoModel> historicoModels = new ArrayList<HistoricoModel>();
		ObservableList<HistoricoModel> dados = FXCollections.observableArrayList();
		BuscaDadosDAO buscaDadosDAO = new BuscaDadosDAO();
		try {
			historicoModels = buscaDadosDAO.listaDadosGrafico(historicoModels, tipo, dtInicio, dtFim);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		for(int i = 0; i < historicoModels.size(); i++) {
			dados.add(i, historicoModels.get(i));
		}
		return dados;

	}

	@SuppressWarnings("unchecked")
	private static TableView<HistoricoModel> tabviewFactory(ObservableList<HistoricoModel> dados) {

		double size = 150;

		TableView<HistoricoModel> tvDados = new TableView<HistoricoModel>();

		TableColumn<HistoricoModel, Integer> tabId = new TableColumn<>("Id");
		tabId.setPrefWidth(size);
		tabId.setCellValueFactory(new PropertyValueFactory<>("id"));

		TableColumn<HistoricoModel, String> tabPlanta = new TableColumn<>("Amostra");
		tabPlanta.setPrefWidth(size);
		tabPlanta.setCellValueFactory(new PropertyValueFactory<>("planta"));

		TableColumn<HistoricoModel, String> tabTipo = new TableColumn<>("Tipo");
		tabTipo.setPrefWidth(size);
		tabTipo.setCellValueFactory(new PropertyValueFactory<>("tipo"));

		TableColumn<HistoricoModel, Double> tabValor = new TableColumn<>("Valor");
		tabValor.setPrefWidth(size);
		tabValor.setCellValueFactory(new PropertyValueFactory<>("valor"));

		TableColumn<HistoricoModel, Date> tabData = new TableColumn<>("Data / Hora");
		tabData.setPrefWidth(size);
		tabData.setCellValueFactory(new PropertyValueFactory<>("dataAmostra"));

		tvDados.setItems(dados);

		tvDados.getColumns().addAll(tabId, tabPlanta, tabTipo, tabValor, tabData);

		return tvDados;

	}

	private static Tab tabFactory(String tipo, Date dtInicio, Date dtFim) {
		
		ScrollPane scrollPane = new ScrollPane();
		
		switch (tipo) {
		case "Temperatura":
			Tab tabTemperatura = new Tab("Temperatura");
//			tabTemperatura.setClosable(false);
			scrollPane.setContent(tabviewFactory(listDados(tipo, dtInicio, dtFim)));
			tabTemperatura.setContent(scrollPane);
			return tabTemperatura;

		case "Umidade Ar":
			Tab tabUmidadeAr = new Tab("Umidade Ar");
//			tabUmidadeAr.setClosable(false);
			scrollPane.setContent(tabviewFactory(listDados(tipo, dtInicio, dtFim)));
			tabUmidadeAr.setContent(scrollPane);
			return tabUmidadeAr;

		case "Umidade Solo":
			Tab tabUmidadeSolo = new Tab("Umidade Solo");
//			tabUmidadeSolo.setClosable(false);
			scrollPane.setContent(tabviewFactory(listDados(tipo, dtInicio, dtFim)));
			tabUmidadeSolo.setContent(scrollPane);
			return tabUmidadeSolo;

		case "Ativações":
			Tab tabAtivacao = new Tab("Ativações");
//			tabAtivacao.setClosable(false);
			scrollPane.setContent(tabviewFactory(listDados(tipo, dtInicio, dtFim)));
			tabAtivacao.setContent(scrollPane);
			return tabAtivacao;

		default:
			System.out.println("Nenhuma tabela gerada!");
			break;
		}

		return null;

	}

}
