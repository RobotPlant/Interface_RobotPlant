package com.RobotPlant.CharTest;

import java.util.Random;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.util.Duration;

/**
 * @web http://java-buddy.blogspot.com
 */
public class JavaFX_Histogram extends Application {

    int group[] = new int[10];

    @Override
    public void start(Stage primaryStage) {

        prepareData();

        Label labelInfo = new Label();
        labelInfo.setText(
                "java.version: " + System.getProperty("java.version") + "\n"
                + "javafx.runtime.version: " + System.getProperty("javafx.runtime.version")
        );

        final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        final BarChart<String, Number> barChart
                = new BarChart<>(xAxis, yAxis);
        barChart.setCategoryGap(0);
        barChart.setBarGap(0);

        xAxis.setLabel("Range");
        yAxis.setLabel("Population");

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("Histogram");
        series1.getData().add(new XYChart.Data("0-10", group[0]));
        series1.getData().add(new XYChart.Data("10-20", group[1]));
        series1.getData().add(new XYChart.Data("20-30", group[2]));
        series1.getData().add(new XYChart.Data("30-40", group[3]));
        series1.getData().add(new XYChart.Data("40-50", group[4]));

        series1.getData().add(new XYChart.Data("50-60", group[5]));
        series1.getData().add(new XYChart.Data("60-70", group[6]));
        series1.getData().add(new XYChart.Data("70-80", group[7]));
        series1.getData().add(new XYChart.Data("80-90", group[8]));
        series1.getData().add(new XYChart.Data("90-100", group[9]));

        barChart.getData().addAll(series1);

        Label labelCnt = new Label();
        Label labelAnimated = new Label();

        VBox vBox = new VBox();
        vBox.getChildren().addAll(labelInfo, barChart, labelCnt, labelAnimated);

        StackPane root = new StackPane();
        root.getChildren().add(vBox);

        Scene scene = new Scene(root, 800, 500);

        primaryStage.setTitle("java-buddy.blogspot.com");
        primaryStage.setScene(scene);
        primaryStage.show();

        Random random = new Random();

        //Apply Animating Data in Charts
        //ref: http://docs.oracle.com/javafx/2/charts/bar-chart.htm
        //"Animating Data in Charts" section

        Timeline timeline = new Timeline();
        timeline.getKeyFrames().add(
                new KeyFrame(Duration.millis(200), (ActionEvent actionEvent) -> {

            //int data = random.nextInt(100);
            final int mean = 50;
            final int standardDeviation = 10;
            int data = mean + (int)(random.nextGaussian() * standardDeviation);

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

            labelCnt.setText(s);
            labelAnimated.setText("barChart.getAnimated() = " + barChart.getAnimated());
        }));

        timeline.setCycleCount(1000);
        timeline.setAutoReverse(true);  //!?
        timeline.play();

        barChart.setAnimated(false);

    }

    public static void main(String[] args) {
        launch(args);
    }

    //generate dummy random data
    private void prepareData() {
        for (int i = 0; i < 10; i++) {
            group[i] = 0;
        }
    }

}