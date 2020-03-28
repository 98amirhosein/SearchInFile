package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class searchEngine {
    String directoris[];

    //constructor
    public searchEngine(String dir, String phrase) {
        this.directoris = filesLoader(dir);
        phraseGenerator(phrase);
    }

    //load Files data
    private String[] filesLoader(String dir) {
        File folder = new File(dir);
        String[] files = folder.list();
        for (int i = 0; i < files.length; i++) {
            files[i] = dir + "/" + files[i];
        }
        return files;
    }

    // generate query to execute
    private void phraseGenerator(String phrase) {
        String and[] = phrase.split("OR");
        for (int i = 0; i < directoris.length; i++) {
            for (int j = 0; j < and.length; j++) {
                if (new File(directoris[i]).isDirectory())
                    continue;
                if (!andSearch(directoris[i], and[j])) {
                    System.out.println(directoris[i]);
                    break;

                }
            }
        }
    }

    //manage query to search and operations
    boolean andSearch(String file, String str) {
        String or[] = str.split("AND");
        for (int i = 0; i < or.length; i++) {
            if (!search(file, or[i].trim()))
                return true;
        }
        return false;
    }

    //search query
    private boolean search(String file, String str) {
        final Scanner scanner;
        try {
            scanner = new Scanner(new File(file));

            while (scanner.hasNextLine()) {
                String lineFromFile = scanner.nextLine();
                lineFromFile = lineFromFile.toLowerCase();
                if (lineFromFile.contains(str.toLowerCase())) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
        }
        return false;
    }

}