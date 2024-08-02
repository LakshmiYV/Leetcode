class Solution {
    public int majorityElement(int[] nums) {
        int candidate = nums[0];
        int count = 1;

        // Phase 1: Find the candidate
        for (int i = 1; i < nums.length; i++) {
            if (count == 0) {
                candidate = nums[i];
                count = 1;
            } else if (nums[i] == candidate) {
                count++;
            } else {
                count--;
            }
        }

        // Phase 2 (optional): Validate the candidate (not needed for this problem)
        // int majorityCount = nums.length / 2;
        // int actualCount = 0;
        // for (int num : nums) {
        //     if (num == candidate) {
        //         actualCount++;
        //     }
        // }
        // if (actualCount > majorityCount) {
        //     return candidate;
        // }

        return candidate;
    }
}
