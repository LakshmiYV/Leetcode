import java.util.HashMap;

class Solution {
    public String minWindow(String s, String t) {
        if (s.length() == 0 || t.length() == 0) {
            return "";
        }
        
        // Frequency map for characters in t
        HashMap<Character, Integer> tFreq = new HashMap<>();
        for (char c : t.toCharArray()) {
            tFreq.put(c, tFreq.getOrDefault(c, 0) + 1);
        }
        
        // Variables to track the window
        int left = 0, right = 0;
        int required = tFreq.size();  // Number of unique characters in t
        int formed = 0;  // Number of unique characters in the current window that match t
        
        HashMap<Character, Integer> windowCounts = new HashMap<>();
        int[] ans = {-1, 0, 0};  // length of window, left, right

        while (right < s.length()) {
            // Add one character from the right to the window
            char c = s.charAt(right);
            windowCounts.put(c, windowCounts.getOrDefault(c, 0) + 1);
            
            // Check if the current character matches the required frequency in t
            if (tFreq.containsKey(c) && windowCounts.get(c).intValue() == tFreq.get(c).intValue()) {
                formed++;
            }
            
            // Try to contract the window till it ceases to be 'desirable'
            while (left <= right && formed == required) {
                c = s.charAt(left);
                
                // Save the smallest window
                if (ans[0] == -1 || right - left + 1 < ans[0]) {
                    ans[0] = right - left + 1;
                    ans[1] = left;
                    ans[2] = right;
                }
                
                // Remove the leftmost character
                windowCounts.put(c, windowCounts.get(c) - 1);
                if (tFreq.containsKey(c) && windowCounts.get(c).intValue() < tFreq.get(c).intValue()) {
                    formed--;
                }
                
                left++;
            }
            
            // Expand the window by moving right
            right++;   
        }
        
        return ans[0] == -1 ? "" : s.substring(ans[1], ans[2] + 1);
    }
}
