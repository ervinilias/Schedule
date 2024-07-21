package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.AppointmentDAO;
import com.example.helloworldjfxtemplate.DAO.ContactDAO;
import com.example.helloworldjfxtemplate.DAO.CountryDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.model.Appointment;
import com.example.helloworldjfxtemplate.model.Contact;
import javafx.beans.Observable;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ResourceBundle;
import java.util.Timer;

public class ReportsController implements Initializable {
    @FXML
    private TableView<Appointment> appMonthTableView;
    @FXML
    private TableView<Appointment> appTypeTableView;
    @FXML
    private TableView countryTableView;
    @FXML
    private TableView<Appointment> contAppTableView;
    @FXML
    private Tab appointCountryTab;
    @FXML
    private Tab appointTotalTab;
    @FXML
    private Tab contScheduleTab;
    @FXML
    private TableColumn<Appointment, String> appointMonth;
    @FXML
    private TableColumn<Appointment, Integer> appointMonthTotal;
    @FXML
    private TableColumn<Appointment, String> appointType;
    @FXML
    private TableColumn<Appointment, Integer> appointTypeTotal;
    @FXML
    private ComboBox<Contact> cb_contact;
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
    private TableColumn appointCountry;
    @FXML
    private TableColumn appointCountryTotal;
    @FXML
    private Button btn_menu;
    ObservableList<Contact> contList = ContactDAO.getAllContacts();

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        //Appointment Totals Tab -> Appointment Type and Totals
        appTypeTableView.setItems(AppointmentDAO.getAppointmentType());
        appTypeTableView.setPlaceholder(new Label("No data for type"));
        appointType.setCellValueFactory(new PropertyValueFactory<>("appointType"));
        appointTypeTotal.setCellValueFactory(new PropertyValueFactory<>("appointTypeTotal"));

        //Appointment Totals Tab -> Appointment by Month and Totals
        appMonthTableView.setItems(AppointmentDAO.getAppointTypeMonth());
        appMonthTableView.setPlaceholder(new Label("No data for month"));
        appointMonth.setCellValueFactory(new PropertyValueFactory<>("appMonth"));
        appointMonthTotal.setCellValueFactory(new PropertyValueFactory<>("appMonthTotal"));

        //Contact Schedule Tab -> get appointments for a specific Contact through combobox
        cb_contact.setItems(contList);
        cb_contact.setVisibleRowCount(10);
        contAppTableView.setPlaceholder(new Label("Select a specific contact first"));
        col_appointID.setCellValueFactory(new PropertyValueFactory<>("appointID"));
        col_appointTitle.setCellValueFactory(new PropertyValueFactory<>("appointTitle"));
        col_appointDesc.setCellValueFactory(new PropertyValueFactory<>("appointDesc"));
        col_appointType.setCellValueFactory(new PropertyValueFactory<>("appointType"));
        col_appointCont.setCellValueFactory(new PropertyValueFactory<>("appointContID"));
        col_appointStartDate.setCellValueFactory(new PropertyValueFactory<>("appointStart"));
        col_appointEndDate.setCellValueFactory(new PropertyValueFactory<>("appointEnd"));
        col_custID.setCellValueFactory(new PropertyValueFactory<>("appointCustID"));
        col_userID.setCellValueFactory(new PropertyValueFactory<>("appointUserID"));
        contAppTableView.refresh();
        //Customer Total Tab -> get total of customers for a specific country
        countryTableView.setItems(CountryDAO.totalCountry());
        countryTableView.setPlaceholder(new Label("No data is available"));
        appointCountry.setCellValueFactory(new PropertyValueFactory<>("countryMonth"));
        appointCountryTotal.setCellValueFactory(new PropertyValueFactory<>("countryMonthTotal"));
    }

    @FXML
    void setCb_contPopulate(ActionEvent event) throws SQLException {
        String contactName = String.valueOf(cb_contact.getValue());
        int contactID = ContactDAO.returnContactID(contactName);
        if (AppointmentDAO.getContactAppoint(contactID).isEmpty()) {
            contAppTableView.setPlaceholder(new Label(contactName + " has no appointments."));
            contAppTableView.refresh();
            for (int i = 0; i < contAppTableView.getItems().size(); i++) {
                contAppTableView.getItems().clear();
                contAppTableView.setPlaceholder(new Label(contactName + " has no appointments."));
            }
        } else  {
            contAppTableView.setItems(AppointmentDAO.getContactAppoint(contactID));
        }
    }

    @FXML
    void setBtn_menu(ActionEvent event) throws IOException {
        new FXMLLoader();
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }
}
