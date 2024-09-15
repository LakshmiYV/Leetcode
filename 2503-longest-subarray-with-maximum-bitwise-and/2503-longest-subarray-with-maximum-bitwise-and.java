class Solution {  
    public int longestSubarray(int[] nums) {  
        int maxVal = Integer.MIN_VALUE;  
        
        // Step 1: Find the maximum value in the array  
        for (int num : nums) {  
            if (num > maxVal) {  
                maxVal = num;  
            }  
        }  
        
        // Step 2: Find the longest subarray with all elements equal to maxVal  
        int longest = 0;  
        int currentLength = 0;  

        for (int num : nums) {  
            if (num == maxVal) {  
                currentLength++;  
            } else {  
                longest = Math.max(longest, currentLength);  
                currentLength = 0; // Reset the count  
            }  
        }  
        
        // Final comparison in case the longest subarray ends at the last element  
        longest = Math.max(longest, currentLength);  
        
        return longest;  
    }  
}