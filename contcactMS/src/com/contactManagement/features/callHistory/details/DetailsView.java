package com.contactManagement.features.callHistory.details;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.callHistory.CallHistoryMenu;
import com.contactManagement.features.callHistory.CallHistoryView;
import com.contactManagement.repositories.dto.CallRecord;

import java.util.ArrayList;
import java.util.List;

public class DetailsView  extends BaseView implements CallHistoryMenu {

     private DetailsModel model ;


     public DetailsView()
     {
         this.model = new DetailsModel(this);

     }



     public void init() {

         showMenu();
     }
     public void showMenu() {
         while (true) {
             System.out.println("\n====== Call Log Details Menu  ====");

             try {

                 int option = selectOption(detailMenu);

                 switch (option) {

                     case 1: {
                         getAllRecords();
                         break;
                     }
                     case 2: {
                         getRecentCalls();
                         break;
                     }
                     case 3: {
                         new CallHistoryView().init();
                         return;
                     }
                     case 4: {
                         new com.contactManagement.HomePage.HomeView().init();
                         return;
                     }
                     case 5: {
                         exitApp();
                     }
                     default: {
                         System.out.println("please Enter the Valid Option ");
                     }

                 }
             } catch (NumberFormatException e) {
                 System.out.println(" Please Enter Valid Number ");
             }
         }
     }

     public void getAllRecords() {

         model.getAllCallLogs();
     }

     public void displayRecords(List<CallRecord> records){
         System.out.printf("%-15s %-15s %-10s %-10s %-10s\n","Contact Name","Contact Number","Duration","Time","Date");
         for ( CallRecord record : records) {

             System.out.printf("%-15s %-15s %-10s %-10s %-10s\n",
                     record.getName(),record.getContactNo(),record.getCallDuration(),record.getTime(),record.getDate());
         }
     }

     public void getRecentCalls (){
         model.getRecentCalls();
     }

     public void showMessage(String message) {
         System.out.println(message);
     }


}
