class Solution {
    public String longestPrefix(String s) {
        int n = s.length();
        int[] lps = new int[n];  // lps[i] will store the length of the longest proper prefix which is also suffix for substring s[0:i+1]

        int len = 0;  // length of the previous longest prefix suffix
        int i = 1;  // start from the second character of the string

        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                // If characters match, extend the current LPS by 1
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len != 0) {
                    // Try the previous longest prefix suffix
                    len = lps[len - 1];
                } else {
                    // No match, move to the next character
                    lps[i] = 0;
                    i++;
                }
            }
        }

        // The length of the longest happy prefix is stored in lps[n-1]
        int happyPrefixLength = lps[n - 1];

        return s.substring(0, happyPrefixLength);
    }
}
