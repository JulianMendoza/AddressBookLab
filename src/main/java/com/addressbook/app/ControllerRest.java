package com.addressbook.app;

import org.springframework.beans.factory.annotation.*;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ControllerRest {
    @Autowired
    private BuddyInfoRepository buddyInfoRepository;
    @PostMapping("/home")
    public List<BuddyInfo> listAll(@ModelAttribute BuddyInfo buddyInfo, Model model){
        buddyInfoRepository.save(buddyInfo);
        return buddyInfoRepository.findAll();
    }
}
