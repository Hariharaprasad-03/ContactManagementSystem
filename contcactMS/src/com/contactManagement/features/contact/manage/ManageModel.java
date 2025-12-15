package com.contactManagement.features.contact.manage;

import com.contactManagement.features.base.BaseModel;
import com.contactManagement.repositories.db.ContactDb;
import com.contactManagement.repositories.dto.Contact;

import java.util.Optional;

public class ManageModel extends BaseModel {

    private final  ManageView view ;
    public ManageModel(ManageView view){

        this.view = view ;
    }

     void addContact(Contact contact){

        if( !validateContact(contact)){
            view.showErrorMessage("Invalid Contact");
        }
        else if ( ContactDb.getInstance().isContactExist(contact)) {
            view.showErrorMessage(" This contact is Alreay Exits");
        }
        else {
            ContactDb.getInstance().addContact(contact);
            view.showSuccessMessage("Contact is Added Successfully");
        }
    }
    public boolean validateContact( Contact  contact){

        if( contact.getName() == null){
            view.showErrorMessage("please Enter valid Name");
            return false;
        }
        if ( ! validateNumber(contact.getPersonalNumber()) ){
            return false;
        }
        return true;
    }

    public boolean validateNumber(String number){

        int n = number.length();
        if( n != 10){
            view.showErrorMessage("The contact Number should be 10 digit ");
            return false;
        }
        for (int i=0 ; i<n ; ++i){
            char ch = number.charAt(i);
            if(  ch < '0' && ch >'9'){
                view.showErrorMessage("Contact Number Have Only Integers");
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
            view.showErrorMessage("Contact with name '" + searchName + "' not found.");
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
            view.showErrorMessage("Contact with name '" + searchName + "' not found.");
        }
    }

}
