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

            case 6:
                alert.setTitle("NoSelection");
                alert.setContentText("Please select a customer to continue.");
                alert.showAndWait();
                break;
            case 7:
                alert.setTitle("Customer Name is blank");
                alert.setContentText("The Customer Name field is blank.\n" +
                        "Please enter a valid name.");
                alert.showAndWait();
                break;
            case 8:
                alert.setTitle("Customer Phone number is blank");
                alert.setContentText("Please enter a valid phone number.");
                alert.showAndWait();
                break;
            case 9:
                alert.setTitle("Customer Address is blank");
                alert.setContentText("The Customer Address field is blank.\n" +
                        "Please enter a valid address.");
                alert.showAndWait();
                break;
            case 10:
                alert.setTitle("Customer Postal Code is blank");
                alert.setContentText("The Customer postal code field is blank.\n" +
                        "Please enter a valid postal code.");
                alert.showAndWait();
                break;
            case 11:
                alert.setTitle("Division/Country Field Issue");
                alert.setContentText("Please check the division and country field.");
                alert.showAndWait();
                break;


            default:
                throw new IllegalStateException("Unexpected value: " + numError);

        }
    }
}
