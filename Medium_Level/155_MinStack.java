package Medium_Level;
import java.util.*;

class MinStack {

   Stack<Integer> st = new Stack<>();
   Stack<Integer> min = new Stack<>();
    public void push(int val) {
        st.push(val);

        if(min.isEmpty())
        {
            min.push(val);
        }
        else{
            
             min.push(Math.min(val, min.peek()));
        }
    }
    
    public void pop() {
        min.pop();
        st.pop();
        
    }
    
    public int top() {
     return st.peek();   
    }
    
    public int getMin() {
        return min.peek();
    }
}