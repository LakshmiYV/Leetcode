class Solution {
    public long continuousSubarrays(int[] nums) {
        int start = 0;
        long count = 0;
        int minVal = nums[0], maxVal = nums[0];

        for (int end = 0; end < nums.length; end++) {
            // Update min and max for the current window
            minVal = Math.min(minVal, nums[end]);
            maxVal = Math.max(maxVal, nums[end]);

            // Shrink the window if the condition is violated
            while (maxVal - minVal > 2) {
                start++;
                // Update min and max after shrinking
                minVal = Integer.MAX_VALUE;
                maxVal = Integer.MIN_VALUE;
                for (int i = start; i <= end; i++) {
                    minVal = Math.min(minVal, nums[i]);
                    maxVal = Math.max(maxVal, nums[i]);
                }
            }

            // Count subarrays ending at 'end'
            count += (end - start + 1);
        }

        return count;
    }
}