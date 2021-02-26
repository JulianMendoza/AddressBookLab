package com.addressbook.app;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class FormData {
    private long addressBookID;
    private String name, address, phoneNumber;
    private Long id;
    public FormData(){

    }
    public long getAddressBookID() {
        return addressBookID;
    }

    public void setAddressBookID(long addressBookID) {
        this.addressBookID = addressBookID;
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

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    public Long getId() {
        return id;
    }
}
