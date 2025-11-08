//package com.contactManagement.features.contact.Add;
//
//import com.contactManagement.repositories.dto.Contact;
//import java.util.Scanner;
//
//public class AddView {
//
//    private AddModel model ;
//    private Scanner  scanner = new Scanner(System.in);
//
//
//     public AddView(){
//         this.model = new AddModel(this);
//     }
//
//     public void init(){
//        addNewContact();
//     }
//     public void addNewContact(){
//
//         Contact contact = new Contact();
//         contact.setName(getName());
//         contact.setPersonalNumber(getNumber());
//         contact.setOfficeNumber(getNumber());
//
//          model.addContact(contact);
//     }
//
//     public String getName(){
//         String name = "";
//         do {
//             System.out.println("Enter your Name");
//             name = scanner.nextLine().trim();
//
//             if (name == null) {
//                 System.out.println(" Enter valid Name");
//             } else {
//                 break;
//             }
//         } while(true);
//
//         if (name.charAt(0) >= 'a' && name.charAt(0)<= 'z')
//         {
//             char ch =Character.toUpperCase( name.charAt(0));
//             StringBuilder sb = new StringBuilder(name);
//             sb.setCharAt(0,ch);
//             name = sb.toString();
//         }
//         return name;
//     }
//
//     public String getNumber(){
//
//         System.out.println("Enter the Number ");
//         String  number = "";
//         do {
//             number = scanner.nextLine().trim();
//
//             if (! validateNumber(number)){
//                 System.out.println(" Please Enter a Valid Number");
//             }
//             else break;
//         } while(true);
//         return number;
//     }
//     public boolean validateNumber(String number){
//
//         int n = number.length();
//         if( n != 10){
//             return false;
//         }
//         for (int i=0 ; i<n ; ++i){
//
//             char ch = number.charAt(i);
//             if( !( ch >= '0' && ch<='9')){
//                 return false;
//             }
//
//         }
//         return true;
//     }
//
//
//
//     public void showSuccessMessage(String message){
//         System.out.println( message );
//     }
//     public void errorMessage( String message){
//         System.out.println(message);
//     }
//}
