package org.example;

import java.util.HashMap;
import java.util.Map;

//Write a Java program to count the number of key-value (size) mappings in a map.
public class Training2_HashMap_Task1 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("R", 3);
        map.put("F", 5);
        map.put("H", 7);
        map.put("A", 1);

        System.out.println("Map: " + map);

        // Count the number of key-value mappings
        int size = map.size();

        System.out.println("Number of key-value pairs in the map: " + size);
    }
}
