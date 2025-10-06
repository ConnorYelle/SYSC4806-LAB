package org.example;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class BuddyInfoTest {

    public BuddyInfo buddyInfoTest;
    @Before
    public void setUp() throws Exception {
        buddyInfoTest = new BuddyInfo("Connor", "111-111-1111");
    }

    @Test
    public void getName() {
        assertEquals("Connor", buddyInfoTest.getName());
    }

    @Test
    public void setName() {
        buddyInfoTest.setName("Joe");
        assertEquals("Joe", buddyInfoTest.getName());
    }

    @Test
    public void getPhoneNumber() {
        assertEquals("111-111-1111", buddyInfoTest.getPhoneNumber());
    }

    @Test
    public void setPhoneNumber() {
        buddyInfoTest.setPhoneNumber("222-222-2222");
        assertEquals("222-222-2222", buddyInfoTest.getPhoneNumber());
    }
}