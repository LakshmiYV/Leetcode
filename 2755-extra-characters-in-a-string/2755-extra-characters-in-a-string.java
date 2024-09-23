import java.util.*;

class Solution {
    public int minExtraChar(String s, String[] dictionary) {
        int n = s.length();
        Set<String> dictSet = new HashSet<>(Arrays.asList(dictionary));
        
        // DP array to store the minimum number of extra characters at each index
        int[] dp = new int[n + 1];
        
        // Initialize dp[0] as 0 since there are no characters to be processed initially
        Arrays.fill(dp, Integer.MAX_VALUE);
        dp[0] = 0;
        
        // Dynamic Programming approach to calculate minimum extra characters
        for (int i = 0; i < n; i++) {
            if (dp[i] == Integer.MAX_VALUE) continue; // skip unreachable positions
            
            // Assume current character is an extra character
            dp[i + 1] = Math.min(dp[i + 1], dp[i] + 1);
            
            // Try all substrings starting from index i
            for (int j = i + 1; j <= n; j++) {
                String sub = s.substring(i, j);
                if (dictSet.contains(sub)) {
                    dp[j] = Math.min(dp[j], dp[i]);
                }
            }
        }
        
        // The answer will be stored at dp[n], which is the minimum extra characters for the whole string
        return dp[n];
    }
}
