class Solution {
    public int jump(int[] nums) {
        int n = nums.length;
        if (n == 1) return 0; // No jumps needed if there's only one element
        
        int jumps = 0;        // Number of jumps made
        int currentEnd = 0;   // End of the current jump range
        int farthest = 0;     // Farthest index that can be reached
        
        for (int i = 0; i < n - 1; i++) {
            // Update the farthest point reachable from index i
            farthest = Math.max(farthest, i + nums[i]);
            
            // If we reach the end of the current jump range
            if (i == currentEnd) {
                jumps++;              // Make a jump
                currentEnd = farthest; // Update the end of the current jump range
                
                // If we can reach the end of the array, break out of the loop
                if (currentEnd >= n - 1) {
                    break;
                }
            }
        }
        
        return jumps;
    }
}
