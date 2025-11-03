package Easy_Level;

/**
 * This class contains solutions to LeetCode problems, specifically for finding the first unique character in a string.
 */
class Solution {
    /**
     * Finds the index of the first character in the string that appears only once.
     * If no such character exists, returns -1.
     *
     * @param s the input string consisting of lowercase English letters
     * @return the index of the first unique character, or -1 if none exists
     */
    public int firstUniqChar(String s) {
        int charCount[] = new int[26]; // Array to count frequency of each lowercase letter (a-z)

        // First pass: Count the frequency of each character in the string
        for (int i = 0; i < s.length(); i++) {
            charCount[s.charAt(i) - 'a']++; // Increment count for the character
        }

        // Second pass: Find the first character with count 1
        for (int i = 0; i < s.length(); i++) {
            if (charCount[s.charAt(i) - 'a'] == 1) { // Check if this character appears only once
                return i; // Return the index of the first unique character
            }
        }
        return -1; // No unique character found
    }
}

