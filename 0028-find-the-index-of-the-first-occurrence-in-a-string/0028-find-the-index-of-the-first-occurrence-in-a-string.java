class Solution {
    public int strStr(String haystack, String needle) {
        // Edge case: if needle is empty
        if (needle.isEmpty()) {
            return 0;
        }

        int haystackLength = haystack.length();
        int needleLength = needle.length();

        // Loop through haystack until the remaining substring is shorter than needle
        for (int i = 0; i <= haystackLength - needleLength; i++) {
            // Check if the substring from i matches the needle
            if (haystack.substring(i, i + needleLength).equals(needle)) {
                return i; // Return the first occurrence index
            }
        }

        return -1; // If no match found
    }
}
