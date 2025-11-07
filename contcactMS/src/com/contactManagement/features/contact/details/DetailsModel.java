package com.contactManagement.features.contact.details;

import com.contactManagement.features.base.BaseModel;
import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.Contact;
import java.util.stream.*;

import java.util.Optional;


public class DetailsModel extends BaseModel {

    private final DetailsView view ;

    DetailsModel(DetailsView view){
        this.view = view ;
    }

    public void getContactDetails( String name){
        Optional<Contact> contactOptional = ContactDb.getInstance().getAllContacts().stream()
                .filter(c-> c.getName().equals(name)).findFirst() ;
       view.displayContactDetails(contactOptional.orElse(null));
    }
}
