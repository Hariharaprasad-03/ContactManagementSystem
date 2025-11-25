package com.contactManagement.features.callHistory.search;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.callHistory.CallHistoryMenu;
import com.contactManagement.features.callHistory.CallHistoryView;
import com.contactManagement.repositories.dto.CallRecord;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class SearchView extends BaseView implements CallHistoryMenu {

    private SearchModel model;
    private Scanner scanner = new Scanner(System.in);

    public SearchView(){
        this.model = new SearchModel(this);

    }



    public void init() {

        showMenu();
    }

    public void showMenu(){

        while(true) {

            System.out.println("===== call history Search view ======");

            try {
                int option = selectOption(searchMenu);

                switch (option) {

                    case 1 : {
                        getContactHistory();
                        break;
                    }
                    case 2 : {
                         new CallHistoryView().init();
                         return ;
                    }
                    case 3 : {
                        new com.contactManagement.HomePage.HomeView().init();
                        return ;
                    }
                    case 4 : {
                        exitApp();
                    }
                    default: {
                        System.out.println(" please Enter Valid Number");
                    }

                }


            }
            catch ( NumberFormatException e) {
                System.out.println(" please Enter a valid Address");
            }
        }
    }

    public void getContactHistory() {
        System.out.println("Enter the Contact Name");
        String name = getName();
        model.getContactCallRecords(name);

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

    public void displayRecords(List <CallRecord> records){

        System.out.println(" Call Logs for " + records.get(0).getName());

        for ( CallRecord record : records) {
            System.out.printf("%-15s %-15s %-10s",
                    record.getName(),record.getContactNo(),record.getCallDuration());
        }
    }

    public void showMessage( String message)  {

        System.out.println(message);
    }

}
