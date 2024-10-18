class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0;
        int n = nums.length;
        
        // Step 1: Find the maximum possible OR for the array
        for (int num : nums) {
            maxOr |= num;
        }
        
        int count = 0;

        // Step 2: Iterate over all subsets using bit manipulation
        int totalSubsets = 1 << n;  // 2^n subsets
        for (int subset = 1; subset < totalSubsets; subset++) {
            int currentOr = 0;

            // Step 3: Calculate OR for the current subset
            for (int i = 0; i < n; i++) {
                if ((subset & (1 << i)) != 0) {
                    currentOr |= nums[i];
                }
            }

            // Step 4: Count the subset if its OR equals the maximum OR
            if (currentOr == maxOr) {
                count++;
            }
        }
        
        return count;
    }
}
