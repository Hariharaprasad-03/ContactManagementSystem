package com.contactManagement.HomePage;

import com.contactManagement.features.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public class HomeView extends BaseView {

    private List<String> options = new ArrayList<>();

    public void loadOptions() {
        options.add("1 . Contact Menu");
        options.add("2 . Call Logs Menu ");
        options.add("3 . exitApp()");
    }
    public  void init() {

        loadOptions();
        showMenu();
    }

    public void showMenu() {

        while (true) {

            System.out.println(" CMS Main Menu");
            try {
                int option = selectProcess(options);

                switch( option) {

                    case 1 : {
                        new com.contactManagement.features.contact.ContactView().init();
                        break;
                    }
                    case 2 : {
                        new com.contactManagement.features.callHistory.CallHistoryView().init();
                        break;
                    }
                    case 3 : {
                        exitApp();
                    }
                    default:{
                        System.out.println(" please Enter valid Option");
                    }
                }
            }
            catch ( NumberFormatException e) {
                System.out.println("please Enter valid format");
            }


        }
    }
}
