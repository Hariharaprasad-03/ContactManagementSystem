package com.contactManagement.features.contact.search;

import com.contactManagement.features.base.BaseModel;
import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.Contact;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

public class SearchModel extends BaseModel{
    private SearchView view ;

    SearchModel(SearchView view){
        this.view = view;
    }
    public void getSearchResults( String name){
        List<Contact>result = ContactDb.getInstance().getAllContacts().stream()
                .filter(c -> c.getName().startsWith(name)).collect(Collectors.toList());
        view.displaySearchResults(result);
    }

}
