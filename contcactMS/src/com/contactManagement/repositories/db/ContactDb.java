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
    public List<CallRecord> getAllCallHistory(){
        return new ArrayList(callHistory);
    }
    public void addContact(Contact contact){
        contacts.add(contact);
        if (contact.getPersonalNumber()!= null){
            existingNumbers.add(contact.getPersonalNumber());
        }
        if (contact.getOfficeNumber() != null){
            existingNumbers.add(contact.getOfficeNumber());
        }
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
    public Deque getRecentCalls (){
        return recentCalls ;
    }
    public void deleteContact( Contact contact){
        contacts.remove(contact);        // have to specify Id for contact and CallRecord
    }
    public void deleteCallRecord(CallRecord callRecord){
        callHistory.remove(callRecord) ;


    }
    public void removeFromBlockedList ( Contact contact){
        blockednumbers.remove(contact);
    }

}
