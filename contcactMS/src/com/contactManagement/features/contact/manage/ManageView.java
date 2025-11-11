package com.contactManagement.features.contact.manage;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.repositories.dto.Contact;

import java.util.Scanner;

public class ManageView extends BaseView {

    private final  ManageModel model ;
    private final  Scanner scanner = new Scanner(System.in);

    public ManageView (){
        this.model = new ManageModel(this);
    }
    public void init() {
        showMenu();
    }

    public void showMenu(){



         while ( true){

             System.out.println("1 : Add new Contct");
             System.out.println("2 : Delete Contact");
             System.out.println("3 : Back to Main Menu");
             System.out.println("4 : Exit");

             try {
                 System.out.println("Enter your choice");
                 int choice = scanner.nextInt();
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

                     }
                     case 4 :
                         exitApp();
                 }
             }
             catch (NumberFormatException e){
                 System.out.println(" please enter a valid Number");
             }


         }
    }
    public void addNewContact(){

        Contact contact = new Contact();
        contact.setName(getName());
        contact.setPersonalNumber(getNumber());
        contact.setOfficeNumber(getNumber());

        model.addContact(contact);
    }

    public String getName(){
        String name = "";
        do {
            System.out.println("Enter your Name");
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

            if (! validateNumber(number)){
                System.out.println(" Please Enter a Valid Number");
            }
            else break;
        } while(true);
        return number;
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
    public void errorMessage( String message){
        System.out.println(message);
    }
}

