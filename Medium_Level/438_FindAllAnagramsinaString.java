import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;

class Solution {
    // This method finds all start indices of p's anagrams in s.
    // The idea is to use a sliding window of length p.length() over the string s
    // and check if the substring matches an anagram of p.
    public List<Integer> findAnagrams(String s, String p) {
        
        // We will count the frequency of each character in p
        // and maintain the frequency of the current window in s as we slide it
        int pCount[] = new int[26]; // frequency array for characters in p
        int sCount[] = new int[26]; // frequency array for current window in s

        List<Integer> list = new ArrayList<>(); // to store start indices of anagrams found

        // Count frequency of characters in p
        for(char ch : p.toCharArray()) {
            pCount[ch - 'a']++;
        }
        
        // Start sliding the window over s
        for(int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            // Add current character to the current window frequency
            sCount[ch - 'a']++;

            // Once our window size exceeds p's length, remove the leftmost character
            if(i >= p.length()) {
                sCount[s.charAt(i - p.length()) - 'a']--;
            }

            // If frequency arrays match, it means current window is an anagram of p
            if(Arrays.equals(pCount, sCount)) {
                // Add the starting index of this anagram substring to the list
                list.add(i - p.length() + 1);
            }
        }

        // Return all start indices of p's anagrams in s
        return list;
    }
}
