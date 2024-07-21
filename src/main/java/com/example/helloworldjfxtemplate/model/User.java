package com.example.helloworldjfxtemplate.model;

import java.time.LocalDateTime;

public class User {
    private int userID;
    private String username;
    private String password;
    private LocalDateTime createDate;
    private String createdBy;
    private LocalDateTime lastUpdate;
    private  String lastUpdatedBy;

    /**
     * Overloaded User contructor
     * @param userID
     * @param username
     * @param password
     * @param createDate
     * @param createdBy
     * @param lastUpdate
     * @param lastUpdatedBy
     */
    public User(int userID, String username, String password, LocalDateTime createDate, String createdBy, LocalDateTime lastUpdate, String lastUpdatedBy) {
        this.userID = userID;
        this.username = username;
        this.password = password;
        this.createDate = createDate;
        this.createdBy = createdBy;
        this.lastUpdate = lastUpdate;
        this.lastUpdatedBy = lastUpdatedBy;
    }

    /**
     * Overloaded User contructor
     * @param username
     */
    public User(String username) {
        this.username = username;
    }

    /**
     * Overloaded User contructor
     * @param userID
     * @param username
     */
    public User(int userID, String username) {
        this.userID = userID;
        this.username = username;
    }

    /**
     * getUserID getter for user ID
     * @return userID
     */
    public int getUserID() {
        return userID;
    }

    /**
     *  setUserID setter for user ID
     * @param userID
     */
    public void setUserID(int userID) {
        this.userID = userID;
    }

    /**
     * getUsername getter for username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * setUsername setter for username
     * @param username
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * getCreateDate getter for created date
     * @return createDate
     */
    public LocalDateTime getCreateDate() {
        return createDate;
    }

    /**
     * setCreateDate setter for create date
     * @param createDate
     */
    public void setCreateDate(LocalDateTime createDate) {
        this.createDate = createDate;
    }

    /**
     * getCreatedBy getter for created by
     * @return createdBy
     */
    public String getCreatedBy() {
        return createdBy;
    }

    /**
     * setCreatedBy setter for created by
     * @param createdBy
     */
    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }

    /**
     * getLastUpdate getter for last update
     * @return lastUpdate
     */
    public LocalDateTime getLastUpdate() {
        return lastUpdate;
    }

    /**
     * setLastUpdate setter for last update
     * @param lastUpdate
     */
    public void setLastUpdate(LocalDateTime lastUpdate) {
        this.lastUpdate = lastUpdate;
    }

    /**
     * Override toString to print userID and username
     * @return username
     */
    @Override
    public String toString() {
        return "#" + Integer.toString(userID) + " - " + username;
    }
}
