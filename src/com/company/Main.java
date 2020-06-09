package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter your directoris : ");
        Scanner sc = new Scanner(System.in);
        String dir = sc.nextLine();
        System.out.println("Please enter your query (contain OR/AND): ");
        String phrase = sc.nextLine();
        try {
            searchEngine engin = new searchEngine(dir, phrase);

        } catch (Exception e) {
            System.out.println("your input is wrong! \n\t\t\t\t please try again <3");
        }
    }

}






