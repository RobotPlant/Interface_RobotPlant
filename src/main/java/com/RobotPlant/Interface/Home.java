package com.RobotPlant.Interface;

import static jssc.SerialPort.MASK_RXCHAR;

import java.sql.Date;
import java.sql.SQLException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.List;
import java.util.Random;
import java.util.TimeZone;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.kordamp.bootstrapfx.scene.layout.Panel;

import com.RobotPlant.ArduinoUtil.ArduinoSC;
import com.RobotPlant.CharTest.ChartGrid;
import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.Model.HistoricoModel;
import com.RobotPlant.Model.TemperaturaModel;
import com.RobotPlant.Model.UmidadeArModel;
import com.RobotPlant.Model.UmidadeSoloModel;
import com.RobotPlant.ArduinoUtil.SerialPortCom;


import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.property.ObjectProperty;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ListChangeListener;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.geometry.Side;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.chart.XYChart.Series;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.ListView;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.image.Image;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.Material;
import javafx.stage.Stage;
import javafx.util.Duration;
import jssc.SerialPort;
import jssc.SerialPortEvent;
import jssc.SerialPortException;

@SuppressWarnings("unused")
public class Home extends Application {
	int i = 0;
	int group[] = new int[10];
	SerialPort arduinoPort = null;
	ObservableList<String> portList;
	BuscaDadosDAO dadosDAO = null;

	TemperaturaModel temperaturaModel = new TemperaturaModel();
	UmidadeArModel arModel = new UmidadeArModel();
	UmidadeSoloModel soloModel = new UmidadeSoloModel();

	 public static void main(String[] args) {
	  launch();
	 }

	 @SuppressWarnings({ "unchecked", "rawtypes" })
	 @Override
	 public void start(final Stage palco) throws Exception {

		 TimeZone.setDefault(TimeZone.getTimeZone("GMT"));
     	 Calendar.getInstance(TimeZone.getDefault());

		 AnchorPane anchorPane = new AnchorPane();

		 Pane pane = new Pane();
		 pane.prefWidth(800);
		 pane.prefHeight(600);
		 pane.setLayoutX(0);
		 pane.setLayoutY(0);

		 TabPane tabpane = new TabPane();
		 tabpane.tabClosingPolicyProperty();
		 tabpane.prefWidth(415);
		 tabpane.prefHeight(325);
		 tabpane.tabMinWidthProperty().add(0);
		 tabpane.tabMinHeightProperty().add(0);
		 tabpane.tabMaxWidthProperty().add(1.7976931348623157E308);
		 tabpane.setLayoutX(300);
		 tabpane.setLayoutY(30);
		 
		 VBox vbCheckBox = new VBox();
		 //vbCheckBox.setPrefSize(prefWidth, prefHeight);
		 vbCheckBox.setLayoutX(500);
		 vbCheckBox.setLayoutY(470);
		 vbCheckBox.setSpacing(10);
		 
		 Tab dados = new Tab();
		 dados.setText("Dados");
		 dados.closableProperty().set(false);

		 Tab grafico = new Tab();
		 grafico.setText("Gráfico");
		 grafico.closableProperty().set(false);


		 prepareData();  //Seta os valores do array para 0

		 BuscaDadosDAO dadosDAO = new BuscaDadosDAO();

		 final CategoryAxis xAxis = new CategoryAxis();

		 final NumberAxis yAxis = new NumberAxis();

		 final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis, yAxis);
		 xAxis.setLabel("Tempo");
		 yAxis.setLabel("Valor");

		 final XYChart.Series<String, Number> seriesTemperatura = new XYChart.Series<String, Number>();
//		 seriesTemperatura.setName("Temperatura");

		 final XYChart.Series<String, Number> seriesUmidadeAr = new XYChart.Series<String, Number>();
//		 series2.setName("Umidade Ar");

		 final XYChart.Series<String, Number> seriesUmidadeSolo = new XYChart.Series<String, Number>();
//		 series3.setName("Umidade Solo");

		 lineChart.getData().addAll(seriesTemperatura, seriesUmidadeAr, seriesUmidadeSolo);


		// ChartGrid chartGrid = new ChartGrid();
		 final Pos pos = null;
		 lineChart.setOnMouseClicked(new EventHandler<MouseEvent>() {
	          public void handle(MouseEvent t) {
	        	  lineChart.getParent().setMouseTransparent(true);
	        	  lineChart.toFront();
	          }
	      });
		// chartGrid.setChartGridPos(pos , lineChart);

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

		 //final ArduinoSC arduinoSC = new ArduinoSC();
		 //arduinoSC.DetectaPorta();
		 SerialPortCom serialPortCom = new SerialPortCom();
		 ObservableList<String> arduinoDados = FXCollections.observableArrayList();
		 final ComboBox comboBoxPorts = new ComboBox(serialPortCom.getAvailableSerialPorts());
		 comboBoxPorts.setPromptText("Porta");
		 comboBoxPorts.setLayoutX(350);
		 comboBoxPorts.setLayoutY(470);
		 comboBoxPorts.valueProperty().addListener(new ChangeListener<String>() {
			 //Deve-se alterar para receber uma lista dos dados da porta serial
			 public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				 dados.getContent();
				 try {
					 serialPortCom.initialize(newValue, arduinoDados);
				} catch (Exception e) {
					throw new RuntimeException(e); 
				}
				 //Animation(lineChart, seriesTemperatura, arduinoSC.SerialConnection(newValue, seriesTemperatura));

			 }
		 });
		 ListView<String> lvDados = new ListView<String>();
		 arduinoDados.addListener(new ListChangeListener<String>() {

			@Override
			public void onChanged(ListChangeListener.Change<? extends String> c) {
				System.out.println("Mudança: "+c);
					lvDados.setItems(arduinoDados);
			}
		 });				
		 
		 CheckBox cbTemperatura = new CheckBox("Temperatura");
		 cbTemperatura.setSelected(true);
		 cbTemperatura.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				if(!cbTemperatura.isSelected()) {
					System.out.println("Não Estou selecionado");
				}
				
			}
		});
		 CheckBox cbUmidadeAr = new CheckBox("Umidade Ar");
		 cbUmidadeAr.setSelected(true);
		 cbUmidadeAr.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if(!cbUmidadeAr.isSelected()) {
						System.out.println("Não Estou selecionado");
					}
					
				}
			});
		 CheckBox cbUmidadeSolo = new CheckBox("Umidade Solo");
		 cbUmidadeSolo.setSelected(true);
		 cbUmidadeSolo.setOnAction(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent event) {
					if(!cbUmidadeSolo.isSelected()) {
						System.out.println("Não Estou selecionado");
					}
					
				}
			});
		 
		 
		 
		 Timeline animation = new Timeline();
		 animation.getKeyFrames()
		 .add(new KeyFrame(Duration.millis(10000), new EventHandler<ActionEvent>() {
			 
			 public void handle(ActionEvent actionEvent) {
				 i++;
				 DateFormat format = new SimpleDateFormat("HH:mm:ss");
				 
					 if(cbTemperatura.isSelected()) {
						 seriesFactory(seriesTemperatura, cbTemperatura.getText());
					 } if(cbUmidadeAr.isSelected()) {
						 seriesFactory(seriesUmidadeAr, cbUmidadeAr.getText());
					 } if(cbUmidadeSolo.isSelected()) {
						 seriesFactory(seriesUmidadeSolo, cbUmidadeSolo.getText());
					 }
					 /* if (new BuscaDadosDAO().verificaId(i,"temperatura")) {
						 temperaturaModel = new BuscaDadosDAO().buscaTemperatura(i);
						 series1.getData().add(new XYChart.Data<String, Number>(format.format(temperaturaModel.getTemperaturaData()).toString(), temperaturaModel.getTemperaturaValor()));
					 } if (new BuscaDadosDAO().verificaId(i,"umidade_ar")) {
						 arModel = new BuscaDadosDAO().buscaUmidadeAr(i);
						 series2.getData().add(new XYChart.Data<String, Number>(format.format(arModel.getUmidadeArData()), arModel.getUmidadeArValor()));
					 } if(new BuscaDadosDAO().verificaId(i,"umidade_solo")) {
						 soloModel = new BuscaDadosDAO().buscaUmidadeSolo(i);
						 series3.getData().add(new XYChart.Data<String, Number>(format.format(soloModel.getUmidadeSoloData()).toString(), soloModel.getUmidadeSoloValor()));
					 } else {
						 i=1;
					 }*/				  
				 if (seriesTemperatura.getData().size() > 30) {
					 seriesTemperatura.getData().remove(0);
				 }
				 if (seriesUmidadeAr.getData().size() > 30) {
					 seriesUmidadeAr.getData().remove(0);
				 }
				 if (seriesUmidadeSolo.getData().size() > 30) {
					 seriesUmidadeSolo.getData().remove(0);
				 }
				 animation.stop();
			 }
		 }));
		 
		 animation.setCycleCount(javafx.animation.Animation.INDEFINITE);
		 animation.play();

		 Button btnStatus = new Button();
		 btnStatus.setDisable(true);
		 btnStatus.setText("Status");
		 btnStatus.setLayoutX(14);
		 btnStatus.setLayoutY(62);
		 btnStatus.getStyleClass().setAll("btn","btn-default");
		 btnStatus.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 Status status = new Status();

				 try {
					 status.start(palco);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		 Button btnHistorico = new Button();
		 btnHistorico.setText("Histórico");
		 btnHistorico.setLayoutX(175);
		 btnHistorico.setLayoutY(62);
		 btnHistorico.getStyleClass().setAll("btn","btn-success");
		 btnHistorico.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 Historico historico = new Historico();

				 try {
					 historico.start(palco);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		 Button btnReport = new Button();
		 btnReport.setText("Relatórios");
		 btnReport.setLayoutX(14);
		 btnReport.setLayoutY(151);
		 btnReport.getStyleClass().setAll("btn","btn-success");
		 btnReport.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 Report report = new Report();

				 try {
					 report.start(palco);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		 Button btnGrafico = new Button();
		 btnGrafico.setText("Gráficos");
		 btnGrafico.setLayoutX(175);
		 btnGrafico.setLayoutY(151);
		 btnGrafico.getStyleClass().setAll("btn","btn-success");
		 btnGrafico.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 Grafico grafico = new Grafico();

				 try {
					 grafico.start(palco);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		 Button btnPlantation = new Button();
		 btnPlantation.setDisable(true);
		 btnPlantation.setText("Plantation");
		 btnPlantation.setLayoutX(14);
		 btnPlantation.setLayoutY(240);
		 btnPlantation.getStyleClass().setAll("btn","btn-default");
		 btnPlantation.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 Plantation plantation = new Plantation();

				 try {
					 plantation.start(palco);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		 Button btnAddControl = new Button();
		 btnAddControl.setDisable(true);
		 btnAddControl.setText("Controle");
		 btnAddControl.setLayoutX(175);
		 btnAddControl.setLayoutY(240);
		 btnAddControl.getStyleClass().setAll("btn","btn-default");
		 btnAddControl.setOnAction(new EventHandler<ActionEvent>() {

			 public void handle(ActionEvent event) {

				 AddControl addControl = new AddControl();

				 try {
					 addControl.start(palco);
				 } catch (Exception e) {
					 e.printStackTrace();
				 }
			 }
		 });

		 Button btnExit = new Button();
		 btnExit.setText("Fechar");
		 btnExit.setLayoutX(14);
		 btnExit.setLayoutY(329);
		 btnExit.getStyleClass().setAll("btn","btn-danger");
		 btnExit.setOnAction(new EventHandler<ActionEvent>() {

	          public void handle(ActionEvent event) {
	              palco.close();
	          }
	      });

		 
		  grafico.setContent(lineChart);

		  dados.setContent(lvDados);

		  tabpane.getTabs().addAll(grafico,dados);
		  
		  vbCheckBox.getChildren().addAll(cbTemperatura, cbUmidadeAr, cbUmidadeSolo);
		  
		  pane.getChildren().addAll( menuBar, tabpane, btnStatus, btnHistorico, btnReport, btnGrafico, btnPlantation, btnAddControl, btnExit, comboBoxPorts, vbCheckBox);

		  anchorPane.getChildren().add(pane);

		  Scene cena = new Scene(anchorPane, 800, 600);

		  //cena.getStylesheets().addAll(/*"com/robotplant/interface/application.css",*/"bootstrapfx.css");
		  cena.getStylesheets().addAll("bootstrapfx.css");
		  
		  palco.getIcons().add(new Image(getClass().getResourceAsStream("/img/plant-icon-34784.png")));
		  palco.setTitle("RobotPlant - 0.1 ");
		  palco.setResizable(false);
		  palco.setScene(cena);
		  palco.show();

	 }
	 
	 private void prepareData() {
	        for (int i = 0; i < 8; i++) {
	            group[i] = 0;
	        }
	 }
	private void chartPopulation(XYChart.Series<String, Number> series1) {
		
		List<TemperaturaModel> listTemperatura = new ArrayList<TemperaturaModel>();
		List<UmidadeArModel> listUmidadeAr = new ArrayList<UmidadeArModel>();
		List<UmidadeSoloModel> listUmidadeSolo = new ArrayList<UmidadeSoloModel>();
		DateFormat format = new SimpleDateFormat("HH:mm:ss");
		
		series1.getData().add(new XYChart.Data<String, Number>(format.format(temperaturaModel.getTemperaturaData()).toString(), temperaturaModel.getTemperaturaValor()));
		
	}
	 @SuppressWarnings({ "rawtypes", "unchecked" })
	public void Animation(LineChart lineChart, final XYChart.Series series1, final int group[]) {

		 //Apply Animating Data in Charts
	        //ref: http://docs.oracle.com/javafx/2/charts/bar-chart.htm
	        //"Animating Data in Charts" section

	        Timeline timeline = new Timeline();
	        timeline.getKeyFrames().add(
	                new KeyFrame(Duration.millis(200), (ActionEvent actionEvent) -> {

	            //int data = random.nextInt(100);
	            final int mean = 50;
	            final int standardDeviation = 10;
	            double data = mean * standardDeviation;

	            if (data <= 10) {
	                group[0]++;
	                series1.getData().set(0, new XYChart.Data("0-10", group[0]));
	            } else if (data <= 20) {
	                group[1]++;
	                series1.getData().set(1, new XYChart.Data("10-20", group[1]));
	            } else if (data <= 30) {
	                group[2]++;
	                series1.getData().set(2, new XYChart.Data("20-30", group[2]));
	            } else if (data <= 40) {
	                group[3]++;
	                series1.getData().set(3, new XYChart.Data("30-40", group[3]));
	            } else if (data <= 50) {
	                group[4]++;
	                series1.getData().set(4, new XYChart.Data("40-50", group[4]));
	            } else if (data <= 60) {
	                group[5]++;
	                series1.getData().set(5, new XYChart.Data("50-60", group[5]));
	            } else if (data <= 70) {
	                group[6]++;
	                series1.getData().set(6, new XYChart.Data("60-70", group[6]));
	            } else if (data <= 80) {
	                group[7]++;
	                series1.getData().set(7, new XYChart.Data("70-80", group[7]));
	            } else if (data <= 90) {
	                group[8]++;
	                series1.getData().set(8, new XYChart.Data("80-90", group[8]));
	            } else if (data <= 100) {
	                group[9]++;
	                series1.getData().set(9, new XYChart.Data("10-100", group[9]));
	            }

	            String s = "";
	            for(int i=0; i<10; i++){
	                s+= " " + group[i];
	            }
	        }));

	        timeline.setCycleCount(1000);
	        timeline.setAutoReverse(true);  //!?
	        timeline.play();

	        lineChart.setAnimated(false);


	 }
		private static List<HistoricoModel> listDados(String tipo) {
			List<HistoricoModel> historicoModels = new ArrayList<HistoricoModel>();
			BuscaDadosDAO buscaDadosDAO = new BuscaDadosDAO();
			try {
				if(tipo.equals("Temperatura")) {
					HistoricoModel historicoModel = null;
					historicoModels = buscaDadosDAO.listaDadosGraficoHome(historicoModels,tipo);
					return historicoModels;
				} if(tipo.equals("Umidade Ar")) {
					HistoricoModel historicoModel = null;
					historicoModels = buscaDadosDAO.listaDadosGraficoHome(historicoModels, tipo);

					return historicoModels;
				} if(tipo.equals("Umidade Solo")) {
					HistoricoModel historicoModel = null;
					historicoModels = buscaDadosDAO.listaDadosGraficoHome(historicoModels, tipo);
					return historicoModels;
				}else {
					
				}
			} catch (SQLException e) {
				throw new RuntimeException(e);
			}
			return null;
			
		}
	 
		private static XYChart.Series chartFactory(List<HistoricoModel> historicoModels, XYChart.Series series, String tipo) {
			
			final CategoryAxis xAxis = new CategoryAxis();
		    final NumberAxis yAxis = new NumberAxis();
		    final LineChart<String, Number> lineChart = new LineChart<String, Number>(xAxis,yAxis);
		    lineChart.setTitle(tipo);
		
		    HistoricoModel historicoModel = null;
		    DateFormat format = new SimpleDateFormat("HH:mm:ss");
		    series.setName(tipo);
		
		    //populating the series with data
		    for(int i = 0; i < historicoModels.size(); i++) {
		    	historicoModel = new HistoricoModel();
		    	historicoModel = historicoModels.get(i);
		        series.getData().add(new XYChart.Data(format.format(historicoModel.getDataAmostra()).toString(), historicoModel.getValor()));
		    }
		    //lineChart.getData().add(series);
		
		    return series;
		
		}
		//Pode mudar para seriesFactory
		private static XYChart.Series<String, Number> seriesFactory(XYChart.Series series, String tipo) {
		
		switch (tipo) {
		case "Temperatura":
			XYChart.Series<String, Number> serieTemperatura = new XYChart.Series<String, Number>();
			serieTemperatura.setName(tipo);
		// 	tabTemperatura.setClosable(false);
			serieTemperatura = (chartFactory(listDados(tipo), series, tipo));
			return serieTemperatura;
		
		case "Umidade Ar":
			XYChart.Series<String, Number> serieUmidadeAr = new XYChart.Series<String, Number>();
			serieUmidadeAr.setName(tipo);
		// 	tabUmidadeAr.setClosable(false);
			serieUmidadeAr = (chartFactory(listDados(tipo), series, tipo));
		return serieUmidadeAr;
		
		case "Umidade Solo":
			XYChart.Series<String, Number> serieUmidadeSolo = new XYChart.Series<String, Number>();
			serieUmidadeSolo.setName(tipo);
		// 	tabUmidadeSolo.setClosable(false);
			serieUmidadeSolo = (chartFactory(listDados(tipo), series, tipo));
		return serieUmidadeSolo;
		
		case "Ativações":
			XYChart.Series<String, Number> serieAtividade = new XYChart.Series<String, Number>();
			serieAtividade.setName(tipo);
		// 	tabAtivacao.setClosable(false);
			serieAtividade = (chartFactory(listDados(tipo), series, tipo));
		return serieAtividade;
		
		default:
			System.out.println("Nenhuma tabela gerada!");
		break;
		}
		
		return null;
		
		}
		
		private static void listviewFactory() {
			
		}
}