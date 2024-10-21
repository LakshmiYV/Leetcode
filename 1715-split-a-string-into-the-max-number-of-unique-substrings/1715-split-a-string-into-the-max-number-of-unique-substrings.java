import java.util.HashSet;

class Solution {
    public int maxUniqueSplit(String s) {
        return backtrack(s, 0, new HashSet<>());
    }

    private int backtrack(String s, int start, HashSet<String> uniqueSubstrings) {
        // If we reach the end of the string, return the count of unique substrings
        if (start == s.length()) {
            return uniqueSubstrings.size();
        }

        int maxCount = 0;

        // Try every possible substring starting from the current index
        for (int end = start + 1; end <= s.length(); end++) {
            String substring = s.substring(start, end);
            
            // Only proceed if the substring is unique
            if (uniqueSubstrings.add(substring)) {
                // Recursively call for the remaining substring
                maxCount = Math.max(maxCount, backtrack(s, end, uniqueSubstrings));
                // Backtrack: remove the substring from the set
                uniqueSubstrings.remove(substring);
            }
        }

        return maxCount;
    }
}
