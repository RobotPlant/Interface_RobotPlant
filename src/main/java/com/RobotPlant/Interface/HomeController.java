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
import javafx.scene.control.ListView;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import jssc.SerialPort;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;

public class HomeController implements EventHandler, Initializable {

	@FXML
	TabPane tabpane = new TabPane();

	@FXML
	Tab tabDados = new Tab();

	@FXML
	Tab tabGrafico = new Tab();


	ObservableList<String> items = FXCollections.observableArrayList();
	@FXML
	ListView<String> lvDados = new ListView<>(items);

	//@FXML
	//LineChart lcGrafico= new LineChart<>();

	final NumberAxis xAxis = new NumberAxis();

    final NumberAxis yAxis = new NumberAxis();

    final LineChart<Number,Number> lineChart = new LineChart<Number,Number>(xAxis,yAxis);


    public void MostraDadosList(ActionEvent event) {

    	lvDados.getSelectionModel().selectedItemProperty().addListener(
                (ObservableValue<? extends String> ov, String old_val,
                        String new_val) -> {
                        	for(int i = 0;i<10000; i++)
                        		System.out.println(i);

                });
    }

    public void MostraDadosGrafico(ActionEvent event) {

    	xAxis.setLabel("Number of Month");

    	lineChart.setTitle("Stock Monitoring, 2010");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("My portfolio");
        //populating the series with data
        series.getData().add(new XYChart.Data(1, 23));
        series.getData().add(new XYChart.Data(2, 14));
        series.getData().add(new XYChart.Data(3, 15));
        series.getData().add(new XYChart.Data(4, 24));
        series.getData().add(new XYChart.Data(5, 34));
        series.getData().add(new XYChart.Data(6, 36));
        series.getData().add(new XYChart.Data(7, 22));
        series.getData().add(new XYChart.Data(8, 1000));
        series.getData().add(new XYChart.Data(9, 43));
        series.getData().add(new XYChart.Data(10, 17));
        series.getData().add(new XYChart.Data(11, 29));
        series.getData().add(new XYChart.Data(12, 25));

        lineChart.getData().add(series);
    }

	@Override
	public void handle(Event arg0) {
		// TODO Auto-generated method stub

	}


	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub

	}


}
