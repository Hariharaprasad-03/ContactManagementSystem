package com.contactManagement.features.contact.search;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.ContactMenu;
import com.contactManagement.repositories.dto.Contact;


import java.util.List;
import java.util.Scanner;

public class SearchView extends BaseView implements ContactMenu {

    private final SearchModel model;
    private final Scanner scanner = new Scanner(System.in);


    public SearchView(){
        this.model = new SearchModel(this);
    }
    public  void init() {

         showMenu();
    }

    private void showMenu(){

        while (true){
            System.out.println("===== Search Contact Details =====");

            try {
                int choice = selectOption(searchMenu) ;

                switch (choice){

                    case 1 : {
                        getSearchDeatsils();
                        break;
                    }
                    case 2 : {
                        new com.contactManagement.features.contact.ContactView().init();
                        return ;
                    }
                    case 3 : {
                        new com.contactManagement.HomePage.HomeView().init();
                        return ;
                    }
                    case 4 : {
                        exitApp();
                    }
                }
            }
            catch ( NumberFormatException e){
                System.out.println(" please enter valid Number ");
            }
        }
    }
    public void getSearchDeatsils(){
        System.out.println("Enter contact Name :");
        String name = scanner.nextLine().trim() ;
        model.getSearchResults(name) ;
    }
    public void displaySearchResults(List<Contact> results){
        if ( results == null || results.size()==0){
            System.out.println(" No results Found !");
            getSearchDeatsils();  // Added for not to retrive the BackPage
            return ;
        }
        System.out.println("Search Details :");
        for (Contact contact : results){
            System.out.printf("\n%-15s  %-15s " , contact.getName(),
                    contact.getPersonalNumber());
        }

    }
}
