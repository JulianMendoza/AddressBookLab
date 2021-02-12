package com.addressbook.app;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import javax.persistence.*;
import javax.swing.DefaultListModel;
@Entity
public class AddressBook extends DefaultListModel<String> {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    @OneToMany
    private List<BuddyInfo> buddies;
    private String name;

    public AddressBook() {
        buddies = new LinkedList<BuddyInfo>();
    }

    public Long getId() {
        return id;
    }
    public List<BuddyInfo> getBuddies() {
        return this.buddies;
    }

    public void addBuddy(BuddyInfo buddy) {
        if (!buddies.isEmpty()) {
            if(!buddies.contains(buddy)) {
                buddies.add(buddy);
            }
        } else {
            buddies.add(buddy);
        }
    }
    public void setName(String name){
        this.name=name;
    }
    public String getName(){
        return this.name;
    }
    public void removeBuddy(BuddyInfo buddy) {
        buddies.remove(buddy);
    }

}
