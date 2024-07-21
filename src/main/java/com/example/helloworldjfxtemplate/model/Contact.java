package com.example.helloworldjfxtemplate.model;

/**
 * Model for a contact
 */
public class Contact {
    private int contactID;
    private String contactName;
    private String contactEmail;

    /**
     * Overloaded constructor for contact
     * @param contactID
     * @param contactName
     * @param contactEmail
     */
    public Contact(int contactID, String contactName, String contactEmail) {
        this.contactID = contactID;
        this.contactName = contactName;
        this.contactEmail = contactEmail;
    }

    /**
     * getContactID getter for contact ID
     * @return contactID
     */
    public int getContactID() {
        return contactID;
    }

    /**
     * setContactID setter for contact ID
     * @param contactID
     */
    public void setContactID(int contactID) {
        this.contactID = contactID;
    }

    /**
     * getContactName getter for contact name
     * @return contactName
     */
    public String getContactName() {
        return contactName;
    }

    /**
     * setContactName setter for contact name
     * @param contactName
     */
    public void setContactName(String contactName) {
        this.contactName = contactName;
    }

    /**
     * getContactEmail getter for contact email
     * @return contactEmail
     */
    public String getContactEmail() {
        return contactEmail;
    }

    /**
     * setContactEmail setter for contact email
     * @param contactEmail
     */
    public void setContactEmail(String contactEmail) {
        this.contactEmail = contactEmail;
    }

    /**
     * Override for toString to print contact name
     * @return contactName
     */
    @Override
    public String toString() {
        return contactName;
    }
}
