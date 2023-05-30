package model;

import java.util.Calendar;

/**
 * The abstract class representing a user in the system.
 * It implements the getBiblioProduct interface.
 */
public abstract class User implements getBiblioProduct {
    
    private String user_name; // The name of the user.
    private String id; // The unique ID of the user.
    private Calendar registrationDate; // The registration date of the user.
    private String userType; // The type of the user (regular or premium).

    /**
     * Constructs a User object with the specified user name, ID, registration date, and user type.
     *
     * @param user_name         The name of the user.
     * @param id                The unique ID of the user.
     * @param registrationDate  The registration date of the user.
     * @param userType          The type of the user (regular or premium).
     */
    public User(String user_name, String id, Calendar registrationDate, String userType) {
        this.user_name = user_name;
        this.id = id;
        this.registrationDate = registrationDate;
        this.userType = userType; 
    }

    /**
     * Retrieves the name of the user.
     *
     * @return The name of the user.
     */
    public String getUser_name() {
        return user_name;
    }

    /**
     * Sets the name of the user.
     *
     * @param user_name The name of the user.
     */
    public void setUser_name(String user_name) {
        this.user_name = user_name;
    }

    /**
     * Retrieves the unique ID of the user.
     *
     * @return The unique ID of the user.
     */
    public String getId() {
        return id;
    }

    /**
     * Sets the unique ID of the user.
     *
     * @param id The unique ID of the user.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * Retrieves the registration date of the user.
     *
     * @return The registration date of the user.
     */
    public Calendar getRegistrationDate() {
        return registrationDate;
    }

    /**
     * Sets the registration date of the user.
     *
     * @param registrationDate The registration date of the user.
     */
    public void setRegistrationDate(Calendar registrationDate) {
        this.registrationDate = registrationDate;
    }

    /**
     * Retrieves the type of the user (regular or premium).
     *
     * @return The type of the user.
     */
    public String getUserType() {
        return userType;
    }

    /**
     * Sets the type of the user (regular or premium).
     *
     * @param userType The type of the user.
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }
}

