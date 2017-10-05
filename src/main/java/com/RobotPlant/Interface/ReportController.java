package com.RobotPlant.Interface;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.CheckBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.TableView;

public class ReportController {

    @FXML
    private MenuBar menubar;

    @FXML
    private Menu aquivo;

    @FXML
    private MenuItem close;

    @FXML
    private Menu editar;

    @FXML
    private MenuItem deletar;

    @FXML
    private Menu ajuda;

    @FXML
    private MenuItem sobre;

    @FXML
    private Button btnBuscar;

    @FXML
    private Button btnGerar;

    @FXML
    private Button btnVoltar;

    @FXML
    private CheckBox cbTemperatura;

    @FXML
    private CheckBox cbUmidadeAr;

    @FXML
    private CheckBox cbUmidadeSolo;

    @FXML
    private Label lblPeriodoIn;

    @FXML
    private Label lblPeriodoFim;

    @FXML
    private DatePicker dpDtIn;

    @FXML
    private DatePicker dpDtFim;

    @FXML
    private TableView<?> tvDados;

    @FXML
    private ProgressBar pbStatus;

}
