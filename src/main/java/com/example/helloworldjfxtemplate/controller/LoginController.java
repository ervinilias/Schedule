package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.UserDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Error;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.ZoneId;
import java.util.Objects;
import java.util.ResourceBundle;
import com.example.helloworldjfxtemplate.helper.*;

public class LoginController implements Initializable {
    @FXML
    private Button btn_exit;

    @FXML
    private Button btn_login;

    @FXML
    private Label lbl_location;

    @FXML
    private Label lbl_userloc;

    @FXML
    private Label lbl_name;

    @FXML
    private Label lbl_password;

    @FXML
    private Label lbl_username;

    @FXML
    private TextField tf_password;

    @FXML
    private TextField tf_username;

    ResourceBundle langBundle = ResourceBundle.getBundle("lang");

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ZoneId zoneId = ZoneId.systemDefault();
        String location = ZoneId.systemDefault().toString();
        lbl_name.setText(langBundle.getString("SchedulingApp"));
        lbl_location.setText(langBundle.getString("Location"));
        lbl_userloc.setText(location);
        lbl_username.setText(langBundle.getString("Username"));
        lbl_password.setText(langBundle.getString("Password"));
        btn_login.setText(langBundle.getString("Login"));
        btn_exit.setText(langBundle.getString("Exit"));

    }

    @FXML
    void setBtn_login(ActionEvent event) throws IOException, SQLException {
        String username = tf_username.getText();
        String password = tf_password.getText();

        if(username.isBlank() || username.isEmpty()) {
            Error.getError(1);
        } else if (password.isBlank() || password.isEmpty()) {
            Error.getError(2);
        } else if(!UserDAO.userValid(username)) {
            Error.getError(3);
        } else if(!UserDAO.passValid(password)) {
            Error.getError(4);
        } else if (!UserDAO.userLogin(username, password)) {
            Error.getError(5);
        } else if(UserDAO.userLogin(username,password)) {
            new FXMLLoader();
            Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    void setBtn_exit(ActionEvent event) {

    }




}
