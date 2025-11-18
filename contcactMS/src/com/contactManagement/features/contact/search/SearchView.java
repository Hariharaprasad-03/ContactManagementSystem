package com.contactManagement.features.contact.search;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.repositories.dto.Contact;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchView extends BaseView {

    private final SearchModel model;
    private final Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    public SearchView(){
        this.model = new SearchModel(this);
    }
    public  void init() {
         loadOptions();
         showMenu();
    }

    public void loadOptions() {

        options.add("1 .  search contact") ;
        options.add("2 .  Go to Contacts Menu");
        options.add("3 . Back To MainMenu") ;
        options.add("3 . exit App()") ;

    }

    private void showMenu(){

        while (true){
            System.out.println("===== Search Contact Details =====");

            try {
                int choice = selectProcess(options) ;

                switch (choice){

                    case 1 : {
                        getSearchDeatsils();
                    }
                    case 2 : {
                        new com.contactManagement.features.contact.ContactView().init();
                    }
                    case 3 : {
                        System.out.println(" have to Code");
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
            return ;
        }
        System.out.println("Search Details :");
        for (Contact c : results){
            System.out.println( c.toString());
        }

    }
}
