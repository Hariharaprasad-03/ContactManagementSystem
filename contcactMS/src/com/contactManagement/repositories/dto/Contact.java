package com.contactManagement.repositories.dto;

import java.util.Objects;

public class Contact {

    private String name;
    private String personalNumber;

    public Contact() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPersonalNumber() {
        return personalNumber;
    }

    public void setPersonalNumber(String personalNumber) {
        this.personalNumber = personalNumber;
    }

    // --- New Methods Below ---

    @Override
    public String toString() {
        return "Contact{" +
                "name='" + name + '\'' +
                ", personalNumber='" + personalNumber + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        // 1. Check if it is the exact same reference
        if (this == o) return true;

        // 2. Check if the other object is null or a different class type
        if (o == null || getClass() != o.getClass()) return false;

        // 3. Cast and compare fields
        Contact contact = (Contact) o;
        return Objects.equals(name, contact.name) &&
                Objects.equals(personalNumber, contact.personalNumber);
    }

    @Override
    public int hashCode() {
        // Generates a hash based on the fields used in equals
        return Objects.hash(name, personalNumber);
    }
}