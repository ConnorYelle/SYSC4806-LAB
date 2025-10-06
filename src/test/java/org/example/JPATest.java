package org.example;

import jakarta.persistence.EntityManager;
import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.EntityTransaction;
import jakarta.persistence.Persistence;
import jakarta.persistence.Query;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;
import java.util.List;

public class JPATest {

    @Test
    public void performJPA(){
        //Create BuddyInfo objects for persistence testing
        BuddyInfo buddyInfoTest1 = new BuddyInfo();
        buddyInfoTest1.setName("Connor");
        buddyInfoTest1.setPhoneNumber("111-111-1112");

        BuddyInfo buddyInfoTest2 = new BuddyInfo();
        buddyInfoTest2.setName("Joe");
        buddyInfoTest2.setPhoneNumber("222-222-2221");

        //Database connection
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("lab2");
        EntityManager em = emf.createEntityManager();

        //Create addressbook
        AddressBook addressBookTest1 = new AddressBook();
        addressBookTest1.addBuddy(buddyInfoTest1);
        addressBookTest1.addBuddy(buddyInfoTest2);

        //New transaction
        EntityTransaction tx = em.getTransaction();
        tx.begin();
        em.persist(addressBookTest1);
        tx.commit();

        Query query = em.createQuery("select a from AddressBook a ORDER BY a.id ASC"); // ORDER BY makes the query results ordered by id

        @SuppressWarnings("unchecked")
        List<AddressBook> results = query.getResultList();

        assertEquals(1, results.size()); //Test amount of objects in the query

        assertEquals("Connor", results.get(0).getBuddies().get(0).getName()); //Check name
        assertEquals("111-111-1112", results.get(0).getBuddies().get(0).getPhoneNumber()); //Check phone number string
        assertEquals(1, results.get(0).getBuddies().get(0).getId()); //Check ID

        assertEquals("Joe", results.get(0).getBuddies().get(1).getName()); //Check name
        assertEquals("222-222-2221", results.get(0).getBuddies().get(1).getPhoneNumber()); //Check phone number string
        assertEquals(2, results.get(0).getBuddies().get(1).getId()); //Check ID

        em.close();
        emf.close();
    }

}
