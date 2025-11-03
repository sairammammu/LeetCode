package Easy_Level;
import java.util.HashMap;
import java.util.Stack;

/**
 * This class solves the "Next Greater Element I" problem.
 * For each element in nums1, find the next greater element in nums2.
 * If no greater element exists, return -1.
 */
public class NextGreaterElement_464 {


    /**
     * Finds the next greater element for each element in nums1 from nums2.
     * @param nums1 The array of elements to find next greater for.
     * @param nums2 The array to search for greater elements.
     * @return An array where each index corresponds to the next greater element in nums2 for nums1[i], or -1 if none.
     */
    public int[] nextGreaterElement(int[] nums1, int[] nums2) {
        Stack<Integer> st = new Stack<>();
        HashMap<Integer,Integer> hmap = new HashMap<>();
        // Traverse nums2 from right to left to build the next greater element map
        for(int i=nums2.length-1;i>=0;i--)
        {
            // Pop elements from stack that are less than or equal to current element
            while(!st.isEmpty() && st.peek() <= nums2[i])
            {
                st.pop();
            }
            // If stack is empty, no greater element
            if(st.isEmpty())
            {
                hmap.put(nums2[i] , -1);
            }
            // Else, top of stack is the next greater
            else if(st.peek() > nums2[i])
            {
                hmap.put(nums2[i] , st.peek());
            }
            // Push current element onto stack
            st.push(nums2[i]);

        }

        // Build result array using the map
        int res[] = new int[nums1.length];
        for(int i=0;i<nums1.length;i++)
        {
            res[i] = hmap.get(nums1[i]);
        }
        return res;

    }


}
