package com.example.helloworldjfxtemplate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.*;

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
    void setBtn_menu(ActionEvent event) {

    }

    @FXML
    void setCb_contPopulate(ActionEvent event) {

    }
}
