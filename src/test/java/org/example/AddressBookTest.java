package org.example;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;


public class AddressBookTest {

    public AddressBook addressBook;

    @BeforeEach
    public void setUp() throws Exception {
        addressBook = new AddressBook();
    }

    @Test
    public void addBuddy() {
        assertEquals(0, addressBook.getBuddies().size());
        BuddyInfo testBuddy1 = new BuddyInfo();
        BuddyInfo testBuddy2 = new BuddyInfo();
        addressBook.addBuddy(testBuddy1);
        assertEquals(1, addressBook.getBuddies().size());
        addressBook.addBuddy(testBuddy2);
        assertEquals(2, addressBook.getBuddies().size());
    }

    @Test
    public void removeBuddy() {
        assertEquals(0, addressBook.getBuddies().size());
        BuddyInfo testBuddy1 = new BuddyInfo();
        BuddyInfo testBuddy2 = new BuddyInfo();
        addressBook.addBuddy(testBuddy1);
        assertEquals(1, addressBook.getBuddies().size());
        addressBook.addBuddy(testBuddy2);
        assertEquals(2, addressBook.getBuddies().size());
        addressBook.removeBuddy(0);
        assertEquals(1, addressBook.getBuddies().size());
        addressBook.removeBuddy(0);
        assertEquals(0, addressBook.getBuddies().size());
    }
}