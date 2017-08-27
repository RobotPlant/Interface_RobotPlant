package com.RobotPlant.Controller;

import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.stage.Stage;
import jssc.SerialPort;
import jssc.SerialPortException;
import jssc.SerialPortList;

public class ArduinoConnection extends Application {
		  //semaforo arduino e jfx
		    Circle cl_1, cl_2, cl_3;
		    ObservableList<String> nomes = FXCollections.observableArrayList();
		    ListView<String> listview = new ListView<String>(nomes);
		    Button btOne = new Button("connectar");

		    String nw_vlPorta;
		    SerialPort serialport;

		    String vl_circles;

		    Text tx1PortaOn = new Text("porta :" + nw_vlPorta);
		    Text tx2PortaStatus = new Text("Status :");
		    Text tx3Cor = new Text("Cor :");
		    Text tx4Command = new Text("Comando :" + vl_circles);

		    @Override
		    public void start(Stage stage) {

		        Group go = new Group();
		        Scene scene = new Scene(go, 260, 250, Color.SILVER);
		        stage.setScene(scene);

		        VBox vb1 = new VBox();
		        go.getChildren().add(vb1);

		        cl_1 = new Circle(25);
		        cl_2 = new Circle(25);
		        cl_3 = new Circle(25);

		         //Property().bind(cl_1.layoutYProperty());
		         //vb1.prefHeightProperty().bind(cl_1.layoutXProperty());

		        cl_1.setFill(Color.GREEN);
		        cl_2.setFill(Color.YELLOW);
		        cl_3.setFill(Color.RED);
		       cl_1.setStrokeDashOffset(10);
		       cl_2.setStrokeDashOffset(10);
		       cl_3.setStrokeDashOffset(10);

		        vb1.getChildren().addAll(cl_1, cl_2, cl_3);
		        vb1.setLayoutY(30);
		        vb1.setLayoutX(10);
		        VBox vb2 = new VBox(.40);
		        go.getChildren().add(vb2);
		        vb2.layoutXProperty().bind(vb1.layoutXProperty().add(cl_1.getRadius()).multiply(2));
		        vb2.layoutYProperty().bind(vb1.layoutYProperty());
		        HBox hb1 = new HBox(.5);
		        vb2.getChildren().add(hb1);
		        CheckBox cb1 = new CheckBox("Auto");
		        CheckBox cb2 = new CheckBox("Manu");
		        hb1.getChildren().addAll(cb1, cb2);
		        vb2.getChildren().add(listview);
		        listview.setPrefSize(55, 105);
		        btOne.setPrefWidth(105);
		        vb2.getChildren().add(btOne);
		        veryfiK_Port();
		        VBox vb3 = new VBox(0.5);
		        go.getChildren().add(vb3);
		        HBox hb1x = new HBox(0.5);
		        HBox hb2x = new HBox(0.5);
		        vb3.getChildren().addAll(hb1x, hb2x);
		        hb1x.getChildren().addAll(tx1PortaOn, tx2PortaStatus);
		        hb2x.getChildren().addAll(tx3Cor, tx4Command);
		        vb3.layoutXProperty().bind(vb1.layoutXProperty());
		        vb3.layoutYProperty().bind(stage.heightProperty().subtract(105));

		        //método para ler porta assim que é selecionado no listview.
		        listview.getSelectionModel().selectedItemProperty().addListener(
		                (ObservableValue<? extends String> ov, String old_val,
		                        String new_val) -> {
		                    System.out.println(new_val);
		                    nw_vlPorta = new_val;
		                    tx1PortaOn.setText("porta :" + nw_vlPorta);
		                    serialport = new SerialPort("" + nw_vlPorta);
		                });

		        cl_1.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
		                cl_1.setStroke(Color.BLUEVIOLET);

		                vl_circles = "q";
		                tx3Cor.setText("Cor :VERDE");
		                tx4Command.setText("Comando :" + vl_circles);

		                try {
		                     arranque();
		                } catch (Exception e) {
		            System.out.println("cl1 error"+e.getMessage());
		                }
		            cl_1.setStroke(Color.BLACK);
		            }
		        });
		    cl_2.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
		                cl_2.setStroke(Color.BLUEVIOLET);
		                vl_circles = "w";
		                tx3Cor.setText("Cor :AMARELO");
		                tx4Command.setText("Comando :" + vl_circles);
		                try {
		                     arranque();
		                } catch (Exception e) {
		            System.out.println("cl2 error"+e.getMessage());
		                }

		        cl_2.setStroke(Color.BLACK);
		             }
		        });
		    cl_3.setOnMouseClicked(new EventHandler<MouseEvent>() {
		            @Override
		            public void handle(MouseEvent event) {
		               cl_3.setStroke(Color.BLUEVIOLET);
		                vl_circles = "e";
		                tx3Cor.setText("Cor :VERMELHO");
		                tx4Command.setText("Comando :" + vl_circles);
		                try {
		                     arranque();
		                } catch (Exception e) {
		            System.out.println("cl3 error"+e.getMessage());
		                }
		        cl_3.setStroke(Color.BLACK);

		            }
		        });
		//x)
		    btOne.setOnAction((ActionEvent event) ->{
		        if (cb1.isSelected()) {
		            vl_circles = "a";
		            tx3Cor.setText("Cor: THIS ");
		            tx4Command.setText("Commando: a");
		            arranque();
		            btOne.setText("Desconectar");
		        } else if (!cb1.isSelected()) {
		            try {
		                serialport.openPort();
		                serialport.closePort();
		                tx2PortaStatus.setText("Status:OFF");
		                btOne.setText("connectar");
		            } catch (SerialPortException ex) {
		                Logger.getLogger(ArduinoConnection.class.getName())
		                        .log(Level.SEVERE, null, ex);
		            }
		        }
		        });
		        stage.show();
		     }

		    @SuppressWarnings("empty-statement")
		    public void arranque() {
		        try {
		         if( serialport.openPort()){
		             tx2PortaStatus.setText("Status :ON");
		             System.out.println("Sistema pronto para "
		               + "INPUT E OUTPUT de dados");
		               serialport.setParams(9600, 8, 1, 0);
		               serialport.writeBytes(vl_circles.getBytes());
		               serialport.closePort();
		               System.out.println("enviando dados para porta serial\n"
		               + "porta-" + listview.getSelectionModel().getSelectedItems() + ""
		               + "\ndados de comando " + vl_circles);
		          }else{
		             tx2PortaStatus.setText("Status :OFF");
		             System.out.println("Sistema COMPORTAS TRANCADAS"
		                  + " PARA SAIDA EE ENTRADAD DE DADOS");
		            };

		        } catch (SerialPortException ex) {
		            Logger.getLogger(ArduinoConnection.class
		                    .getName()).log(Level.SEVERE, null, ex);
		        }
		    }
		    public void veryfiK_Port() {
		    String[] Str_lista = SerialPortList.getPortNames();
		       for (int pot = 0 + 1; pot < Str_lista.length; pot++) {
		           System.out.println("porta com " + Str_lista[pot]);
		             nomes.add(Str_lista[pot]);
		        }
		 };

		    public static void main(String[] args) {
		        launch(args);
		    }



}
