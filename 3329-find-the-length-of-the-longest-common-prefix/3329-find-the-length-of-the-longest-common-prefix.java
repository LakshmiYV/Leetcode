import java.util.HashMap;

class Solution {
    public int longestCommonPrefix(int[] arr1, int[] arr2) {
        HashMap<String, Integer> prefixCounter = new HashMap<>();
        
        // Step 1: Build the prefixCounter for arr1
        for (int number : arr1) {
            String numString = Integer.toString(number);
            String currentPrefix = "";
            for (char digit : numString.toCharArray()) {
                currentPrefix += digit;
                prefixCounter.put(currentPrefix, prefixCounter.getOrDefault(currentPrefix, 0) + 1);
            }
        }
        
        int longestPrefixLength = 0;
        
        // Step 2: Check for common prefixes in arr2
        for (int number : arr2) {
            String numString = Integer.toString(number);
            String currentPrefix = "";
            for (char digit : numString.toCharArray()) {
                currentPrefix += digit;
                if (prefixCounter.containsKey(currentPrefix)) {
                    longestPrefixLength = Math.max(longestPrefixLength, currentPrefix.length());
                }
            }
        }
        
        return longestPrefixLength;
    }
}
