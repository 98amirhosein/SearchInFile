package com.company;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class searchEngine {
    String files[];

    public searchEngine(String dir, String phrase) {
        this.files = filesLoader(dir);
        phraseGenerator(phrase);
    }

    private String[] filesLoader(String dir) {
        File folder = new File(dir);
        String[] files = folder.list();
        for (int i = 0; i < files.length; i++) {
            files[i] = dir + "/" + files[i];
        }
        return files;
    }


    private void phraseGenerator(String phrase) {
        String and[] = phrase.split("AND");
        for (int i = 0; i < files.length; i++) {
            for (int j = 0; j < and.length; j++) {
                if (!files[i].endsWith(".txt"))
                    continue;
                if (!andSearch(files[i], and[j])) {
                    System.out.println(files[i]);
                    break;

                }
            }
        }
    }

    boolean andSearch(String file, String str) {
        String or[] = str.split("OR");
        for (int i = 0; i < or.length; i++) {
            if (!search(file, or[i].trim()))
                return true;
        }
        return false;
    }

    private boolean search(String file, String str) {
        final Scanner scanner;
        try {
            scanner = new Scanner(new File(file));

            while (scanner.hasNextLine()) {
                final String lineFromFile = scanner.nextLine();
                if (lineFromFile.contains(str)) {
                    return true;
                }
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        return false;
    }

}
