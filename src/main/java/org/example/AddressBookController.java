package org.example;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AddressBookController {

    private final AddressBook addressBook = new AddressBook();

    public AddressBookController() {
        addressBook.addBuddy(new BuddyInfo("Joe", "222-222-2222"));
    }

    @GetMapping("/addressbook")
    public String addressBook(
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "phoneNumber", required = false) String phoneNumber,
            @RequestParam(name = "address", required = false) String address,
            Model model) {
        if (name != null && phoneNumber != null) {
            BuddyInfo buddyInfo = new BuddyInfo(name, phoneNumber);
            buddyInfo.setAddress(address);
            addressBook.addBuddy(buddyInfo);
        }
        model.addAttribute("addressBook", addressBook);
        return "AddressBook";
    }

    @PostMapping("/addressbook")
    public String addBuddy(
            @RequestParam(name = "name") String name,
            @RequestParam(name = "phoneNumber") String phoneNumber,
            Model model) {
        addressBook.addBuddy(new BuddyInfo(name, phoneNumber));
        model.addAttribute("addressBook", addressBook);
        return "AddressBook";
    }
}





