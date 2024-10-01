class Solution {
    public boolean canArrange(int[] arr, int k) {
        int[] remainderCount = new int[k];  // Array to count remainders
        
        // Count the frequency of each remainder
        for (int num : arr) {
            int remainder = ((num % k) + k) % k;  // Handle negative numbers
            remainderCount[remainder]++;
        }
        
        // Check pairing conditions for each remainder
        for (int i = 1; i <= k / 2; i++) {
            if (remainderCount[i] != remainderCount[k - i]) {
                return false;
            }
        }
        
        // Special case for remainder 0, it should be even
        return remainderCount[0] % 2 == 0;
    }
}
