package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.AppointmentDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Alerts;
import com.example.helloworldjfxtemplate.model.Appointment;
import com.example.helloworldjfxtemplate.model.Customer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.Timestamp;
import java.util.Optional;

public class AppointmentsController {
    @FXML
    private TableView<Appointment> appointTableView;
    @FXML
    private TableColumn<Appointment, Integer> col_appointCont;

    @FXML
    private TableColumn<Appointment, String> col_appointDesc;

    @FXML
    private TableColumn<Appointment, Timestamp> col_appointEndDate;

    @FXML
    private TableColumn<Appointment, Integer> col_appointID;

    @FXML
    private TableColumn<Appointment, String> col_appointLoc;

    @FXML
    private TableColumn<Appointment, Timestamp> col_appointStartDate;

    @FXML
    private TableColumn<Appointment, String> col_appointTitle;

    @FXML
    private TableColumn<Appointment, String> col_appointType;

    @FXML
    private TableColumn<Appointment, Integer> col_custID;

    @FXML
    private TableColumn<Appointment, Integer> col_userID;
    @FXML
    private Button btn_addAppoint;
    @FXML
    private Button btn_delAppoint;
    @FXML
    private Button btn_updtAppoint;
    @FXML
    private Button btn_menu;
    @FXML
    private RadioButton rb_appoint;
    @FXML
    private RadioButton rb_month;
    @FXML
    private RadioButton rb_week;

    @FXML
    void setBtn_addAppoint(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("appointmentsadd.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Add Appointment");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    @FXML
    void setBtn_updtAppoint(ActionEvent event) throws IOException {
        if (appointTableView.getSelectionModel().getSelectedItem() != null) {
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("/view/AppointmentsModify.fxml"));
            loader.load();
            AppointmentModifyController MCController = loader.getController();
            MCController.getAppointmentInfo(appointTableView.getSelectionModel().getSelectedItem());
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            Parent scene = loader.getRoot();
            stage.setScene(new Scene(scene));
            stage.show();
        } else {
            Alerts.getError(6);
        }
    }
    @FXML
    void setBtn_delAppoint(ActionEvent event) {

    }


    @FXML
    void setRb_allappoint(ActionEvent event) {
        appointTableView.setItems(AppointmentDAO.getAppointmentList());
    }

    @FXML
    void setRb_month(ActionEvent event) {
        appointTableView.setItems(AppointmentDAO.getMonthlyAppointments());
    }

    @FXML
    void setRb_week(ActionEvent event) {
        appointTableView.setItems(AppointmentDAO.getWeeklyAppointments());
    }

    @FXML
    void setBtn_menu(ActionEvent event) throws IOException {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Leave To The Previous Menu?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();
        }

    }
}
