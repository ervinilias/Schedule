package com.example.helloworldjfxtemplate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AppointmentAddController {
    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<?> cb_addCustID;

    @FXML
    private ComboBox<?> cb_addUserID;

    @FXML
    private ComboBox<?> cb_appointCont;

    @FXML
    private ComboBox<?> cb_appointEndDate;

    @FXML
    private ComboBox<?> cb_appointStartDate;

    @FXML
    private DatePicker dp_appointEndDate;

    @FXML
    private DatePicker dp_appointStartDate;

    @FXML
    private TextField tf_appointDesc;

    @FXML
    private TextField tf_appointID;

    @FXML
    private TextField tf_appointLoc;

    @FXML
    private TextField tf_appointTitle;

    @FXML
    private TextField tf_appointType;

    @FXML
    void setBtn_menu(ActionEvent event) {

    }

    @FXML
    void setBtn_save(ActionEvent event) {

    }
}
