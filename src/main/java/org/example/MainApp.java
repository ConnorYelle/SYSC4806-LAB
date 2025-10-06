package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MainApp {
    //http://localhost:8080/addressbook?name=Connor&phoneNumber=111-111-1111
    public static void main(String[] args) {
        SpringApplication.run(MainApp.class, args);
    }
}
