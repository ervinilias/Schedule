package com.example.helloworldjfxtemplate.controller;

import com.example.helloworldjfxtemplate.DAO.AppointmentDAO;
import com.example.helloworldjfxtemplate.DAO.UserDAO;
import com.example.helloworldjfxtemplate.MainApplication;
import com.example.helloworldjfxtemplate.helper.Alerts;
import com.example.helloworldjfxtemplate.model.Appointment;
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

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
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
    boolean loginSuccess = false;
    LocalDateTime currentTime = LocalDateTime.now();
    ZonedDateTime LDTConvert = currentTime.atZone(ZoneId.systemDefault());
    LocalDateTime currentTimePlus15 = LocalDateTime.now().plusMinutes(15);
    ZonedDateTime LDTUTC = LDTConvert.withZoneSameInstant(ZoneId.of("Etc/UTC"));
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
            Alerts.getError(1);
        } else if (password.isBlank() || password.isEmpty()) {
            Alerts.getError(2);
            loginSuccess = false;
            loginActivity();
        } else if(!UserDAO.userValid(username)) {
            Alerts.getError(3);
            loginSuccess = false;
            loginActivity();
        } else if(!UserDAO.passValid(password)) {
            Alerts.getError(4);
            loginSuccess = false;
            loginActivity();
        } else if (!UserDAO.userLogin(username, password)) {
            Alerts.getError(5);
            loginSuccess = false;
            loginActivity();
        } else if(UserDAO.userLogin(username, password)) {
            int userID = UserDAO.getUserId(username);
            ObservableList<Appointment> userAppoint = AppointmentDAO.getUserAppointments(userID);
            new FXMLLoader();
            Parent parent = FXMLLoader.load(MainApplication.class.getResource("menu.fxml"));
            Scene scene = new Scene(parent);
            Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            stage.setTitle("Main Menu");
            stage.setScene(scene);
            stage.centerOnScreen();
            stage.show();
            loginSuccess = true;
            loginActivity();

            boolean isValid = false;
            for (Appointment appoint : userAppoint) {
                LocalDateTime startTime = appoint.getAppointStart();
                if ((startTime.isAfter(currentTime) || startTime.isEqual(currentTimePlus15)) &&
                        (startTime.isBefore(currentTimePlus15) || startTime.isEqual(currentTime))) {
                    Alert confirmRemoval = new Alert(Alert.AlertType.WARNING);
                    confirmRemoval.setTitle(langBundle.getString("Alert"));
                    confirmRemoval.setContentText(langBundle.getString("Appointment") + " " +
                            appoint.getAppointID() + " " + langBundle.getString("beginsat") + " " + appoint.getAppointStart().toLocalTime());
                    confirmRemoval.getButtonTypes().clear();
                    confirmRemoval.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
                    confirmRemoval.showAndWait();
                    isValid = true;
                }
            }
            // Displays an alert if no appointments exist within 15 minutes
            if (!isValid) {
                Alerts.getConfirm(2);
            }
        }
    }

    @FXML
    void setBtn_exit(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.WARNING, langBundle.getString("Cancel"));
        alert.setTitle(langBundle.getString("Wannaexit"));
        alert.setContentText(langBundle.getString("oktoexit"));
        alert.getButtonTypes().clear();
        alert.getButtonTypes().addAll(ButtonType.CANCEL, ButtonType.OK);
        alert.showAndWait();
        if (alert.getResult() == ButtonType.OK) {
            Stage stage = (Stage) ((Button) event.getSource()).getScene().getWindow();
            stage.close();
        } else if (alert.getResult() == ButtonType.CANCEL) {
            alert.close();
        }
    }

    interface LogActivity {
        public String getFileName();
    }

    LogActivity logActivity = () -> {
        return "login_activity.txt";
    };

    public void loginActivity() throws IOException {
        FileWriter fwritter = new FileWriter(logActivity.getFileName(), true);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy hh:mm:ss");
        ZoneId localZone = ZoneId.systemDefault();
        if (loginSuccess) {
            fwritter.write(tf_username.getText() + " has successfully logged in on " + formatter.format(currentTime));
        } else if (!loginSuccess) {
            fwritter.write(tf_username.getText() + " has failed login on " + formatter.format(currentTime));
        }
        fwritter.write("\n");
        fwritter.close();
    }

}
