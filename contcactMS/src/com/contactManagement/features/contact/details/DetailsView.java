package com.contactManagement.features.contact.details;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.repositories.dto.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class DetailsView  extends BaseView {

    private final DetailsModel model ;
    private final Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();


     public DetailsView(){
        this.model = new DetailsModel(this);
    }

    public void init() {

         loadOptions();
         showMenu();
     }
    public void loadOptions() {
         options.add("1 . view contact details");
         options.add("2 . Back to MainMenu");
         options.add("3 . exit App");
    }


    public void showMenu(){

        while (true){

            try{
                int choice = selectProcess(options);

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
