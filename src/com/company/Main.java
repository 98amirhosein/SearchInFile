package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String dir = sc.nextLine();
        String phrase = sc.nextLine();
        searchEngine engin = new searchEngine(dir , phrase);
        }

    }






