package org.example;

import java.util.Arrays;


public class BinarySearchTest {

    // Iterative approach for binary search
    public static int binarySearchIterative(int[] arr, int target) {
        int left = 0;
        int right = arr.length - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid; // Target found
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                // If target is smaller, ignore right half
                right = mid - 1;
            }
        }
        return -1; // Target not found
    }

    // Recursive approach for binary search
    public static int binarySearchRecursive(int[] arr, int left, int right, int target) {
        if (right >= left) {
            int mid = left + (right - left) / 2;

            // Check if the target is present at mid
            if (arr[mid] == target) {
                return mid; // Target found
            }

            // If target is greater, ignore left half
            if (arr[mid] < target) {
                return binarySearchRecursive(arr, mid + 1, right, target);
            } else {
                // If target is smaller, ignore right half
                return binarySearchRecursive(arr, left, mid - 1, target);
            }
        }
        return -1; // Target not found
    }

    public static void main(String[] args) {
        int[] arr = {2, 3, 4, 10, 40}; // Sorted array
        int target = 4;

        // Using iterative binary search
        int resultIterative = binarySearchIterative(arr, target);
        if (resultIterative != -1) {
            System.out.println("Iterative: Element found at index " + resultIterative);
        } else {
            System.out.println("Iterative: Element not found");
        }

        // Using recursive binary search
        int resultRecursive = binarySearchRecursive(arr, 0, arr.length - 1, target);
        if (resultRecursive != -1) {
            System.out.println("Recursive: Element found at index " + resultRecursive);
        } else {
            System.out.println("Recursive: Element not found");
        }
    }
}
