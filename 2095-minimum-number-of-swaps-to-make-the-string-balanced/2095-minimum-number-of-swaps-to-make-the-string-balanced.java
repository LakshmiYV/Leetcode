class Solution {
    public int minSwaps(String s) {
        int imbalance = 0;  // This tracks the current imbalance
        int swaps = 0;      // Number of swaps needed

        // Traverse the string
        for (char c : s.toCharArray()) {
            if (c == '[') {
                // Opening bracket reduces the imbalance
                imbalance++;
            } else {
                // Closing bracket increases the imbalance
                imbalance--;
            }

            // If imbalance goes negative, we need a swap
            if (imbalance < 0) {
                // We need a swap to fix this imbalance
                swaps++;
                // Fix the current imbalance
                imbalance = 1;  // After the swap, we will have one extra opening bracket
            }
        }

        return swaps;
    }
}
