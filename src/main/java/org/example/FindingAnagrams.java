package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;

public class FindingAnagrams {

    public  ArrayList<ArrayList<String>> findAnagram(
            ArrayList<String> list)
    {

        // Hashmap Inner: This hold each character in the  word as key and the frequency of occurence as value

        // Hashmap Outer: This holds the hash of the character and frequency as a key and the list of for matching that key as a value

        HashMap<HashMap<Character, Integer>, ArrayList<String>> map = new HashMap<>();
        for (String str : list) {
            HashMap<Character, Integer>
                    tempMap = new HashMap<>();

            // Here is a loop for counting the number of occurrence of a character in a word
            for (int i = 0; i < str.length(); i++) {
                //If the character already exists, it is retrieved and the value counter increased
                if (tempMap.containsKey(str.charAt(i))) {
                    int x = tempMap.get(str.charAt(i));
                    tempMap.put(str.charAt(i), ++x);
                }
                else {
                    //First occurrence is added a key and value
                    tempMap.put(str.charAt(i), 1);
                }
            }


            // If the hashset with the same compbination already exist, the word is added to the list
            if (map.containsKey(tempMap))
                map.get(tempMap).add(str);
            else {

                //If not a new list is created
                ArrayList<String>
                        tempList = new ArrayList<>();
                tempList.add(str);
                map.put(tempMap, tempList);
            }
        }

        // Stores the result in a arraylist
        ArrayList<ArrayList<String> >
                result = new ArrayList<>();
        for (HashMap<Character, Integer> temp : map.keySet()) {
            result.add(map.get(temp));
           //Print each category on a list.
            String printList = Arrays.toString(map.get(temp).toArray()).replace("[", "").replace("]", "");
            System.out.println(printList);
        }

        return result;
    }


}
