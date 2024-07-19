package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.ContactDAO;
import com.example.helloworldjfxtemplate.DAO.CustomerDAO;
import com.example.helloworldjfxtemplate.DAO.UserDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.model.Appointment;
import com.example.helloworldjfxtemplate.model.Contact;
import com.example.helloworldjfxtemplate.model.Customer;
import com.example.helloworldjfxtemplate.model.User;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.stage.Stage;

import java.io.IOException;
import java.lang.annotation.Inherited;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;

public class AppointmentModifyController implements Initializable {
    @FXML
    private Button btn_menu;

    @FXML
    private Button btn_save;

    @FXML
    private ComboBox<Contact> cb_contID;

    @FXML
    private ComboBox<LocalTime> cb_appointmentEndTime;

    @FXML
    private ComboBox<LocalTime> cb_appointmentStartTime;

    @FXML
    private ComboBox<Customer> cb_custID;

    @FXML
    private ComboBox<User> cb_userID;

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
    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

    }
    @FXML
    void setBtn_save(ActionEvent event) {

    }

    public void getAppointInfo(Appointment selectedAppoint) throws SQLException {
        cb_appointmentStartTime.setItems(Appointment.getTime());
        cb_appointmentEndTime.setItems(Appointment.getTime());
        tf_appointID.setText(Integer.toString(selectedAppoint.getAppointContID()));
        tf_appointmentTitle.setText(selectedAppoint.getAppointTitle());
        tf_appointmentDesc.setText(selectedAppoint.getAppointDesc());
        tf_appointmentLoc.setText(selectedAppoint.getAppointLoc());
        tf_appointmentType.setText(selectedAppoint.getAppointType());
        dp_appointmentStartDate.setValue(selectedAppoint.getAppointStart().toLocalDate());
        cb_appointmentStartTime.setValue(selectedAppoint.getAppointStart().toLocalTime());
        dp_appointmentEndDate.setValue(selectedAppoint.getAppointEnd().toLocalDate());
        cb_appointmentEndTime.setValue(selectedAppoint.getAppointEnd().toLocalTime());
        Contact d = ContactDAO.returnContactList(selectedAppoint.getAppointContID());
        cb_contID.setValue(d);
        Customer c = CustomerDAO.returnCustomerList(selectedAppoint.getAppointCustID());
        cb_custID.setValue(c);
        User u = UserDAO.returnUserID(selectedAppoint.getAppointUserID());
        cb_userID.setValue(u);
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
