class Solution {
    public int deleteString(String s) {
        int n = s.length();
        int[] dp = new int[n];  // dp[i] = max operations to delete s[i:]
        dp[n - 1] = 1;  // base case: single character can be deleted in one operation
        
        // lcp[i][j] will store the longest common prefix length of s[i:] and s[j:]
        int[][] lcp = new int[n + 1][n + 1];
        
        // Compute longest common prefix (LCP) array
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    lcp[i][j] = 1 + lcp[i + 1][j + 1];
                }
            }
        }
        
        // Iterate from right to left in the string
        for (int i = n - 2; i >= 0; i--) {
            dp[i] = 1;  // At least one operation (deleting the entire substring)
            // Check all possible valid deletions
            for (int len = 1; len <= (n - i) / 2; len++) {
                if (lcp[i][i + len] >= len) {  // If the first len characters are equal
                    dp[i] = Math.max(dp[i], 1 + dp[i + len]);
                }
            }
        }
        
        return dp[0];  // The maximum operations required to delete the entire string
    }
}

