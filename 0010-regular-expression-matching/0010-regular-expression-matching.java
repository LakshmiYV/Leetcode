class Solution {  
    public boolean isMatch(String s, String p) {  
        // Initialize the DP table  
        boolean[][] dp = new boolean[s.length() + 1][p.length() + 1];  
        
        // Base case: empty string and empty pattern match  
        dp[0][0] = true;  

        // Handle patterns like a*, a*b*, etc. that can match an empty string  
        for (int j = 1; j <= p.length(); j++) {  
            if (p.charAt(j - 1) == '*') {  
                dp[0][j] = dp[0][j - 2];  
            }  
        }  

        // Fill the DP table  
        for (int i = 1; i <= s.length(); i++) {  
            for (int j = 1; j <= p.length(); j++) {  
                // Check for direct match or '.'  
                if (p.charAt(j - 1) == s.charAt(i - 1) || p.charAt(j - 1) == '.') {  
                    dp[i][j] = dp[i - 1][j - 1];  
                }  
                // Check for '*'  
                else if (p.charAt(j - 1) == '*') {  
                    dp[i][j] = dp[i][j - 2]; // Zero occurrences of the preceding element  
                    if (p.charAt(j - 2) == s.charAt(i - 1) || p.charAt(j - 2) == '.') {  
                        dp[i][j] = dp[i][j] || dp[i - 1][j]; // One or more occurrences of the preceding element  
                    }  
                }  
            }  
        }  

        return dp[s.length()][p.length()];  
    }  
}