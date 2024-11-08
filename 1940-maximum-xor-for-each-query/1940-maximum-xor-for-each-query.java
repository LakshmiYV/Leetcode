class Solution {
    public int[] getMaximumXor(int[] nums, int maximumBit) {
        int n = nums.length;
        int[] answer = new int[n];
        int currentXor = 0;

        // Calculate the XOR of the entire array
        for (int num : nums) {
            currentXor ^= num;
        }

        // Mask to limit the bits to maximumBit
        int mask = (1 << maximumBit) - 1;

        // Process each query
        for (int i = 0; i < n; i++) {
            // Calculate k for the current query
            answer[i] = currentXor ^ mask;
            
            // Update currentXor by removing the last element in the shrinking nums
            currentXor ^= nums[n - 1 - i];
        }

        return answer;
    }
}
