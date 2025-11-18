package com.contactManagement.features.contact;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.search.SearchView;
import com.contactManagement.repositories.dto.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ContactView extends BaseView {

    private ContactModel model ;
    private Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    public ContactView (){
        model = new ContactModel(this);
    }

    public void init(){
        loadOptions();
        showMenu();
    }
    public void loadOptions() {
        options.add("1 : View All Contact List");
        options.add("2 : Manage Contacts ");
        options.add("3 : view Contact Details");
        options.add("4 : search Contact ");
        options.add("5 : Go to Caller");
        options.add("6 : back to MainMenu");
        options.add("7 : Exit App");

    }

    public void showMenu(){

        while( true){

            System.out.println("\n====== Contact Menu ========");
            try {
                int choice = selectProcess(options);

                switch(choice)
                {
                    case 1: {
                        viewAllContacts();
                        break;
                    }
                    case 2 :{
                        new com.contactManagement.features.contact.manage.ManageView().init();
                        break;
                    }
                    case 3 : {
                        new com.contactManagement.features.contact.details.DetailsView().init();
                        break;
                    }
                    case 4 : {
                        new com.contactManagement.features.contact.search.SearchView().init();
                        break;
                    }
                    case 5 :{
                        new com.contactManagement.features.service.CallView().init();
                    }
                    case 7 :{
                        exitApp();
                    }
                    default:{
                        System.out.println("\nplease enter valid Option ");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("\nPlease enter valid Number");
            }
        }



    }
    public void viewAllContacts(){
        model.viewAllContacts();
    }
    public void displayAllContacts(java.util.List<Contact> contacts){

        System.out.println("\nContacts List ");
        System.out.printf("\n%-15s  %-15s" , "Name","PersonalNumber");
        for ( Contact contact : contacts) {

            System.out.printf("\n%-15s  %-15s " , contact.getName(),
                    contact.getPersonalNumber());
        }
    }

}
