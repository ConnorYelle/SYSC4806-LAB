package org.example;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

/**
 * Class BuddyInfo models a buddy for the address book. Each buddy has a Name and a Phone Number
 */

@Entity
public class BuddyInfo {
    private String name;
    private String phoneNumber;
    @Id
    @GeneratedValue
    private long id;
    @ManyToOne
    @JsonIgnore
    private AddressBook addressbook;

    /**
     * Getter for the addressbook instance of the buddyInfo
     * @return The addressbook connected to the buddyInfo
     */
    public AddressBook getaddressbook() {
        return addressbook;
    }

    /**
     * Setter for the addressbook instance of the buddy info
     * @param Address the desired addressbook to connect
     */
    public void setaddressbook(AddressBook Address) {
        this.addressbook = Address;
    }

    /**
     * Default constructor for the BuddyInfo class. Defaults to "N/A" and "000-000-0000".
     */
    public BuddyInfo(){
        name = "N/A";
        phoneNumber = "000-000-0000";
    }

    /**
     * Overloaded constructor for the BuddyInfo class
     * @param name The name of the buddy
     * @param phoneNumber The phone number for the buddy
     */
    public BuddyInfo(String name, String phoneNumber) {
        this.name = name;
        this.phoneNumber = phoneNumber;
    }

    /**
     * Getter for the buddy id
     * @return The id of the buddy
     */
    public long getId() {
        return this.id;
    }

    /**
     * Setter for the buddy id
     * @param id the new id for the buddy
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Getter for the buddy name
     * @return The name of the buddy
     */
    public String getName(){
        return name;
    }

    /**
     * Setter for the buddy name
     * @param name The new buddy name
     */
    public void setName(String name){
        this.name = name;
    }

    /**
     * Getter for the buddy phone number
     * @return The buddy phone number
     */
    public String getPhoneNumber(){
        return phoneNumber;
    }

    /**
     * Setter for the buddy phone number
     * @param phoneNumber The new buddy phone number
     */
    public void setPhoneNumber(String phoneNumber){
        this.phoneNumber = phoneNumber;
    }

}
