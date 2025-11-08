package com.contactManagement.features.contact;

import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.Contact;

import java.util.List;

public class ContactModel {

    private ContactView view ;

    ContactModel(ContactView view){
        this.view = view ;
    }
    void viewAllContacts(){
        List<Contact> contacts = ContactDb.getInstance().getAllContacts();
        view.displayAllContacts(contacts);
    }

}
