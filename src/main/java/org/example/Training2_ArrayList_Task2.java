package org.example;
import java.util.ArrayList;
import java.util.Arrays;
// Write a Java program to search for an element in an array list
public class Training2_ArrayList_Task2 {
    public static void main(String[] args) {
        ArrayList<String> list = new ArrayList<>(Arrays.asList(
                "A", "B", "C", "D", "E"
        ));

        System.out.println("List: " + list);

        String searchElement = "E";

        // Search using contains()
        if (list.contains(searchElement)) {
            System.out.println(searchElement + " is found in the list.");
        } else {
            System.out.println(searchElement + " is not found in the list.");
        }
    }
}
