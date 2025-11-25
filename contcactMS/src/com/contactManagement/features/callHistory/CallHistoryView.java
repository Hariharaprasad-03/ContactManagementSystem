package com.contactManagement.features.callHistory;

import com.contactManagement.features.base.BaseView;

import java.util.ArrayList;
import java.util.List;

public class CallHistoryView extends BaseView  implements CallHistoryMenu{

    private CallHistoryModel model ;


    public CallHistoryView() {
        this.model = new CallHistoryModel(this);
    }

    public void init(){

        showMenu();
    }



    public void showMenu() {

        while (true) {

            System.out.println("\n====== Call Histroy View ======");

            try {
                int option = selectOption(callHistoryViewMenu);

                switch(option) {

                    case 1 : {
                        new com.contactManagement.features.callHistory.details.DetailsView().init();
                        break;
                    }
                    case 3 : {
                        new com.contactManagement.HomePage.HomeView().init();
                        return ;
                    }
                    case 4 : {
                        exitApp();
                    }
                    case 2 : {
                        new com.contactManagement.features.callHistory.search.SearchView().init();
                        return;
                    }
                    default:{
                        System.out.println("please enter valid option ");
                        break;
                    }
                }
            } catch( NumberFormatException e){
                System.out.println( " please Enter valid Input format");
            } catch (Exception e){
                System.out.println("please Enter Valid Comment ");
            }


        }
    }
}
