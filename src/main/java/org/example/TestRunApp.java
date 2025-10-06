package org.example;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class TestRunApp {

    private static final Logger log = LoggerFactory.getLogger(TestRunApp.class);

    public static void main(String[] args) {
        SpringApplication.run(TestRunApp.class, args);
    }

    @Bean
    public CommandLineRunner commandLineRunner(BuddyInfoRepository repository1) {
        return args -> {
            repository1.save(new BuddyInfo("Connor", "111-111-1111"));
            repository1.save(new BuddyInfo("Joe", "222-222-2222"));
            repository1.save(new BuddyInfo("Mary", "333-333-3333"));
            log.info("");

            log.info("TEST FOR BUDDYINFO REPOSITORY");
            log.info("Buddies found with findAll():");
            log.info("-------------------------------");
            repository1.findAll().forEach(buddy -> {
                log.info("ID: " + buddy.getId()
                        + ", Name: " + buddy.getName() + ", Phone Number: " + buddy.getPhoneNumber());
            });
            log.info("");

            BuddyInfo buddy1 = repository1.findById(1);
            log.info("Customer found with findById(1):");
            log.info("--------------------------------");
            log.info("ID: " + buddy1.getId()
                    + ", Name: " + buddy1.getName() + ", Phone Number: " + buddy1.getPhoneNumber());

            log.info("");

            BuddyInfo buddy2 = repository1.findById(2);
            log.info("Customer found with findById(2):");
            log.info("--------------------------------");
            log.info("ID: " + buddy2.getId()
                    + ", Name: " + buddy2.getName() + ", Phone Number: " + buddy2.getPhoneNumber());

            log.info("");

        };
    }

    @Bean
    public CommandLineRunner commandLineRunner2(AddressBookRepository repository2) {
        return args -> {
            AddressBook addressBook = new AddressBook();
            BuddyInfo buddyInfo1 = new BuddyInfo("Connor", "111-111-1111");
            BuddyInfo buddyInfo2 = new BuddyInfo("Joe", "222-222-2222");
            BuddyInfo buddyInfo3 = new BuddyInfo("Mary", "333-333-3333");

            addressBook.addBuddy(buddyInfo1);
            addressBook.addBuddy(buddyInfo2);
            addressBook.addBuddy(buddyInfo3);

            repository2.save(addressBook);

            // Logging
            log.info("");
            log.info("TEST FOR ADDRESSBOOK REPOSITORY");
            log.info("AddressBook saved with the following buddies:");
            log.info("-------------------------------------------");
            addressBook.getBuddies().forEach(buddy -> {
                log.info("ID: " + buddy.getId()
                        + ", Name: " + buddy.getName()
                        + ", Phone Number: " + buddy.getPhoneNumber());
            });
            log.info("");
        };
    }
}
