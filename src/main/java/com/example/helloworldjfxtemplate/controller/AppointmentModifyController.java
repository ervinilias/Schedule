package com.example.helloworldjfxtemplate.controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;

public class AppointmentModifyController {
    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<?> cb_appointmentCont;

    @FXML
    private ComboBox<?> cb_appointmentEndDate;

    @FXML
    private ComboBox<?> cb_appointmentStartDate;

    @FXML
    private ComboBox<?> cb_custID;

    @FXML
    private ComboBox<?> cb_userID;

    @FXML
    private DatePicker dp_appointmentEndDate;

    @FXML
    private DatePicker dp_appointmentStartDate;

    @FXML
    private TextField tf_appointID;

    @FXML
    private TextField tf_appointmentDesc;

    @FXML
    private TextField tf_appointmentLoc;

    @FXML
    private TextField tf_appointmentTitle;

    @FXML
    private TextField tf_appointmentType;

    @FXML
    void setBtn_menu(ActionEvent event) {

    }

    @FXML
    void setBtn_save(ActionEvent event) {

    }
}
