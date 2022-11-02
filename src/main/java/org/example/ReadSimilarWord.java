package org.example;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ReadSimilarWord {

    public static void readWordFromFile(String filePath) {


        FileInputStream inputStream;

        Scanner sc;
        ArrayList<String> list= new ArrayList<>();
        FindingAnagrams anagrams = new FindingAnagrams();
        try {

            //checking to make sure the file path is not empty
            if (filePath.isEmpty()) {
                throw new RuntimeException("The file path cannot be empty");
            }
            inputStream = new FileInputStream(filePath);


            sc = new Scanner(inputStream);

            //Reading through the file line by line to prevent memory overload
            while (sc.hasNextLine()) {
                String word = sc.nextLine();

                int lenght = word.length();

                if (!list.isEmpty()) {

                    //Checking for word length change
                    if (lenght == list.get(list.size() - 1).length()) {
                        list.add(word);
                    } else {

                        //performing anagram check on words of the same length will adding new ones to the list
                        anagrams.findAnagram(list);
                        list = new ArrayList<>();
                        list.add(word);
                    }

                } else {
                    list.add(word);
                }

                // note that Scanner suppresses exceptions
                if (sc.ioException() != null) {
                    throw sc.ioException();
                }

            }
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        //Last list on the file check.
        anagrams.findAnagram(list);
        //System.out.println(list);
    }


}
