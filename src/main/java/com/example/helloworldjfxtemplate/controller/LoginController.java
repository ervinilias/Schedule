package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.UserDAO;
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

        } else if (password.isBlank() || password.isEmpty()) {

        } else if(!UserDAO.userValid(username)) {

        } else if(!UserDAO.passValid(password)) {

        } else if(UserDAO.userLogin(username,password)) {
            new FXMLLoader();
            Parent parent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("menu.fxml")));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setScene(scene);
            stage.show();

        }
    }

    @FXML
    void setBtn_exit(ActionEvent event) {

    }




}
