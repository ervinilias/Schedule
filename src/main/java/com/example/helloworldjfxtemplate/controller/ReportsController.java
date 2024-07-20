package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.ContactDAO;
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
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
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
    private ComboBox<Contact> contactCombo;
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

    }

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
        stage.centerOnScreen();
        stage.show();
    }
}
