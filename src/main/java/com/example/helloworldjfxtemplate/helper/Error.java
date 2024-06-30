package com.example.helloworldjfxtemplate.helper;

import javafx.scene.control.Alert;
import java.util.ResourceBundle;

public class Error {
    static ResourceBundle langBundle = ResourceBundle.getBundle("lang");

    public static void getError(int numError) {
        Alert alert = new Alert(Alert.AlertType.ERROR);
        switch (numError){
            case 1:
                alert.setTitle(langBundle.getString("ErrorBlankUser"));
                alert.setContentText(langBundle.getString("blankUser"));
                alert.showAndWait();
                break;

            case 2:
                alert.setTitle(langBundle.getString("ErrorBlankPass"));
                alert.setContentText(langBundle.getString("blankPass"));
                alert.showAndWait();
                break;

            case 3:
                alert.setTitle(langBundle.getString("ErrorUsername"));
                alert.setContentText(langBundle.getString("incorrectUsername"));
                alert.showAndWait();
                break;

            case 4:
                alert.setTitle(langBundle.getString("ErrorPass"));
                alert.setContentText(langBundle.getString("incorrectPass"));
                alert.showAndWait();
                break;

            case 5:
                alert.setTitle(langBundle.getString("ErrorUserPass"));
                alert.setContentText(langBundle.getString("incorrectUserPass"));
                alert.showAndWait();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + numError);

        }
    }
}
