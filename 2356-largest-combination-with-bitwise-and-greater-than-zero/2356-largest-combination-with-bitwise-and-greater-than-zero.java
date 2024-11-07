class Solution {
    public int largestCombination(int[] candidates) {
        int[] bitCount = new int[24]; // Array to count set bits at each position

        // Count set bits at each bit position for each number in candidates
        for (int num : candidates) {
            for (int i = 0; i < 24; i++) {
                if ((num & (1 << i)) != 0) { // Check if the ith bit is set
                    bitCount[i]++;
                }
            }
        }

        // Find the maximum count in bitCount array
        int maxCombinationSize = 0;
        for (int count : bitCount) {
            maxCombinationSize = Math.max(maxCombinationSize, count);
        }

        return maxCombinationSize;
    }
}
