package org.example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {
    @GetMapping("/addressbook")
    public String addressBook(
            @RequestParam(name = "name", required = false, defaultValue = "N/A") String name,
            @RequestParam(name = "phoneNumber", required = false, defaultValue = "N/A") String phoneNumber,
            Model model) {
        AddressBook addressBook = new AddressBook();
        addressBook.addBuddy(new BuddyInfo(name, phoneNumber));
        addressBook.addBuddy(new BuddyInfo("Joe", "222-222-2222"));
        model.addAttribute("addressBook", addressBook);
        return "AddressBook";
    }

    @PostMapping("/addressbook")
        public String addBuddy(
                @RequestParam(name = "name") String name,
                @RequestParam(name = "phoneNumber") String phoneNumber,
                Model model) {
            AddressBook addressBook = new AddressBook();
            addressBook.addBuddy(new BuddyInfo(name, phoneNumber));
            model.addAttribute("addressBook", addressBook);
            return "AddressBook";
        }
    }





