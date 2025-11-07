package com.contactManagement.features.contact.search;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.repositories.dto.Contact;
import java.util.List;
import java.util.Scanner;

public class SearchView extends BaseView {

    private final SearchModel model;
    private final Scanner scanner = new Scanner(System.in);

    SearchView(){
        this.model = new SearchModel(this);
    }
    public  void init() { showMenu();}

    private void showMenu(){

        while (true){
            System.out.println("===== Search Contact Details =====");
            System.out.println("1 .  search contact");
            System.out.println("2 . Back To MainMenu");
            System.out.println("3 . exit App()");

            try {
                int choice = Integer.parseInt(scanner.nextLine().trim());
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
            System.out.println( " name   :" + c.getName());
            System.out.println(" personal Number :" + c.getPersonalNumber());
            System.out.println("office Number :" + c.getOfficeNumber());
        }

    }
}
