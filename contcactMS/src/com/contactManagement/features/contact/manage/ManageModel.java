package com.contactManagement.features.contact.manage;

import com.contactManagement.features.base.BaseModel;
import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.Contact;

import java.util.Optional;

public class ManageModel extends BaseModel {

    private ManageView view ;
    public ManageModel(ManageView view){
        this.view = view ;
    }

     void addContact(Contact contact){

        if(validateContact(contact)){
            ContactDb.getInstance().addContact(contact);
            view.showSuccessMessage(" Successfully Contact is Added");
            return ;
        }
        view.errorMessage("Invalid contact ");
    }
    public boolean validateContact( Contact  contact){

        if( contact.getName() == null){
            return false;
        }
        boolean num1 = false;
        boolean num2 = false;
        if( contact.getPersonalNumber() != null && validateNumber(contact.getPersonalNumber())){
            num1 = true;
        }
        else {
            contact.setPersonalNumber("");
        }
        if( contact.getOfficeNumber() !=null && validateNumber(contact.getOfficeNumber())){
            num2 = true;
        }
        else {
            contact.setOfficeNumber("");
        }

        return num1 || num2;
    }

    public boolean validateNumber(String number){

        int n = number.length();
        if( n != 10){
            return false;
        }
        for (int i=0 ; i<n ; ++i){

            char ch = number.charAt(i);
            if( !( ch >= '0' && ch<='9')){
                return false;
            }

        }
        return true;
    }

    public void removeContact(String nameToRemove) {

        final String searchName = nameToRemove.trim();

        Optional<Contact> contactOptional =
                ContactDb.getInstance().getAllContacts().stream()

                        .filter(con -> con.getName().equalsIgnoreCase(searchName))
                        .findFirst();

        if (contactOptional.isPresent()) {
            Contact contactToRemove = contactOptional.get();
            ContactDb.getInstance().deleteContact(contactToRemove);

            view.showSuccessMessage("Contact '" + searchName + "' removed successfully.");
        } else {
            view.errorMessage("Contact with name '" + searchName + "' not found.");
        }
    }


    public void addContactToBlockList(String nameToBlock) {
        final String searchName = nameToBlock.trim();


        Optional<Contact> contactOptional =
                ContactDb.getInstance().getAllContacts().stream()
                        .filter(con -> con.getName().equalsIgnoreCase(searchName))
                        .findFirst();

        if (contactOptional.isPresent()) {
            Contact contact = contactOptional.get();
            ContactDb.getInstance().addBlockeList(contact);
            view.showSuccessMessage("Contact '" + searchName + "' added to the block list successfully.");
        } else {
            view.errorMessage("Contact with name '" + searchName + "' not found.");
        }
    }

}
