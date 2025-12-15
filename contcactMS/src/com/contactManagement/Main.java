package com.contactManagement;

import com.contactManagement.HomePage.HomeView;


public class Main {

    private static final String version = "1.00";



    public static void main( String[] args) {

        System.out.println("Contact Management APP : " + version);
        new HomeView().init();
    }
}
