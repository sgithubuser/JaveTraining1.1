package org.example;

import java.util.HashMap;
import java.util.Map;

public class Training2_HashMap_Task4 {
    public static void main(String[] args) {
        Map<String, Integer> map = new HashMap<>();
        map.put("A", 10);
        map.put("B", 20);
        map.put("C", 30);
        map.put("D", 40);

        System.out.println("Map: " + map);

        int searchValue = 30;

        // Check if the map contains the specified value
        if (map.containsValue(searchValue)) {
            System.out.println("The map contains the value: " + searchValue);
        } else {
            System.out.println("The map does not contain the value: " + searchValue);
        }
    }
}
