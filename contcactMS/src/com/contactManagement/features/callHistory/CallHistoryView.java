package com.contactManagement.features.callHistory;

import com.contactManagement.features.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public class CallHistoryView extends BaseView {

    private CallHistoryModel model ;
    private List<String> options ;

    public CallHistoryView(){
        this.model = new CallHistoryModel(this);
        options = new ArrayList<>();
    }

    public void init(){
        loadOptions();
        showMenu();
    }

    public void loadOptions() {

        options.add("1 . Call history Details");
        options.add("2 . search call Logs");
        options.add("3 . Back To Main Menu");
        options.add("4 . Exit App");
    }

    public void showMenu() {

        while (true) {

            System.out.println("\n====== Call Histroy View ======");

            try {
                int option = selectProcess(options);

                switch(option) {

                    case 1 : {
                        new com.contactManagement.features.callHistory.details.DetailsView().init();
                        break;
                    }
                    case 3 : {
                        new com.contactManagement.HomePage.HomeView().init();
                        break;
                    }
                    case 4 : {
                        exitApp();
                    }
                    case 2 : {
                        new com.contactManagement.features.callHistory.search.SearchView().init();
                    }
                    default:{
                        System.out.println("please enter valid option ");
                        break;
                    }
                }
            } catch( NumberFormatException e){
                System.out.println( " please Enter valid Input format");
            }


        }
    }
}
