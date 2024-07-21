package com.example.helloworldjfxtemplate.helper;

import javafx.scene.control.Alert;
import java.util.ResourceBundle;

public class Alerts {
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
                alert.setContentText("Please select item to continue.");
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

            case 12:
                alert.setTitle("Contact Issue");
                alert.setContentText("Please select a valid contact.");
                alert.showAndWait();
                break;

            case 13:
                alert.setTitle("Start date cbox Issue");
                alert.setContentText("The start date field is blank. Please choose a date.");
                alert.showAndWait();
                break;

            case 14:
                alert.setTitle("Start time cbox Issue");
                alert.setContentText("The start time is blank. Please choose a start time.");
                alert.showAndWait();
                break;

            case 15:
                alert.setTitle("End date cbox Issue");
                alert.setContentText("The end date field is blank. Please choose a date.");
                alert.showAndWait();
                break;

            case 16:
                alert.setTitle("End time cbox Issue");
                alert.setContentText("The end time is blank. Please choose an end time.");
                alert.showAndWait();
                break;

            case 17:
                alert.setTitle("Customer Choice Issue");
                alert.setContentText("Please select a valid customer.");
                alert.showAndWait();
                break;

            case 18:
                alert.setTitle("User Choice Issue");
                alert.setContentText("Please select a valid user.");
                alert.showAndWait();
                break;

            case 19:
                alert.setTitle("Title Issue");
                alert.setContentText("Please enter a Title.");
                alert.showAndWait();
                break;

            case 20:
                alert.setTitle("Description Issue");
                alert.setContentText("Please enter a description.");
                alert.showAndWait();
                break;

            case 21:
                alert.setTitle("Type Issue");
                alert.setContentText("Please enter a Type.");
                alert.showAndWait();
                break;

            case 22:
                alert.setTitle("Location Issue");
                alert.setContentText("Please enter a Location.");
                alert.showAndWait();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + numError);

        }
    }
    public static void getConfirm(int numConfirm) {
        Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
        switch (numConfirm) {
            case 1:
                alert.setTitle("Customer has been successfully added");
                alert.setHeaderText("Success!");
                alert.setContentText("Customer has been successfully added");
                alert.showAndWait();
                break;

            case 2:
                alert.setTitle(langBundle.getString("Alert"));
                alert.setContentText(langBundle.getString("noappointin15"));
                alert.showAndWait();
                break;

            case 3:
                alert.setTitle("Appointment has been successfully added");
                alert.setHeaderText("Success!");
                alert.setContentText("Appointment has been successfully added");
                alert.showAndWait();
                break;

            case 4:
                alert.setTitle("Appointment has been successfully modified");
                alert.setHeaderText("Success!");
                alert.setContentText("Appointment has been successfully modified");
                alert.showAndWait();
                break;

            case 5:
                alert.setTitle("Customer has been removed");
                alert.setHeaderText("Success!");
                alert.setContentText("Customer has been successfully removed");
                alert.showAndWait();
                break;

            case 6:
                alert.setTitle("Customer has been successfully modified");
                alert.setHeaderText("Success!");
                alert.setContentText("Customer has been successfully modified");
                alert.showAndWait();
                break;

            default:
                throw new IllegalStateException("Unexpected value: " + numConfirm);
        }
    }

    public static void getWarning(int numWarning) {
        Alert alert = new Alert(Alert.AlertType.WARNING);
        switch (numWarning) {
            case 1:
                alert.setTitle("Warning Dialog");
                alert.setContentText("ERROR: Appointments must not start or end at same time as existing customer appointments");
                alert.showAndWait();
                break;
            case 2:
                alert.setTitle("Warning Dialog");
                alert.setContentText("ERROR: Appointment start must not be during existing customer appointments");
                alert.showAndWait();
                break;
            case 3:
                alert.setTitle("Warning Dialog");
                alert.setContentText("ERROR: Appointment end must not be during existing customer appointments");
                alert.showAndWait();
                break;
            default:
                throw new IllegalStateException("Unexpected value: " + numWarning);

        }
    }
}
