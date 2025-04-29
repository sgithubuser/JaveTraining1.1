package org.example;
//Given an array nums with n objects colored red, white, or blue, sort them in-place so
//that obects of the same color are adjacent, with the colors in the order red, white, and
//blue.
//We will use the integers 0, 1, and 2 to represent the color red, white, and blue,
//respectively.
//You must solve this problem without using the library's sort function.
//Example 1:
//Input: nums = [2,0,2,1,1,0]
//Output: Output: [0,0,1,1,2,2]
public class Training2_Sorting_Task1 {
    public static void main(String[] args) {
        int[] nums = {2, 0, 2, 1, 1, 0};

        bubbleSort(nums);

        System.out.println("sorted colors: " + java.util.Arrays.toString(nums));
    }
    //through bubble i doing
    public static void bubbleSort(int[] nums) {
        int n = nums.length;

        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - 1 - i; j++) {
                if (nums[j] > nums[j + 1]) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
            }
        }
    }
}
