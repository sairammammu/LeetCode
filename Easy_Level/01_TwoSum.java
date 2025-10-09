package Easy_Level;

import java.util.HashMap;
import java.util.Map;

// Solution class for LeetCode Two Sum problem
class Solution
 {
    /**
     * Given an array of integers nums and an integer target, return indices of the two numbers such that they add up to target.
     * You may assume that each input would have exactly one solution, and you may not use the same element twice.
     * You can return the answer in any order.
     * Approach: Use a HashMap to store numbers and their indices. For each number, check if its complement (target - num) exists in the map.
     */
    public int[] twoSum(int[] nums, int target)
    {
        Map<Integer , Integer> map = new HashMap<>(); // Initialize a HashMap to store number and its index
        for(int i=0;i<nums.length;i++) // Iterate through the array
        {
            int complement = target - nums[i]; // Calculate the complement needed to reach the target
            if(map.containsKey(complement)) // If complement exists in map, return the indices
            {
                return new int[] {map.get(complement),i}; // Return the indices of the two numbers
            }

            map.put(nums[i],i); // Put the current number and its index into the map
        }
        return new int[] {}; // If no solution found, return empty array (though problem assumes one solution)
    }

    public static void main(String args[])
    {
        // Main method for testing purposes
    }
}
