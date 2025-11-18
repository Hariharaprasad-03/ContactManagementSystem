package com.contactManagement.features.service;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.contact.search.SearchModel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CallView extends BaseView {

    private final Scanner scanner = new Scanner(System.in);
    private List<String> options = new ArrayList<>();

    public CallView(){

    }
    public  void init() {
        loadOptions();
        showMenu();
    }

    public void loadOptions() {

        options.add("1 . make A call") ;
        options.add("2 . Go to Contacts Menu");
        options.add("3 . Back To MainMenu") ;
        options.add("3 . exit App()") ;

    }

    private void showMenu(){

        while (true){
            System.out.println("===== Call page =====");

            try {
                int choice = selectProcess(options) ;

                switch (choice){

                    case 1 : {
                       CallService.getCallService().makeCall();
                       break;
                    }
                    case 2 : {
                        new com.contactManagement.features.contact.ContactView().init();
                        break;
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
}
