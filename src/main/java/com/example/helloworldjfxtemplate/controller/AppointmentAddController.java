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
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Optional;
import java.util.ResourceBundle;
/**
 * AppointmentsAddController class adds appointment to the appointments table
 *  First it checks appointment for empty text fields, then checks for overlaps, pastdates and business hours.
 *  If errors found, sends error popup. In the end it returns user to appointment menu.
 *  LAMBDA EXPRESSIONS LINE 86-87
 * @author Ervin Iliasov C195
 */
public class AppointmentAddController implements Initializable {
    @FXML
    private Button btn_menu;
    @FXML
    private Button btn_save;
    @FXML
    private ComboBox<Customer> cb_addCustID;
    @FXML
    private ComboBox<User> cb_addUserID;
    @FXML
    private ComboBox<Contact> cb_addContID;
    @FXML
    private ComboBox<LocalTime> cb_appointEndTime;
    @FXML
    private ComboBox<LocalTime> cb_appointStartTime;
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
    private final int daysToAdd = 0;

    /**
     * initialize() method initializes ID comboboxes for customer, user and contact.
     * Adds 30 minutes for end time picker from start time picker.
     * LAMBDA Line 86: Data Picker: takes value from start date and sets the value in end date picker
     * LAMBDA Line 87:  Time Combo: takes  time selected in the start combo and sets the value plus 30 minutes
     * @param url
     * @param rb
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        cb_appointStartTime.setItems(Appointment.getTime());
        cb_appointEndTime.setItems(Appointment.getTime());
        cb_addContID.setItems(ContactDAO.getAllContacts());
        cb_addUserID.setItems(UserDAO.getUserList());
        cb_addCustID.setItems(CustomerDAO.getCustomerList());
        //Lambda expressions
        dp_appointStartDate.valueProperty().addListener((ov, oldValueDate, newValueDate) -> dp_appointEndDate.setValue(newValueDate.plusDays(daysToAdd)));
        cb_appointStartTime.valueProperty().addListener((ov1, oldValueTime, newValueTime) -> cb_appointEndTime.setValue(newValueTime.plusMinutes(30)));
       }

    /**
     * setBtn_save() method
     * First it checks appointment for empty text fields, then checks for overlaps, pastdates and business hours.
     * If errors found, sends error popup. In the end it adds appointment to the list and returns user to appointment menu.
     * @param event
     * @throws SQLException
     * @throws IOException
     */
    @FXML
    void setBtn_save(ActionEvent event) throws SQLException, IOException {
        String appointTitle = tf_appointTitle.getText();
        String appointDesc = tf_appointDesc.getText();
        String appointLoc = tf_appointLoc.getText();
        String appointType = tf_appointType.getText();

        Contact contact = cb_addContID.getValue();
        if (contact == null) {
            Alerts.getError(12);
        }
        int appointContID = contact.getContactID();

        LocalDate startPick = dp_appointStartDate.getValue();
        if (startPick == null) {
            Alerts.getError(13);
        }

        LocalTime start = cb_appointStartTime.getValue();
        if (start == null) {
            Alerts.getError(14);
        }
        LocalDateTime appointStart = LocalDateTime.of(dp_appointStartDate.getValue(), cb_appointStartTime.getValue());

        LocalDate endPick = dp_appointEndDate.getValue();
        if (endPick == null) {
            Alerts.getError(15);
        }

        LocalTime end = cb_appointEndTime.getValue();
        if (end == null) {
            Alerts.getError(16);
        }
        LocalDateTime appointEnd = LocalDateTime.of(dp_appointEndDate.getValue(), cb_appointEndTime.getValue());
        LocalDateTime appointCreateDate = LocalDateTime.now();
        String appointCreatedby = "script";
        LocalDateTime appointLastUpdate = LocalDateTime.now();
        String appointUpdatedBy = "script";


        Customer customer = cb_addCustID.getValue();
        if (customer == null) {
            Alerts.getError(17);
        }
        int appointCustID = cb_addCustID.getValue().getCustID();

        User user = cb_addUserID.getValue();
        if (user == null) {
            Alerts.getError(18);
        }
        int appointUserID = cb_addUserID.getValue().getUserID();

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
        } else if (Appointment.checkPastDate(appointStart,appointEnd)) {
            return;
        } else if (Appointment.checkOverlap(appointCustID, appointStart, appointEnd)) {
            return;
        } else {
            AppointmentDAO.addAppoint(appointTitle, appointDesc, appointLoc, appointType, appointStart, appointEnd,
                    appointCreateDate, appointCreatedby, appointLastUpdate, appointUpdatedBy, appointCustID,
                    appointUserID, appointContID);
            Alerts.getConfirm(3);
            backToAppoint(event);
        }
    }

    /**
     * backToAppoint() method sends user to "Appointment" menu.
     * @param event
     * @throws IOException
     */
    public void backToAppoint(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("appointments.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();

    }

    /**
     * setBtn_cancel() method raises alert to confirm leaving and utilizes backToAppoint if OK was pressed
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_cancel(ActionEvent event) throws IOException {

        Alert alert = new Alert(Alert.AlertType.CONFIRMATION, "Leave Without Saving?");
        Optional<ButtonType> result = alert.showAndWait();

        if(result.isPresent() && result.get() == ButtonType.OK) {
            backToAppoint(event);
        }
    }
}
