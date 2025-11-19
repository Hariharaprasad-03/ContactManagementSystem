package com.contactManagement.repositories.db;

import com.contactManagement.repositories.dto.CallRecord;
import com.contactManagement.repositories.dto.Contact;
import com.contactManagement.repositories.dto.UserInfo;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

public class ContactDb {
    private List<Contact> contacts = new ArrayList<>();
    private List<CallRecord> callHistory = new ArrayList<>();
    private Deque<CallRecord> recentCalls = new ArrayDeque<>();
    private List<String>existingNumbers = new ArrayList<>();
    private  List<Contact>blockednumbers = new ArrayList<>();

    private static ContactDb dbInstance;
    private UserInfo info ;

    private ContactDb(){ }

    public  static ContactDb getInstance(){  // singletonLogic
        if (dbInstance == null)
            dbInstance =new ContactDb();
        return dbInstance;
    }

    public List<Contact> getAllContacts(){
        return new ArrayList(contacts);
    }

    public List<CallRecord> getAllCallHistory()
    {
        return new ArrayList(callHistory);
    }

    public boolean isContactExist( Contact contact) {

        int index = contacts.indexOf(contact);

        return index > 0;
    }

    public void addContact(Contact contact){
        contacts.add(contact);

    }

    public void addCallRecord(CallRecord callRecord){
        callHistory.add(0,callRecord);

        if (recentCalls.size() >=5){
            recentCalls.removeLast();
            recentCalls.offerFirst(callRecord);
        }
        else {
            recentCalls.offer(callRecord);
        }
    }

    public void addBlockeList(Contact contact){

       blockednumbers.add(contact);
    }

   // To get recent Calls
    public List<CallRecord> getRecentCalls (){
        return new ArrayList<>(recentCalls);
    }
    // To delete a Contact :
    public void deleteContact( Contact contact){
        contacts.remove(contact);
    }
   // To delete Call Record
    public void deleteCallRecord(CallRecord callRecord){
        callHistory.remove(callRecord) ;
    }

   // Remove call record from History
    public void removeFromBlockedList ( Contact contact){
        blockednumbers.remove(contact);
    }

}
