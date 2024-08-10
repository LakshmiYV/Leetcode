import java.util.HashMap;

class Solution {
    public int lengthOfLongestSubstring(String s) {
        // HashMap to store the last seen position of each character
        HashMap<Character, Integer> map = new HashMap<>();
        int maxLength = 0;
        int start = 0;
        
        for (int end = 0; end < s.length(); end++) {
            char currentChar = s.charAt(end);
            
            // If the character is found in the map and it's index is within the current window
            if (map.containsKey(currentChar) && map.get(currentChar) >= start) {
                // Move the start pointer to the right of the last occurrence
                start = map.get(currentChar) + 1;
            }
            
            // Update the current character's position in the map
            map.put(currentChar, end);
            
            // Calculate the length of the current substring
            maxLength = Math.max(maxLength, end - start + 1);
        }
        
        return maxLength;
    }
}
