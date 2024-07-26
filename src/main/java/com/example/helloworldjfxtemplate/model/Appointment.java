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

/**
 * Model class for Appointment
 */
public class Appointment {
    private int appointID;
    private String appointTitle;
    private String appointDesc;
    private String appointLoc;
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
    private int appointContID;
    private String appointContName;

    /**
     * Overloaded constructor for appointments to get information from database
     * @param appointID
     * @param appointTitle
     * @param appointDesc
     * @param appointLoc
     * @param appointType
     * @param appointStart
     * @param appointEnd
     * @param appointCustID
     * @param appointUserID
     * @param appointContID
     */
    public Appointment(int appointID, String appointTitle, String appointDesc, String appointLoc, String appointType,
                       LocalDateTime appointStart, LocalDateTime appointEnd, int appointCustID, int appointUserID,
                       int appointContID) {
        this.appointID = appointID;
        this.appointTitle = appointTitle;
        this.appointDesc = appointDesc;
        this.appointLoc = appointLoc;
        this.appointType = appointType;
        this.appointStart = appointStart;
        this.appointEnd = appointEnd;
        this.appointCustID = appointCustID;
        this.appointUserID = appointUserID;
        this.appointContID = appointContID;
    }

    /**
     * Overloaded constructor for appointments to get information from database
     * @param appointID
     * @param appointTitle
     * @param appointDesc
     * @param appointLoc
     * @param appointType
     * @param appointStart
     * @param appointEnd
     * @param appointCustID
     * @param appointUserID
     * @param appointContID
     * @param appointContName
     */
    public Appointment(int appointID, String appointTitle, String appointDesc, String appointLoc, String appointType,
                       LocalDateTime appointStart, LocalDateTime appointEnd, int appointCustID, int appointUserID,
                       int appointContID, String appointContName) {
        this.appointID = appointID;
        this.appointTitle = appointTitle;
        this.appointDesc = appointDesc;
        this.appointLoc = appointLoc;
        this.appointType = appointType;
        this.appointStart = appointStart;
        this.appointEnd = appointEnd;
        this.appointCustID = appointCustID;
        this.appointUserID = appointUserID;
        this.appointContID = appointContID;
        this.appointContName = appointContName;
    }

    /**
     * Overloaded constructor for appointments types and totals for a report screen from database
     * @param appointType
     * @param appointTypeTotal
     */
    public Appointment(String appointType, int appointTypeTotal) {
        this.appointType = appointType;
        this.appointTypeTotal = appointTypeTotal;
    }

    /**
     * getAppointID getter for appointment ID
     * @return appointID
     */
    public int getAppointID() {
        return appointID;
    }

    /**
     * setAppointID setter for appointment ID
     * @param appointID
     */
    public void setAppointID(int appointID) {
        this.appointID = appointID;
    }

    /**
     * getAppointTitle getter for appointment title
     * @return appointTitle
     */
    public String getAppointTitle() {
        return appointTitle;
    }

    /**
     * setAppointTitle setter for appointment title
     * @param appointTitle
     */
    public void setAppointTitle(String appointTitle) {
        this.appointTitle = appointTitle;
    }

    /**
     * getAppointDesc getter for appointment description
     * @return appointDesc
     */
    public String getAppointDesc() {
        return appointDesc;
    }

    /**
     * setAppointDesc setter or appointment description
     * @param appointDesc
     */
    public void setAppointDesc(String appointDesc) {
        this.appointDesc = appointDesc;
    }

    /**
     * getAppointLoc getter for appointment location
     * @return appointLoc
     */
    public String getAppointLoc() {
        return appointLoc;
    }

    /**
     * setAppointLoc setter for appointment location
     * @param appointLocation
     */
    public void setAppointLoc(String appointLocation) {
        this.appointLoc = appointLoc;
    }

    /**
     * getAppointType getter for appointment type
     * @return appointType
     */
    public String getAppointType() {
        return appointType;
    }

    /**
     * setAppointType setter for appointment type
     * @param appointType
     */
    public void setAppointType(String appointType) {
        this.appointType = appointType;
    }

    /**
     * getAppointTypeTotal getter for appointment type total
     * @return appointTypeTotal
     */
    public int getAppointTypeTotal() {
        return appointTypeTotal;
    }

    /**
     * setAppointTypeTotal setter for appointment type total
     * @param appointTypeTotal
     */
    public void setAppointTypeTotal(int appointTypeTotal) {
        this.appointTypeTotal = appointTypeTotal;
    }

    /**
     * getAppointStart getter for appointment start date
     * @return appointStart
     */
    public LocalDateTime getAppointStart() {
        return appointStart;
    }

    /**
     * setAppointStart setter for appointment start date
     * @param appointStart
     */
    public void setAppointStart(LocalDateTime appointStart) {
        this.appointStart = appointStart;
    }

    /**
     * getAppointEnd getter for appointment end date
     * @return appointEnd
     */
    public LocalDateTime getAppointEnd() {
        return appointEnd;
    }

    /**
     * setAppointEnd setter for appointment end date
     * @param appointEnd
     */
    public void setAppointEnd(LocalDateTime appointEnd) {
        this.appointEnd = appointEnd;
    }

    /**
     * getAppointCreateDate getter for appointment create date
     * @return appointCreateDate
     */
    public LocalDateTime getAppointCreateDate() {
        return appointCreateDate;
    }

    /**
     * setAppointCreateDate setter for appointment create date
     * @param appointCreateDate
     */
    public void setAppointCreateDate(LocalDateTime appointCreateDate) {
        this.appointCreateDate = appointCreateDate;
    }

    /**
     * getAppointCreatedBy getter for appointment created by
     * @return appointCreatedBy
     */
    public String getAppointCreatedBy() {
        return appointCreatedBy;
    }

    /**
     * setAppointCreatedBy setter for appointment created by
     * @param appointCreatedBy
     */
    public void setAppointCreatedBy(String appointCreatedBy) {
        this.appointCreatedBy = appointCreatedBy;
    }

    /**
     * getAppointUpdateDate for appointment update date
     * @return appointUpdateDate
     */
    public LocalDateTime getAppointUpdateDate() {
        return appointUpdateDate;
    }

    /**
     * setAppointUpdateDate setter for appointment update date
     * @param appointUpdateDate
     */
    public void setAppointUpdateDate(LocalDateTime appointUpdateDate) {
        this.appointUpdateDate = appointUpdateDate;
    }

    /**
     * getAppointUpdatedBy getter for appointment updated by
     * @return appointUpdatedBy
     */
    public String getAppointUpdatedBy() {
        return appointUpdatedBy;
    }

    /**
     * setAppointUpdatedBy setter for appointment updated by
     * @param appointUpdatedBy
     */
    public void setAppointUpdatedBy(String appointUpdatedBy) {
        this.appointUpdatedBy = appointUpdatedBy;
    }

    /**
     *g etAppointCustID getter for appointment customer ID
     * @return appointCustID
     */
    public int getAppointCustID() {
        return appointCustID;
    }

    /**
     * setAppointCustID setter for appointment customer ID
     * @param appointCustID
     */
    public void setAppointCustID(int appointCustID) {
        this.appointCustID = appointCustID;
    }

    /**
     * getAppointUserID getter for appointment User ID
     * @return appointUserID
     */
    public int getAppointUserID() {
        return appointUserID;
    }

    /**
     * setAppointUserID setter for appointment User ID
     * @param appointUserID
     */
    public void setAppointUserID(int appointUserID) {
        this.appointUserID = appointUserID;
    }

    /**
     * getAppointContID getter for appointment contact ID
     * @return appointContID
     */
    public int getAppointContID() {
        return appointContID;
    }

    /**
     * setAppointContID setter for appointment contact ID
     * @param appointContID
     */
    public void setAppointContID(int appointContID) {
        this.appointContID = appointContID;
    }

    /**
     * getAppointContName getter for appointment contact name
     * @return appointContName
     */
    public String getAppointContName() {
        return appointContName;
    }

    /**
     * setAppointContName setter for appointment contact name
     * @param appointContName
     */
    public void setAppointContName(String appointContName) {
        this.appointContName = appointContName;
    }

    /**
     * checkPastDate() method checks specific date to limit it to today and future dates and not let past dates
     * @param appointStart
     * @param appointEnd
     * @return true
     */
    public static boolean checkPastDate(LocalDateTime appointStart, LocalDateTime appointEnd) {
        LocalDateTime currentDate = LocalDateTime.now();
        if ((appointStart.isBefore(currentDate) || appointEnd.isBefore(currentDate)) || (appointEnd.isBefore(appointStart))) {
            Alerts.getWarning(4);
            return true;
        } else {
            return false;
        }
    }

    /**
     * checkOverlap() method checks if appointment for selected contact is overlaping existing appointment in database
     * @param custID
     * @param appointStart
     * @param appointEnd
     * @return true
     */
    public static boolean checkOverlap(int appointID, int custID, LocalDateTime appointStart, LocalDateTime appointEnd) {
        ObservableList<Appointment> appointList = AppointmentDAO.getAppointmentList();
        LocalDateTime checkApptStart, checkApptEnd;
        for (Appointment a : appointList) {
            checkApptStart = a.getAppointStart();
            checkApptEnd = a.getAppointEnd();
            if ((appointID == a.getAppointID()) && (checkApptStart.isEqual(appointStart) && checkApptEnd.isEqual(appointEnd))) {
                break;
            } else if (checkApptStart.isEqual(appointStart) || checkApptEnd.isEqual(appointEnd)) {
                Alerts.getWarning(1);
                return true;
            } else if (appointStart.isAfter(checkApptStart) && appointStart.isBefore(checkApptEnd)) {
                Alerts.getWarning(2);
                return true;
            } else if (appointEnd.isAfter(checkApptStart) && appointEnd.isBefore(checkApptEnd)) {
                Alerts.getWarning(3);
                return true;
            } else if (appointStart.isBefore(checkApptStart) && appointEnd.isAfter(checkApptEnd)) {
                Alerts.getWarning(5);
                return true;
            }
        }
        return false;
    }

    /**
     * localStart() method converts start business hour from American time zone to local
     * @return businessStartLocal
     */
    public static LocalTime localStart() {
        LocalTime openingBusinessTime = LocalTime.of(8, 0);
        ZoneId easternZone = ZoneId.of("America/New_York");
        ZoneId localZone = ZoneId.systemDefault();

        LocalDateTime businessEastern = LocalDateTime.of(LocalDate.now(), openingBusinessTime);
        LocalDateTime businessLocal = businessEastern.atZone(easternZone).withZoneSameInstant(localZone).toLocalDateTime();

        LocalTime businessStartLocal = businessLocal.toLocalTime();

        return businessStartLocal;
    }

    /**
     * localEnd() method converts end business hour from American time zone to local
     * @return businessEndLocal
     */
    public static LocalTime localEnd() {
        LocalTime closingBusinessTime = LocalTime.of(22, 0);
        ZoneId easternZone = ZoneId.of("America/New_York");
        ZoneId localZone = ZoneId.systemDefault();

        LocalDateTime businessEndDT = LocalDateTime.of(LocalDate.now(), closingBusinessTime);
        LocalDateTime businessLocalDT = businessEndDT.atZone(easternZone).withZoneSameInstant(localZone).toLocalDateTime();

        LocalTime businessEndLocal = businessLocalDT.toLocalTime();

        return businessEndLocal;
    }

    /**
     * businessHours() method establishes business hours in ET and converts users local time to check they are within
     * business hours
     * @param appointStart
     * @param appointEnd
     * @return true
     */
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

    /**
     * getTime() method generates 30 min gap in appointment time list
     * @return appointmentTimeList
     */
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
