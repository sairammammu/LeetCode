package Easy_Level;

/**
 * This class provides functionality to add two binary numbers represented as strings.
 * It simulates binary addition by processing the strings from right to left, handling carry-over.
 */
class AddBinary {
    /**
     * Adds two binary strings and returns their sum as a binary string.
     *
     * @param s1 the first binary string
     * @param s2 the second binary string
     * @return the sum of the two binary strings as a binary string
     */
    public String addBinary(String s1, String s2) {
        StringBuilder str = new StringBuilder(); // To build the result string efficiently

        int first = s1.length() - 1; // Index for the last character of s1
        int second = s2.length() - 1; // Index for the last character of s2
        int carry = 0; // Carry value for binary addition (0 or 1)

        // Loop until both strings are fully processed
        while (first >= 0 || second >= 0) {
            if (first >= 0 && second >= 0) {
                // Both strings have digits at current positions
                int num = (s1.charAt(first) - '0') + (s2.charAt(second) - '0') + carry; // Sum of digits plus carry

                carry = num / 2; // New carry (0 or 1)
                str.append(num % 2); // Append the sum bit (0 or 1)
                first--; // Move to previous digit in s1
                second--; // Move to previous digit in s2

            } else if (second >= 0 && first < 0) {
                // Only s2 has digits left
                int num = (s2.charAt(second) - '0') + carry; // Add digit from s2 and carry

                carry = num / 2; // New carry
                str.append(num % 2); // Append the sum bit
                second--; // Move to previous digit in s2

            } else if (first >= 0 && second < 0) {
                // Only s1 has digits left
                int num = (s1.charAt(first) - '0') + carry; // Add digit from s1 and carry

                carry = num / 2; // New carry
                str.append(num % 2); // Append the sum bit
                first--; // Move to previous digit in s1
            }
        }
        // If there's a remaining carry, append it
        if (carry > 0) {
            str.append(carry);
        }
        // Reverse the StringBuilder to get the correct order (since we built it backwards)
        String res = str.reverse().toString();

        // Remove leading zeros from the result
        int i = 0;
        while (i < res.length() - 1 && res.charAt(i) == '0') {
            i++;
        }
        res = res.substring(i); // Get the substring starting from the first non-zero character

        return res;
    }
}
