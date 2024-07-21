package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.MainApplication;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.stage.Stage;

import java.io.IOException;

/**
*  MenuController class links login and main functionalities of application.
*  Menu sends user to Customer, Appointments and Reports screen
 */
public class MenuController {
    @FXML
    private Button btn_appointments;
    @FXML
    private Button btn_customers;
    @FXML
    private Button btn_exit;
    @FXML
    private Button btn_reports;

    /**
     * setBtn_appointments() method sends user to the "appointments" screen.
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_appointments(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("appointments.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * setBtn_customers sends user to the "customers" screen
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_customers(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("customers.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * setBtn_reports sends user to reports screen.
     * @param event
     * @throws IOException
     */
    @FXML
    void setBtn_reports(ActionEvent event) throws IOException {
        Parent parent = FXMLLoader.load(MainApplication.class.getResource("reports.fxml"));
        Scene scene = new Scene(parent);
        Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
        stage.setTitle("Main Menu");
        stage.setScene(scene);
        stage.centerOnScreen();
        stage.show();
    }

    /**
     * setBtn_exit() method closes the app.
     * @param event
     */
    @FXML
    void setBtn_exit(ActionEvent event) {
        Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
        stage.close();
    }
}
