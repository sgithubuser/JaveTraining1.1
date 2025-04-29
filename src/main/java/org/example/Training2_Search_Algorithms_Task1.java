package org.example;
//
//Given a 1-indexed array of integers numbers that is already sorted in non-decreasing
//order, find two numbers such that they add up to a specific target number. Let these two
//numbers be numbers[index1] and numbers[index2] where 1 <= index1 < index2 <=
//numbers.length. Return the indices of the two numbers, index1 and index2, added by one
//as an integer array [index1, index2] of length 2.
//Input: arr[] = {2, 7, 11, 15}, target = 9
//Output: 1 2
//Explanation: Since the array is 1-indexed, arr[1] + arr[2] = 2 + 7 = 9
//Input: {1, 3, 4, 6, 8, 11} target = 10
//Output: 3 4
//Explanation: Since the array is 1-indexed, arr[3] + arr[5] = 4 + 6 = 10

public class Training2_Search_Algorithms_Task1 {
    public static void main(String[] args) {
        int[] numbers = {2, 7, 11, 15}; // 1-indexed array
        int target = 26;

        int[] result = sumIndexes(numbers, target);

        System.out.println(result[0] + " " + result[1]); // Output the indices
    }

    public static int[] sumIndexes(int[] numbers, int target) {
        int left = 0; // start pointer (0-indexed)
        int right = numbers.length - 1; // end pointer (0-indexed)

        while (left < right) {
            int sum = numbers[left] + numbers[right];

            if (sum == target) {
                // Return 1-indexed results, so add 1 to both indices
                return new int[]{left + 1, right + 1};
            } else if (sum < target) {
                left++; // move left pointer to the right to increase sum
            } else {
                right--; // move right pointer to the left to decrease sum
            }
        }

        // Return an empty array if no solution is found (though it’s assumed there's a solution)
        return new int[]{};
    }
}
