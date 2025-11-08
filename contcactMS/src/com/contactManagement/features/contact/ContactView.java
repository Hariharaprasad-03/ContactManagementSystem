package com.contactManagement.features.contact;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.search.SearchView;
import com.contactManagement.repositories.dto.Contact;
import java.util.Scanner;

public class ContactView extends BaseView {

    private ContactModel model ;
    private Scanner scanner = new Scanner(System.in);

    public ContactView (){
        model = new ContactModel(this);
    }
    public void init(){
        showMenu();
    }
    public void showMenu(){

        while( true){

            System.out.println("1 : View All Contact List");
            System.out.println("2 : Manage Contacts ");
            System.out.println("3 : view Contact Details");
            System.out.println("4 : search Contact ");
            System.out.println("5 : back to MainMenu");
            System.out.println("6 : Exit App");
            System.out.println("\nEnter your Option");
            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());

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
                        return;
                    }
                    case 6 :{
                        exitApp();
                    }
                    default:{
                        System.out.println(" please enter valid Option ");
                    }
                }

            } catch (NumberFormatException e) {
                System.out.println("Please enter valid Number");
            }
        }



    }
    public void viewAllContacts(){
        model.viewAllContacts();
    }
    public void displayAllContacts(java.util.List<Contact> contacts){

        System.out.println("Contacts List ");
        System.out.printf("%-15s  %-15s %-15s" , "Name","PersonalNumber","officeNumber");
        for ( Contact contact : contacts) {

            System.out.printf("%-15s  %-15s %-15s" , contact.getName(),
                    contact.getPersonalNumber(),contact.getOfficeNumber());
        }
    }

}
