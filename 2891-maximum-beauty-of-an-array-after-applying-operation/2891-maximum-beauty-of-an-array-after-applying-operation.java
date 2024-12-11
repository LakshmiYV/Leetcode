class Solution {
    public int maximumBeauty(int[] nums, int k) {
        // Sort the array to facilitate range checking
        Arrays.sort(nums);

        int n = nums.length;
        int maxBeauty = 0;
        int left = 0;

        // Use a sliding window approach to maximize the range
        for (int right = 0; right < n; right++) {
            // Ensure the difference between nums[right] and nums[left] is within 2*k
            while (nums[right] - nums[left] > 2 * k) {
                left++;
            }
            // Update the maximum beauty
            maxBeauty = Math.max(maxBeauty, right - left + 1);
        }

        return maxBeauty;
    }
}
