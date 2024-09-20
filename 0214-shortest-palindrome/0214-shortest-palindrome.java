class Solution {
    public String shortestPalindrome(String s) {
        if (s == null || s.length() == 0) {
            return s;
        }
        
        String rev = new StringBuilder(s).reverse().toString();
        String combined = s + "#" + rev;
        
        int[] lps = computeLPS(combined);
        
        // lps[lps.length - 1] gives us the length of the longest palindromic prefix in 's'
        int longestPalindromicPrefixLength = lps[lps.length - 1];
        
        // Add the reverse of the remaining suffix in front of the string
        String suffixToAdd = rev.substring(0, rev.length() - longestPalindromicPrefixLength);
        
        return suffixToAdd + s;
    }
    
    // KMP algorithm's LPS (Longest Prefix Suffix) array computation
    private int[] computeLPS(String str) {
        int n = str.length();
        int[] lps = new int[n];
        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;
        
        while (i < n) {
            if (str.charAt(i) == str.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[i] = 0;
                    i++;
                }
            }
        }
        
        return lps;
    }
}
