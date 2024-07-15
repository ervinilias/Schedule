package com.example.helloworldjfxtemplate.model;

import com.example.helloworldjfxtemplate.DAO.AppointmentDAO;
import com.example.helloworldjfxtemplate.helper.Alerts;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Alert;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.ZoneId;
import java.time.format.DateTimeFormatter;

public class Appointment {
    private int appointID;
    private String appointTitle;
    private String appointDesc;
    private String appointLocation;
    private String appointType;
    private int appointTypeTotal;
    private LocalDateTime appointStart;
    private LocalDateTime appointEnd;
    private LocalDateTime appointCreateDate;
    private String appointCreatedBy;
    private LocalDateTime appointUpdateDate;
    private String appointUpdatedBy;
    private int appointCustID;
    private int appointUserID;
    private int appointContactID;
    private String appointContactName;

    public Appointment(int appointID, String appointTitle, String appointDesc, String appointLocation, String appointType,
                       LocalDateTime appointStart, LocalDateTime appointEnd, int appointCustID, int appointUserID,
                       int appointContactID) {
        this.appointID = appointID;
        this.appointTitle = appointTitle;
        this.appointDesc = appointDesc;
        this.appointLocation = appointLocation;
        this.appointType = appointType;
        this.appointStart = appointStart;
        this.appointEnd = appointEnd;
        this.appointCustID = appointCustID;
        this.appointUserID = appointUserID;
        this.appointContactID = appointContactID;
    }

    public Appointment(int appointID, String appointTitle, String appointDesc, String appointLocation, String appointType,
                       LocalDateTime appointStart, LocalDateTime appointEnd, int appointCustID, int appointUserID,
                       int appointContactID, String appointContactName) {
        this.appointID = appointID;
        this.appointTitle = appointTitle;
        this.appointDesc = appointDesc;
        this.appointLocation = appointLocation;
        this.appointType = appointType;
        this.appointStart = appointStart;
        this.appointEnd = appointEnd;
        this.appointCustID = appointCustID;
        this.appointUserID = appointUserID;
        this.appointContactID = appointContactID;
        this.appointContactName = appointContactName;
    }

    public Appointment(String appointType, int appointTypeTotal) {
        this.appointType = appointType;
        this.appointTypeTotal = appointTypeTotal;
    }

    public int getAppointID() {
        return appointID;
    }

    public void setAppointID(int appointID) {
        this.appointID = appointID;
    }

    public String getAppointTitle() {
        return appointTitle;
    }

    public void setAppointTitle(String appointTitle) {
        this.appointTitle = appointTitle;
    }

    public String getAppointDesc() {
        return appointDesc;
    }

    public void setAppointDesc(String appointDesc) {
        this.appointDesc = appointDesc;
    }

    public String getAppointLocation() {
        return appointLocation;
    }

    public void setAppointLocation(String appointLocation) {
        this.appointLocation = appointLocation;
    }

    public String getAppointType() {
        return appointType;
    }

    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    public int getAppointTypeTotal() {
        return appointTypeTotal;
    }

    public void setAppointTypeTotal(int appointTypeTotal) {
        this.appointTypeTotal = appointTypeTotal;
    }

    public LocalDateTime getAppointStart() {
        return appointStart;
    }

    public void setAppointStart(LocalDateTime appointStart) {
        this.appointStart = appointStart;
    }

    public LocalDateTime getAppointEnd() {
        return appointEnd;
    }

    public void setAppointEnd(LocalDateTime appointEnd) {
        this.appointEnd = appointEnd;
    }

    public LocalDateTime getAppointCreateDate() {
        return appointCreateDate;
    }

    public void setAppointCreateDate(LocalDateTime appointCreateDate) {
        this.appointCreateDate = appointCreateDate;
    }

    public String getAppointCreatedBy() {
        return appointCreatedBy;
    }

    public void setAppointCreatedBy(String appointCreatedBy) {
        this.appointCreatedBy = appointCreatedBy;
    }

    public LocalDateTime getAppointUpdateDate() {
        return appointUpdateDate;
    }

    public void setAppointUpdateDate(LocalDateTime appointUpdateDate) {
        this.appointUpdateDate = appointUpdateDate;
    }

    public String getAppointUpdatedBy() {
        return appointUpdatedBy;
    }

    public void setAppointUpdatedBy(String appointUpdatedBy) {
        this.appointUpdatedBy = appointUpdatedBy;
    }

    public int getAppointCustID() {
        return appointCustID;
    }

    public void setAppointCustID(int appointCustID) {
        this.appointCustID = appointCustID;
    }

    public int getAppointUserID() {
        return appointUserID;
    }

    public void setAppointUserID(int appointUserID) {
        this.appointUserID = appointUserID;
    }

    public int getAppointContactID() {
        return appointContactID;
    }

    public void setAppointContactID(int appointContactID) {
        this.appointContactID = appointContactID;
    }

    public String getAppointContactName() {
        return appointContactName;
    }

    public void setAppointContactName(String appointContactName) {
        this.appointContactName = appointContactName;
    }

    public static boolean checkOverlap(int custID, LocalDateTime appointStart, LocalDateTime appointEnd) {
        ObservableList<Appointment> appointList = AppointmentDAO.getAppointmentList();
        LocalDateTime checkApptStart, checkApptEnd;
        for (Appointment a : appointList) {
            checkApptStart = a.getAppointStart();
            checkApptEnd = a.getAppointEnd();
            if (custID == a.getAppointCustID()) {
                if (checkApptStart.isEqual(appointStart) || checkApptEnd.isEqual(appointEnd)) {
                    Alerts.getWarning(1);
                    return true;
                } else if (appointStart.isAfter(checkApptStart) && appointStart.isBefore(checkApptEnd)) {
                    Alerts.getWarning(2);
                    return true;
                } else if (appointEnd.isAfter(checkApptStart) && appointEnd.isBefore(checkApptEnd)) {
                    Alerts.getWarning(3);
                    return true;
                }
            }
        }
        return false;
    }

    public static LocalTime localStart() {
        LocalTime openingBusinessTime = LocalTime.of(8, 0);
        ZoneId easternZone = ZoneId.of("America/New_York");
        ZoneId localZone = ZoneId.systemDefault();

        LocalDateTime businessEastern = LocalDateTime.of(LocalDate.now(), openingBusinessTime);
        LocalDateTime businessLocal = businessEastern.atZone(easternZone).withZoneSameInstant(localZone).toLocalDateTime();

        LocalTime businessStartLocal = businessLocal.toLocalTime();

        return businessStartLocal;
    }

    public static LocalTime localEnd() {
        LocalTime closingBusinessTime = LocalTime.of(22, 0);
        ZoneId easternZone = ZoneId.of("America/New_York");
        ZoneId localZone = ZoneId.systemDefault();

        LocalDateTime businessEndDT = LocalDateTime.of(LocalDate.now(), closingBusinessTime);
        LocalDateTime businessLocalDT = businessEndDT.atZone(easternZone).withZoneSameInstant(localZone).toLocalDateTime();

        LocalTime businessEndLocal = businessLocalDT.toLocalTime();

        return businessEndLocal;
    }

    public static boolean businessHours(LocalDateTime appointStart, LocalDateTime appointEnd) {
        ZoneId localZone = ZoneId.systemDefault();
        ZoneId estZone = ZoneId.of("America/New_York");

        LocalDateTime appStartEST = appointStart.atZone(localZone).withZoneSameInstant(estZone).toLocalDateTime();
        LocalDateTime appEndEST = appointEnd.atZone(localZone).withZoneSameInstant(estZone).toLocalDateTime();

        LocalDateTime businessStartEST = appStartEST.withHour(8).withMinute(0);
        LocalDateTime businessEndEST = appEndEST.withHour(22).withMinute(0);

        if (appStartEST.isBefore(businessStartEST) || appEndEST.isAfter(businessEndEST)) {
            LocalTime localStart = Appointment.localStart();
            LocalTime localEnd = Appointment.localEnd();
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("Outside of Business Hours");
            alert.setContentText(String.format("Appointment is outside of business hours: 8:00AM to 10:00PM EST\n" +
                    "Please schedule between " + localStart.format(DateTimeFormatter.ofPattern("hh:mm")) + " - " + localEnd.format(DateTimeFormatter.ofPattern("hh:mm")) + "PM local time."));

            alert.showAndWait();
            return true;
        } else {
            return false;
        }
    }

    public static ObservableList<LocalTime> getTime() {
        ObservableList<LocalTime> appointmentTimeList = FXCollections.observableArrayList();
        LocalTime start = LocalTime.of(1, 00);
        LocalTime end = LocalTime.MIDNIGHT.minusHours(1);

        while (start.isBefore(end.plusSeconds(2))) {
            appointmentTimeList.add(start);
            start = start.plusMinutes(30);
        }
        return appointmentTimeList;
    }
}
