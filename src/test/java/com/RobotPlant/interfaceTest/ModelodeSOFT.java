package com.RobotPlant.interfaceTest;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.HBox;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

public class ModelodeSOFT extends Application {

	    public static void main(String[] args) {
	        Application.launch(args);
	    }

	    @Override
	    public void start(Stage primaryStage) {
	        primaryStage.setTitle("Tabs");

	        TabPane tabPane = new TabPane();

	        final CategoryAxis xAxis = new CategoryAxis();
	        final NumberAxis yAxis = new NumberAxis();
	        xAxis.setLabel("Month");

	        final LineChart<String,Number> lineChart =
	                new LineChart<String,Number>(xAxis,yAxis);

	        lineChart.setTitle("Stock Monitoring, 2010");


	        for(int i = 0; i<3; i++) {

	        	XYChart.Series series = new XYChart.Series();
	        	series.setName("My portfolio"+i);

		        series.getData().add(new XYChart.Data("Jan", 23));
		        series.getData().add(new XYChart.Data("Feb", 14));
		        series.getData().add(new XYChart.Data("Mar", 15));
		        series.getData().add(new XYChart.Data("Apr", 24));
		        series.getData().add(new XYChart.Data("May", 34));
		        series.getData().add(new XYChart.Data("Jun", 36));
		        series.getData().add(new XYChart.Data("Jul", 22));
		        series.getData().add(new XYChart.Data("Aug", 45));
		        series.getData().add(new XYChart.Data("Sep", 43));
		        series.getData().add(new XYChart.Data("Oct", 17));
		        series.getData().add(new XYChart.Data("Nov", 29));
		        series.getData().add(new XYChart.Data("Dec", 25));

		        lineChart.getData().add(series);

		        Tab tab = new Tab();
		        tab.setText("Tab" + i);
		        HBox hbox = new HBox();
		        hbox.getChildren().add(lineChart);
		        hbox.setAlignment(Pos.CENTER);
		        tab.setContent(hbox);
		        tabPane.getTabs().add(tab);
	        }
	        BorderPane borderPane = new BorderPane();
	        for (int i = 0; i < 5; i++) {
	        }
	        // bind to take available space
	        Group root = new Group();
	        Scene scene = new Scene(root, 400, 250, Color.WHITE);

	        borderPane.prefHeightProperty().bind(scene.heightProperty());
	        borderPane.prefWidthProperty().bind(scene.widthProperty());

	        borderPane.setCenter(tabPane);
	        root.getChildren().add(borderPane);
	        primaryStage.setScene(scene);
	        primaryStage.show();
	    }

	}
