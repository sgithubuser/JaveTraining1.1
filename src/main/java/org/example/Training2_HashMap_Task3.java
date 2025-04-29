package org.example;

import java.util.HashMap;
import java.util.Map;

//Write a Java program to check whether a map contains key-value mappings(empty) or not.
public class Training2_HashMap_Task3 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();

        // Uncomment below lines to add elements and test
//         map.put("Apple", 1);
//         map.put("Banana", 2);


        if (map.isEmpty()) {
            System.out.println("The map is empty.");
        } else {
            System.out.println("The map contains key-value mappings: " + map);
        }
    }
}
