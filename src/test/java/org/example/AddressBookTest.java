package org.example;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;


public class AddressBookTest {

    public AddressBook addressBook;

    @Before
    public void setUp() throws Exception {
        addressBook = new AddressBook();
    }

    @Test
    public void addBuddy() {
        Assert.assertEquals(0, addressBook.getBuddies().size());
        BuddyInfo testBuddy1 = new BuddyInfo();
        BuddyInfo testBuddy2 = new BuddyInfo();
        addressBook.addBuddy(testBuddy1);
        Assert.assertEquals(1, addressBook.getBuddies().size());
        addressBook.addBuddy(testBuddy2);
        Assert.assertEquals(2, addressBook.getBuddies().size());
    }

    @Test
    public void removeBuddy() {
        Assert.assertEquals(0, addressBook.getBuddies().size());
        BuddyInfo testBuddy1 = new BuddyInfo();
        BuddyInfo testBuddy2 = new BuddyInfo();
        addressBook.addBuddy(testBuddy1);
        Assert.assertEquals(1, addressBook.getBuddies().size());
        addressBook.addBuddy(testBuddy2);
        Assert.assertEquals(2, addressBook.getBuddies().size());
        addressBook.removeBuddy(testBuddy1);
        Assert.assertEquals(1, addressBook.getBuddies().size());
        addressBook.removeBuddy(testBuddy2);
        Assert.assertEquals(0, addressBook.getBuddies().size());
    }
}