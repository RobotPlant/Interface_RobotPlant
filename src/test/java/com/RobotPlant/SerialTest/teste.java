package com.RobotPlant.SerialTest;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.Model.UmidadeArModel;

import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import jssc.SerialPort;
import static jssc.SerialPort.MASK_RXCHAR;
import jssc.SerialPortEvent;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class teste {

	public static void main(String[] args) {

		List<UmidadeArModel> ar = new ArrayList<>();

		try {
			ar = new BuscaDadosDAO().buscaUmidadeAr();
			System.out.println(ar.toString());
		} catch (SQLException e) {
			e.printStackTrace();
		}

	}

}