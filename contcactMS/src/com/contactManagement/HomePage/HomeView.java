package com.contactManagement.HomePage;

import com.contactManagement.features.base.BaseView;


public class HomeView extends BaseView  implements Menu{




    public  void init() {

        showMenu();
    }

    public void showMenu() {

        while (true) {

            System.out.println(" CMS Main Menu");
            try {
                int option = selectOption(homeMenu);

                switch( option) {

                    case 1 : {
                        new com.contactManagement.features.contact.ContactView().init();
                        break;
                    }
                    case 2 : {
                        new com.contactManagement.features.callHistory.CallHistoryView().init();
                        break;
                    }
                    case 4 : {
                        exitApp();
                    }
                    case 3 : {
                        new com.contactManagement.features.service.CallView().init();
                        break;
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
