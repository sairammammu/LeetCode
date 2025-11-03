package Easy_Level;

class Solution {
    // Function to compute the maximum nesting depth of parentheses in a string
    public int maxDepth(String s) {
        // maxCounter will hold the maximum depth encountered
        int maxCounter = 0;
        // counter keeps track of the current depth
        int counter = 0;
        // Iterate through each character in the string
        for(int i=0;i<s.length();i++)
        {
            // If the character is an opening parenthesis, increase the depth
            if(s.charAt(i)=='(')
            {
                counter++;
            }
            // If the character is a closing parenthesis, decrease the depth
            else if(s.charAt(i) == ')')
            {
                counter--;
            }
            // Update maxCounter if the current depth is greater than previous maximum
            maxCounter = Math.max(maxCounter , counter);
        }
        // Return the maximum depth found
        return maxCounter;
    }
}