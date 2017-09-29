package com.RobotPlant.Interface;

import java.net.URL;
import java.util.ResourceBundle;

import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import jssc.SerialPort;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class HomeController implements Initializable {


    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnStatus;

    @FXML
    private Button btnHistorico;

    @FXML
    private Button btnConfig;

    @FXML
    private Button btnControl;

    @FXML
    private Button btnPlantation;

    @FXML
    private Button btnFechar;

    @FXML
    private AreaChart<Number, Number> areachart;

    @FXML
    private BarChart<String, Number> linechart;

    @FXML
    private ListView<?> lvDadosEventos;

    @FXML
    private DatePicker dpData;

    @FXML
    private Button btnBuscar;
    @FXML
    CategoryAxis  xAxis;
    @FXML
    NumberAxis yAxis;

	@SuppressWarnings({ "rawtypes", "unchecked" })
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {


		 //linechart = new BarChart<String, Number>(xAxis, yAxis);
		 xAxis.setLabel("Hora");
		 yAxis.setLabel("Temperatura");

		 XYChart.Series series1 = new XYChart.Series();
		 series1.setName("Histograma");
		 series1.getData().add(new XYChart.Data("1", 10));
	     series1.getData().add(new XYChart.Data("2", 4));
	     series1.getData().add(new XYChart.Data("15" , 70));
	     series1.getData().add(new XYChart.Data("4", 10));
	     series1.getData().add(new XYChart.Data("7", 4));
	     series1.getData().add(new XYChart.Data("78" , 70));
	     series1.getData().add(new XYChart.Data("8", 10));
	     series1.getData().add(new XYChart.Data("20", 4));
	     series1.getData().add(new XYChart.Data("150" , 70));
	     series1.getData().add(new XYChart.Data("47", 10));
	     series1.getData().add(new XYChart.Data("78", 4));
	     series1.getData().add(new XYChart.Data("782" , 70));

		 linechart.getData().add(series1);


	}



}
