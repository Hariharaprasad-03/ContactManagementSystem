package com.contactManagement.features.service;

import com.contactManagement.features.base.BaseView;


import java.util.Scanner;

public class CallView extends BaseView implements CallMenu {

    private final Scanner scanner = new Scanner(System.in);

    public CallView(){

    }
    public  void init() {
        showMenu();
    }


    private void showMenu(){

        while (true){
            System.out.println("===== Call page =====");

            try {
                int choice = selectOption(menu);

                switch (choice){

                    case 1 : {
                       CallService.getCallService().makeCall();
                       return ;
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
}
