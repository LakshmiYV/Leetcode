import java.util.Arrays;

class Solution {
    public int minimumMountainRemovals(int[] nums) {
        int n = nums.length;
        
        // Arrays to store the longest increasing subsequence up to each element
        int[] lis = new int[n];
        Arrays.fill(lis, 1);
        
        // Calculate LIS for each element
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < i; j++) {
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }
        
        // Arrays to store the longest decreasing subsequence starting from each element
        int[] lds = new int[n];
        Arrays.fill(lds, 1);
        
        // Calculate LDS for each element
        for (int i = n - 1; i >= 0; i--) {
            for (int j = n - 1; j > i; j--) {
                if (nums[i] > nums[j]) {
                    lds[i] = Math.max(lds[i], lds[j] + 1);
                }
            }
        }
        
        // Find the maximum length of any mountain array
        int max_mountain_length = 0;
        for (int i = 1; i < n - 1; i++) { // i cannot be the first or last element
            if (lis[i] > 1 && lds[i] > 1) { // Valid peak
                max_mountain_length = Math.max(max_mountain_length, lis[i] + lds[i] - 1);
            }
        }
        
        // Minimum removals to make a mountain array
        return n - max_mountain_length;
    }
}
