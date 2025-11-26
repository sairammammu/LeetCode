
package Medium_Level;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

class Solution {
    
    
    /**
     * Computes the next smaller element for each element in the array.
     * For each index i, finds the smallest element to the right of arr[i] that is smaller than arr[i].
     * If no such element exists, sets -1.
     * Uses a stack to achieve O(n) time complexity.
     *
     * @param arr the input array of integers
     * @return an ArrayList containing the next smaller element for each index, or -1 if none
     */
    static ArrayList<Integer> nextSmallerEle(int[] arr) {
        // Initialize a stack to keep track of potential smaller elements
        Stack<Integer> st = new Stack<>();
        // Array to store the next smaller element for each index
        Integer nse[] = new Integer[arr.length];
        // Iterate from right to left to process elements in reverse order
        for(int i = arr.length - 1; i >= 0; i--) {
            // Pop elements from stack that are greater than or equal to current element
            // since they cannot be the next smaller element for current or future elements
            while(!st.isEmpty() && st.peek() >= arr[i]) {
                st.pop();
            }
            // If stack is empty, no smaller element to the right
            if(st.isEmpty()) {
                nse[i] = -1;
            }
            // If stack is not empty, the top is the next smaller element
            else if(!st.isEmpty() && st.peek() < arr[i]) {
                nse[i] = st.peek();
            }
            // Push the current element onto the stack for future comparisons
            st.push(arr[i]);
        }
        // Convert the array to ArrayList and return
        return new ArrayList<>(Arrays.asList(nse));
    }
}
