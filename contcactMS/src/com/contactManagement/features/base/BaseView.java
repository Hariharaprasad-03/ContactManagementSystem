package com.contactManagement.features.base;

import java.util.List;
import java.util.Scanner;

abstract public class BaseView {

    protected void exitApp(){
        System.out.println(" thank you !");
        System.exit(0);
    }

    public int selectProcess( List<String> process) {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        System.out.println("Select the Option");
        for ( String op : process){

            System.out.println(op);
        }
        System.out.print("\nSelect the Option :");
        option = sc.nextInt();
        return option;
    }
}
