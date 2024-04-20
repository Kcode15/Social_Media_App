package com.example.socialmediaapp;
public class User {

    private String name, ContactNumber, email, password;

    public User(String name, String ContactNumber, String email, String password) {

        this.name = name;

        this.ContactNumber = ContactNumber;

        this.email = email;

        this.password = password;

    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getContactNumber() {
        return ContactNumber;

    }

    public void setContactNumber(String ContactNumber) {
        this.ContactNumber = ContactNumber;
    }

    public String getEmail() {
        return email;

    }

    public void setEmail(String email) {
        this.email = email;

    }

    public String getPassword() {

        return password;
    }
}
