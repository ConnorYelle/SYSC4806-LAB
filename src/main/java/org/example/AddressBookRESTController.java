package org.example;

import org.springframework.web.bind.annotation.*;
import java.util.List;


@RestController
public class AddressBookRESTController{

    AddressBook addressBook = new AddressBook();
    @GetMapping("/addressbookREST")
    public List<BuddyInfo> getAllBuddies() {
        return this.addressBook.getBuddies();
    }


    //POST FORMAT:
    // {
    //  "name": "Connor",
    //  "phoneNumber": "123-456-0000"
    //  "id": 1
    // }
    @PostMapping("/addressbookREST")
    public String addBuddy(@RequestBody BuddyInfo buddyInfo) {
        addressBook.addBuddy(buddyInfo);
        return "Buddy added successfully";
    }

    @DeleteMapping("/addressbookREST/{index}")
    public String deleteBuddy(@PathVariable int index) {
        if (index >= 0 && index < addressBook.getBuddies().size()) {
            addressBook.removeBuddy(index);
            return "Buddy deleted successfully";
        } else {
            return "Invalid buddy index";
        }
    }
}
