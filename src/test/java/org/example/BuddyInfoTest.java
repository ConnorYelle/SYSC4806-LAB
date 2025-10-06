package org.example;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class BuddyInfoTest {

    public BuddyInfo buddyInfoTest;
    @BeforeEach
    public void setUp() throws Exception {
        buddyInfoTest = new BuddyInfo("Connor", "111-111-1111");
        buddyInfoTest.setAddress("123 Hello Street");
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

    @Test
    public void getAddressTest() {
        assertEquals("123 Hello Street", buddyInfoTest.getAddress());
    }

    @Test
    public void setAddressTest() {
        buddyInfoTest.setAddress("123 Hello Avenue");
        assertEquals("123 Hello Avenue", buddyInfoTest.getAddress());
    }
}