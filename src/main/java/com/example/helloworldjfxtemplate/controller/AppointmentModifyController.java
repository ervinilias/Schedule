package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.model.Appointment;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Optional;

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
    void setBtn_save(ActionEvent event) {

    }

    public void getAppointmentInfo(Appointment selectedItem) {

    }

    public void backToAppoint(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("appointments.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();

    }
    @FXML
    void setBtn_cancel(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Leave Without Saving?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            backToAppoint(event);
        }
    }
}
