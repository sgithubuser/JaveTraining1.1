package org.example;

import java.util.ArrayList;
import java.util.Arrays;

// Write a Java program to join two array lists.
public class Training2_ArrayList_Task3 {
    public static void main(String[] args) {
        ArrayList<String> list1 = new ArrayList<>(Arrays.asList("A", "B", "C"));
        ArrayList<String> list2 = new ArrayList<>(Arrays.asList("D", "E", "F"));

        System.out.println("List 1: " + list1);
        System.out.println("List 2: " + list2);

        // Join the two lists
        ArrayList<String> joinedList = new ArrayList<>(list1);
        joinedList.addAll(list2);

        System.out.println("Joined List: " + joinedList);
    }
}
