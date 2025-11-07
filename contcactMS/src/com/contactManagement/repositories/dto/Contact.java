package com.contactManagement.repositories.dto;

import java.util.Objects ;

public class Contact {

    private String name;
    private String personalNumber ;
    private String officeNumber ;

    Contact(){

    }

    public String getName() {
        return name;
    }
    public String getOfficeNumber() {
        return officeNumber;
    }
    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setOfficeNumber(String officeNumber) {
        this.officeNumber = officeNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    @Override
    public String toString(){
        return "*" ;
    }
    @Override
    public  int hashCode(){
        return Objects.hash(name,personalNumber,officeNumber) ;
    }
    @Override
    public boolean equals(Object o){
        if(this == o) return true;
        if(getClass() != o.getClass())return false;
        Contact obj = (Contact) o;
        return ( name == obj.getName() &&
            officeNumber == obj.getOfficeNumber() &&
                personalNumber == obj.getPersonalNumber());
    }

}
