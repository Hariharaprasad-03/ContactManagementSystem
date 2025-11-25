package com.contactManagement.features.contact;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.search.SearchView;
import com.contactManagement.repositories.dto.Contact;


import java.util.Scanner;

public class ContactView extends BaseView  implements ContactMenu{

    private ContactModel model ;
    private final Scanner scanner = new Scanner(System.in);


    public ContactView (){
        model = new ContactModel(this);
    }

    public void init(){

        showMenu();
    }


    public void showMenu(){

        while( true){

            System.out.println("\n====== Contact Menu ========");
            try {
                int choice = selectOption(contactViewMenu);

                switch(choice)
                {
                    case 1: {
                        viewAllContacts();
                        break;
                    }
                    case 2 :{
                        new com.contactManagement.features.contact.manage.ManageView().init();
                        return ;
                    }
                    case 3 : {
                        new com.contactManagement.features.contact.details.DetailsView().init();
                        return ;
                    }
                    case 4 : {
                        new com.contactManagement.features.contact.search.SearchView().init();
                        return ;
                    }
                    case 5 :{
                        new com.contactManagement.features.service.CallView().init();
                        return ;
                    }
                    case 7 :{
                        exitApp();
                    }
                    case 6 : {
                        new com.contactManagement.HomePage.HomeView().init();
                        return ;

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
