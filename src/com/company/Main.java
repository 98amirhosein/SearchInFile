package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        System.out.println("Please enter your directoris : ");
        Scanner sc = new Scanner(System.in);
        String dir = sc.nextLine();
        System.out.println("Please enter your query (contain OR/AND): ");
        String phrase = sc.nextLine();
        searchEngine engin = new searchEngine(dir , phrase);
        }

    }






