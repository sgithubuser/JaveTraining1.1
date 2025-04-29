package org.example;

import java.util.HashMap;
import java.util.Map;

//Write a Java program to remove all mappings from a map.
public class Training2_HashMap_Task2 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("Brake", 1);
        map.put("Wheel", 2);
        map.put("Seat", 3);

        System.out.println("Original Map: " + map);

        // Remove all mappings from the map
        map.clear();

        System.out.println("Map after clearing: " + map);
    }
}
