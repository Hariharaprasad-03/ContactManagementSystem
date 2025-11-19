package com.contactManagement.features.contact.manage;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.ContactView;
import com.contactManagement.repositories.dto.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ManageView extends BaseView {

    private final  ManageModel model ;
    private final  Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    public ManageView (){
        this.model = new ManageModel(this);
    }
    public void init() {
        loadOptions();
        showMenu();
    }

    public void loadOptions() {
        options.add("1 : Add new Contct") ;
        options.add("2 : Delete Contact") ;
        options.add("3 :Contacts Menu") ;
        options.add("4 : Back to Main Menu") ;
        options.add("5 : Exit") ;
    }

    public void showMenu(){


         while ( true){
             try {

                 System.out.println(" \n======= Contact Mange Menu ====== \n");

                 int choice = selectProcess(options);
                 switch (choice) {
                     case 1: {
                         addNewContact();
                         break;
                     }
                     case 2: {
                         removeContact();
                         break;
                     }
                     case 3: {
                         new ContactView().init();
                     }
                     case 4 : {
                         new com.contactManagement.HomePage.HomeView().init();
                         break;
                     }
                     case 5 : {
                         exitApp();
                     }
                     default: {
                         System.out.println(" please Enter a Valid Option");
                     }
                 }
             }
             catch (NumberFormatException e){
                 System.out.println(" please enter a valid Number");
             }


         }
    }
    public void addNewContact(){

        Contact contact = new Contact();
        System.out.println("Enter Contact Person Name");
        contact.setName(getName());
        contact.setPersonalNumber(getNumber());
        model.addContact(contact);
    }

    public String getName(){
        String name = "";
        do {
            name = scanner.nextLine().trim();

            if (name == null) {
                System.out.println(" Enter valid Name");
            } else {
                break;
            }
        } while(true);

        if (name.charAt(0) >= 'a' && name.charAt(0)<= 'z')
        {
            char ch =Character.toUpperCase( name.charAt(0));
            StringBuilder sb = new StringBuilder(name);
            sb.setCharAt(0,ch);
            name = sb.toString();
        }
        return name;
    }

    public String getNumber(){

        System.out.println("Enter the Number ");
        String  number = "";
        do {
            number = scanner.nextLine().trim();

            if (number == null){
                System.out.println(" Please Enter a Valid Number");
            }
            else break;
        } while(true);
        return number;
    }

    public void removeContact(){

        System.out.println(" Enter name to Remove");
        String nameToRemove = getName();
        model.removeContact(nameToRemove);
    }
    public void addToBlockList()
    {
        System.out.println("Enter name to Add Block list");
        String nameToBlock = getName();
        model.addContactToBlockList(nameToBlock);

    }



    public void showSuccessMessage(String message){
        System.out.println( message );
    }
    public void showErrorMessage( String message){
        System.out.println(message);
    }
}




