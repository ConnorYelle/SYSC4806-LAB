package org.example;

import java.util.ArrayList;
import java.util.List;

import jakarta.persistence.*;

/**
 * AddressBook models a book with a number of BuddyInfo objects. Each Buddy can be removed or added as needed
 */
@Entity
public class AddressBook {

    @Id
    @GeneratedValue
    private long id;
    @OneToMany(mappedBy = "addressbook", cascade = CascadeType.PERSIST) //CascadeType Persist makes it so that all buddies in the list are also persisted
    private List<BuddyInfo> buddies;

    /**
     * Default constructor for the AddressBook. Creates the ArrayList.
     */
    public AddressBook(){
        buddies = new ArrayList<>();
    }

    /**
     * Getter for the buddy ArrayList
     * @return The ArrayList of buddies
     */
    public List<BuddyInfo> getBuddies() {
        return buddies;
    }

    /**
     * Getter for the Id of the AddressBook
     * @return The id of the AddressBook
     */
    public long getId() {
        return id;
    }

    /**
     * Setter for the Id of the AddressBook
     * @param id The new Id of the AddressBook
     */
    public void setId(int id) {
        this.id = id;
    }

    /**
     * Adds a buddy to the end of the list
     * @param buddyInfo The new buddy to be added.
     */
    public void addBuddy(BuddyInfo buddyInfo){
        buddies.add(buddyInfo);
        buddyInfo.setaddressbook(this);
    }

    /**
     * Removes a specific buddy from the list
     * @param index The index of the buddy to be removed.
     */
    public void removeBuddy(int index){
        buddies.remove(index);
    }

    /**
     * Prints out the list of buddies that are present in the AddressBook
     */
    public void printBuddies(){
        for(BuddyInfo buddyInfo : buddies){
            System.out.println("----------------------------------");
            System.out.println("Name: "+ buddyInfo.getName());
            System.out.println("Phone Number: "+ buddyInfo.getPhoneNumber());
            System.out.println("----------------------------------\n");
        }
    }
}
