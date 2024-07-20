package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.AppointmentDAO;
import com.example.helloworldjfxtemplate.DAO.ContactDAO;
import com.example.helloworldjfxtemplate.DAO.CustomerDAO;
import com.example.helloworldjfxtemplate.DAO.UserDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Alerts;
import com.example.helloworldjfxtemplate.model.Appointment;
import com.example.helloworldjfxtemplate.model.Contact;
import com.example.helloworldjfxtemplate.model.Customer;
import com.example.helloworldjfxtemplate.model.User;
import javafx.collections.ObservableList;
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
import java.time.LocalDate;
import java.time.LocalDateTime;
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
        cb_contID.setItems(ContactDAO.getAllContacts());
        cb_contID.setVisibleRowCount(10);
        cb_custID.setItems(CustomerDAO.getCustomerList());
        cb_custID.setVisibleRowCount(10);
        cb_userID.setItems(UserDAO.getUserList());
        cb_userID.setVisibleRowCount(10);
    }
    @FXML
    void setBtn_save(ActionEvent event) throws IOException {
        int appointID = Integer.parseInt(tf_appointID.getText());
        String appointTitle = tf_appointmentTitle.getText();
        String appointDesc = tf_appointmentDesc.getText();
        String appointLoc = tf_appointmentLoc.getText();
        String appointType = tf_appointmentType.getText();

        Contact contact = cb_contID.getValue();
        if (contact == null) {
            Alerts.getError(12);
        }
        int appointContID = contact.getContactID();

        LocalDate startPick = dp_appointmentStartDate.getValue();
        if (startPick == null) {
            Alerts.getError(13);
        }

        LocalTime start = cb_appointmentStartTime.getValue();
        if (start == null) {
            Alerts.getError(14);
        }
        LocalDateTime appointStart = LocalDateTime.of(dp_appointmentStartDate.getValue(), cb_appointmentStartTime.getValue());

        LocalDate endPick = dp_appointmentEndDate.getValue();
        if (endPick == null) {
            Alerts.getError(15);
        }

        LocalTime end = cb_appointmentEndTime.getValue();
        if (end == null) {
            Alerts.getError(16);
        }
        LocalDateTime appointEnd = LocalDateTime.of(dp_appointmentEndDate.getValue(), cb_appointmentEndTime.getValue());
        LocalDateTime appointLastUpdate = LocalDateTime.now();
        String appointUpdatedBy = "script";

        Customer customer = cb_custID.getValue();
        if (customer == null) {
            Alerts.getError(17);
        }
        int appointCustID = cb_custID.getValue().getCustID();

        User user = cb_userID.getValue();
        if (user == null) {
            Alerts.getError(18);
        }
        int appointUserID = cb_userID.getValue().getUserID();

        if (appointTitle.isBlank() || appointTitle.isEmpty()) {
            Alerts.getError(19);
        } else if (appointDesc.isBlank() || appointDesc.isEmpty()) {
            Alerts.getError(20);
        } else if (appointType.isBlank() || appointType.isEmpty()) {
            Alerts.getError(21);
        } else if (appointLoc.isBlank() || appointLoc.isEmpty()) {
            Alerts.getError(22);
        } else if (Appointment.businessHours(appointStart, appointEnd)) {
            return;
        } else if (Appointment.checkOverlap(appointCustID, appointStart, appointEnd)) {
            return;
        } else {
            AppointmentDAO.updtAppoint(appointTitle, appointDesc, appointLoc, appointType, appointStart, appointEnd,
                    appointLastUpdate, appointUpdatedBy, appointCustID, appointUserID, appointContID, appointID);
            Alerts.getConfirm(4);
            backToAppoint(event);
        }

    }

    public void getAppointInfo(Appointment selectedAppoint) throws SQLException {
        cb_appointmentStartTime.setItems(Appointment.getTime());
        cb_appointmentEndTime.setItems(Appointment.getTime());
        tf_appointID.setText(Integer.toString(selectedAppoint.getAppointID()));
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
