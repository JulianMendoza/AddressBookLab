package com.addressbook.app;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class WebController {
    @Autowired
    private AddressBookRepository addressBookRepository;
    @GetMapping("/home")
    public String home(Model model) {
        model.addAttribute("formData", new FormData());
        return "form";
    }
    @PostMapping("/addressBook")
    public String getAddressBook(@ModelAttribute FormData data, Model model){
        AddressBook book = null;
        boolean found = false;
        for (AddressBook b : addressBookRepository.findAll()) {
            if (b.getId() == data.getId()) {
                found = true;
                book = b;
                break;
            }
        }
        if (!found) {
            book = new AddressBook(data.getId());
        }
        book.addBuddy(new BuddyInfo(data.getName(), data.getAddress(), data.getPhoneNumber()));
        addressBookRepository.save(book);
        model.addAttribute("addressBook",book);
        return "addressBook";
    }

}
