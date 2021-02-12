package com.addressbook.app;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class BuddyInfo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Long id;
    private String name, address, phoneNumber;

    public BuddyInfo(String name, String address, String phoneNumber) {
        this.name = name;
        this.address = address;
        this.phoneNumber = phoneNumber;
    }

    public BuddyInfo() {

    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }
    public Long getId() {
        return id;
    }
    @Override
    public boolean equals(Object o) {
        if (o == this)
            return true;
        if (o == null)
            return false;
        if (this.getClass() != o.getClass())
            return false;
        BuddyInfo obj = (BuddyInfo) o;
        return obj.name.equals(name) && obj.address.equals(address) && obj.phoneNumber.equals(phoneNumber);
    }

    @Override
    public String toString() {
        return "Name: " + this.name + " Address: " + this.address + " PhoneNumber: " + this.phoneNumber;
    }

}
