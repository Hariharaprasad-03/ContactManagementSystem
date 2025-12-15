package com.contactManagement.features.contact.details;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.ContactMenu;
import com.contactManagement.features.contact.ContactView;
import com.contactManagement.repositories.dto.Contact;

import java.util.Scanner;

public class DetailsView  extends BaseView implements ContactMenu {

    private final DetailsModel model ;
    private final Scanner scanner = new Scanner(System.in);



     public DetailsView(){
        this.model = new DetailsModel(this);
    }

    public void init() {

         showMenu();
     }


    public void showMenu(){

        while (true){

            System.out.println("======= Contact Details Menu =======");

            try{
                int choice = selectOption(detailsMenu);

                switch (choice){
                    case 1 :{
                        viewContactDetails();
                        break;
                    }
                    case 3: {
                        new com.contactManagement.HomePage.HomeView().init();
                        return ;
                    }
                    case 4 : {
                        exitApp();
                    }
                    case 2 : {
                        new ContactView().init();
                        return ;
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

    }

}
