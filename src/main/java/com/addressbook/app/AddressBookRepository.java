package com.addressbook.app;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AddressBookRepository extends JpaRepository<AddressBook,Long> {
    AddressBook findById(long id);
    List<AddressBook> findAll();
}
