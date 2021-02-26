package com.addressbook.app;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControllerRest {
    private int addressID;
    @Autowired
    private AddressBookRepository addressBookRepository;

    @GetMapping("/addressBook")
    public AddressBook listBook(@RequestParam("id") Long id) {
        for (AddressBook b : addressBookRepository.findAll()) {
            if (b.getId() == id) {
                return b;
            }
        }
        return null;
    }
}
