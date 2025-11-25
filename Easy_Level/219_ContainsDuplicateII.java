package Easy_Level;

import java.util.HashMap;

class Solution {
    /**
     * Checks if the array contains any duplicates within k distance of each other.
     *
     * @param nums The input array of integers.
     * @param k The maximum allowed index distance between duplicate elements.
     * @return True if any duplicates exist within k indices apart, otherwise false.
     */
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        
        // Map to store the last seen index of each number
        HashMap<Integer, Integer> map = new HashMap<>();

        // Iterate over elements in the array
        for (int i = 0; i < nums.length; i++) {
            // Check if current number was seen before
            if (map.containsKey(nums[i])) {
                int j = map.get(nums[i]); // Last index where this number was seen
                
                // If the distance between current and last seen index is within k,
                // that means a nearby duplicate exists, so return true.
                if (Math.abs(i - j) <= k) {
                    return true;
                }
            }
            // Update the last seen index for the current number
            map.put(nums[i], i);
        }

        // No nearby duplicates found
        return false;
    }
}



/*

  for(int i=0;i<nums.length;i++)
        {
            for(int j=i+1;j<nums.length;j++)
            {
                if(nums[i]==nums[j])
                {
                    if(Math.abs(i-j)<=k)
                    {
                        return true;
                    }
                }
            }
        }

        return false;


        */