class Solution {
    public int findKthNumber(int n, int k) {
        int curr = 1;  // Start with 1
        k--;  // We want to find the k-th, but since we're using 0-indexing, decrement k

        while (k > 0) {
            long steps = countSteps(n, curr, curr + 1);  // Count the steps between curr and curr + 1
            if (steps <= k) {
                // If the number of steps is less than or equal to k, we can skip this prefix
                curr++;  // Move to the next prefix
                k -= steps;  // Subtract the steps from k
            } else {
                // If steps are more than k, we need to go deeper in the current prefix
                curr *= 10;  // Move to the next level (curr * 10)
                k--;  // Decrement k since we're moving one step down
            }
        }
        return curr;
    }
    
    // Count how many numbers are between the prefix `curr` and `next` in lexicographical order
    private long countSteps(int n, long curr, long next) {
        long steps = 0;
        while (curr <= n) {
            steps += Math.min(n + 1, next) - curr;  // Add the range between curr and next
            curr *= 10;
            next *= 10;
        }
        return steps;
    }
}
