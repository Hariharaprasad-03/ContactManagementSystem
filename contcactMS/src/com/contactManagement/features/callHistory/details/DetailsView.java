package com.contactManagement.features.callHistory.details;

import com.contactManagement.features.base.BaseView;
import com.contactManagement.features.callHistory.CallHistoryView;
import com.contactManagement.repositories.dto.CallRecord;

import java.util.ArrayList;
import java.util.List;

public class DetailsView  extends BaseView {

     private DetailsModel model ;
     List<String> options ;

     public DetailsView()
     {
         this.model = new DetailsModel(this);
         options = new ArrayList<>();
     }

     public void loadOptions(){
         options.add("1 . display All call logs");
         options.add("2 . display Recent call logs");
         options.add("3 . go to Call log menu");
         options.add("4 . Back To MainMenu");
         options.add("5 . exitApp");
     }

     public void init() {
         loadOptions();
         showMenu();
     }
     public void showMenu() {
         while (true) {
             System.out.println("====== Call Log Details Menu  ====");

             try {

                 int option = selectProcess(options);

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
                         break ;
                     }
                     case 4: {
                         System.out.println(" have to code");
                         break;
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
         System.out.printf("%-15s %-15s %-10s","Contact Name","Contact Number","Call Duration");
         for ( CallRecord record : records) {

             System.out.printf("%-15s %-15s %-10s",
                     record.getName(),record.getContactNo(),record.getCallDuration());
         }
     }

     public void getRecentCalls (){
         model.getRecentCalls();
     }

     public void showMessage(String message) {
         System.out.println(message);
     }


}
