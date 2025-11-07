package com.contactManagement.features.contact.details;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.repositories.dto.Contact;

import java.util.Scanner;

public class DetailsView  extends BaseView {

    private final DetailsModel model ;
    private final Scanner scanner = new Scanner(System.in);

    DetailsView(){
        this.model = new DetailsModel(this);
    }

    public void init() { showMenu();}

    public void showMenu(){

        while (true){
            System.out.println("====== Contact Details ======");
            System.out.println("1 . view contact details");
            System.out.println("2 . Back to MainMenu");
            System.out.println("3 . exit App");
            System.out.println( " Enter Your Option");

            try{
                int choice = Integer.parseInt(scanner.nextLine().trim());

                switch (choice){
                    case 1 :{
                        viewContactDetails();
                    }
                    case 2: {
                        System.out.println("have to code");
                    }
                    case 3 : {
                        exitApp();
                    }
                    default:{
                        System.out.println(" enter valid option");
                    }
                }
            }
            catch (NumberFormatException e){
                System.out.println(" plese Enter valid Inputs");
            }

        }
    }
    private void viewContactDetails (){
        System.out.println(" Enter Contact Name");
        String name = scanner.nextLine().trim();
        model.getContactDetails(name) ;
    }
    public void displayContactDetails(Contact contact){

        if(contact == null){
            System.out.println(" contact not found !!") ;
            return ;
        }

        System.out.println("===== contact Details =====") ;
        System.out.println("name : " + contact.getName()) ;
        System.out.println("personal Number : " + contact.getPersonalNumber()) ;
        System.out.println("Office Number  : " + contact.getOfficeNumber()) ;
    }

}
