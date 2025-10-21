package Medium_Level;
import java.util.*;

/**
 * MinStack is a stack data structure that supports push, pop, top, and retrieving the minimum element in constant time.
 * It uses two stacks: one for storing the elements and another for keeping track of the minimum values.
 */
class MinStack {

    // Main stack to store all elements
    Stack<Integer> st = new Stack<>();
    // Auxiliary stack to store the minimum values
    Stack<Integer> min = new Stack<>();

    /**
     * Pushes an element onto the stack.
     * Also updates the min stack to maintain the current minimum.
     * @param val the value to be pushed
     */
    public void push(int val) {
        st.push(val);

        if (min.isEmpty()) {
            min.push(val);
        } else {
            // Push the minimum of the current value and the top of min stack
            min.push(Math.min(val, min.peek()));
        }
    }

    /**
     * Removes the top element from the stack.
     * Also removes the corresponding minimum value from the min stack.
     */
    public void pop() {
        min.pop();
        st.pop();
    }

    /**
     * Returns the top element of the stack without removing it.
     * @return the top element
     */
    public int top() {
        return st.peek();
    }

    /**
     * Retrieves the minimum element in the stack.
     * @return the minimum element
     */
    public int getMin() {
        return min.peek();
    }
}
