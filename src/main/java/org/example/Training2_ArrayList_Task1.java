package org.example;

import java.util.ArrayList;
import java.util.Arrays;
//Write a Java program to remove the third element from an array list.
public class Training2_ArrayList_Task1 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "A", "B", "C", "D", "E"
        ));

        System.out.println("Original List: " + list);

        // Check if the list has at least 3 elements
        if (list.size() > 2) {
            // Remove the third element (index 2)
            list.remove(2);
        } else {
            System.out.println("List does not have enough elements to remove the third one.");
        }

        System.out.println("List after removing third element: " + list);
    }
}