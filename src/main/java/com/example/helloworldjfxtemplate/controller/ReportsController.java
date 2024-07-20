package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;

public class ReportsController {
    @FXML
    private TableColumn<?, ?> appointCountry;

    @FXML
    private Tab appointCountryTab;

    @FXML
    private TableColumn<?, ?> appointCountryTotal;

    @FXML
    private TableColumn<?, ?> appointMonth;

    @FXML
    private TableColumn<?, ?> appointMonthTotal;

    @FXML
    private Tab appointTotalTab;

    @FXML
    private TableColumn<?, ?> appointType;

    @FXML
    private TableColumn<?, ?> appointTypeTotal;

    @FXML
    private Button btn_menu;

    @FXML
    private TableColumn<?, ?> col_appointCont;

    @FXML
    private TableColumn<?, ?> col_appointDesc;

    @FXML
    private TableColumn<?, ?> col_appointEndDate;

    @FXML
    private TableColumn<?, ?> col_appointID;

    @FXML
    private TableColumn<?, ?> col_appointLoc;

    @FXML
    private TableColumn<?, ?> col_appointStartDate;

    @FXML
    private TableColumn<?, ?> col_appointTitle;

    @FXML
    private TableColumn<?, ?> col_appointType;

    @FXML
    private TableColumn<?, ?> col_custID;

    @FXML
    private TableColumn<?, ?> col_userID;

    @FXML
    private Tab contScheduleTab;

    @FXML
    private TableView<?> contTableView;

    @FXML
    private ComboBox<?> contactCombo;


    @FXML
    void setCb_contPopulate(ActionEvent event) {

    }

    @FXML
    void setBtn_menu(ActionEvent event) throws IOException {
        new FXMLLoader();
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.show();
    }
}
