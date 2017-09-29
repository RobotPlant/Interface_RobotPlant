package com.RobotPlant.Interface;

import java.sql.Date;
import java.sql.SQLException;

import com.RobotPlant.JDBC.BuscaDadosDAO;
import com.RobotPlant.Model.HistoricoModel;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
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
import javafx.scene.text.Font;
import javafx.stage.Stage;

public class Historico extends Application {

	public static void main(String[] args) {
		  launch();
		 }

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
		pane2.setLayoutY(144);

		HBox hBox = new HBox();
		hBox.prefWidth(800);
		hBox.prefHeight(25);
		hBox.setLayoutX(-2);
		hBox.setLayoutY(575);

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
		TableColumn<HistoricoModel, Date> column5 = new TableColumn<HistoricoModel, Date>("Data");
		column5.setPrefWidth(155);
		column5.setCellValueFactory(new PropertyValueFactory<HistoricoModel, Date>("dataAmostra"));
		lvDados.setItems(TablePop());

		lvDados.getColumns().addAll(column1, column2, column3, column4, column5);

		MenuBar menuBar = new MenuBar();
		menuBar.prefWidth(800);
		menuBar.prefHeight(25);
		menuBar.setLayoutX(0);
		menuBar.setLayoutY(2);

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

		Button btnVoltar = new Button();
		btnVoltar.setText("Voltar");
		btnVoltar.setLayoutX(14);
		btnVoltar.setLayoutY(62);
		btnVoltar.getStyleClass().setAll("btn","btn-success");
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

		pane1.getChildren().addAll(pane2, hBox, separator, btnVoltar, menuBar);

		anchorPane.getChildren().add(pane1);

		Scene cena = new Scene(anchorPane, 800, 600);

		cena.getStylesheets().add("bootstrapfx.css");


		primaryStage.getIcons().add(new Image(getClass().getResourceAsStream("/img/icon.png")));
		primaryStage.setTitle("RobotPlant - 0.1 ");
		primaryStage.setResizable(false);
		primaryStage.setScene(cena);
		primaryStage.show();

	}

	public ObservableList<HistoricoModel> TablePop() {
		ObservableList<HistoricoModel> data = FXCollections.observableArrayList();
		BuscaDadosDAO dadosDAO = new BuscaDadosDAO();
		try {
			data = dadosDAO.listaDados(data);
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}

		return data;


	}
}
