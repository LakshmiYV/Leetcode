class Solution {
    public int removeDuplicates(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }

        int slow = 0; // Pointer for the position to place the next valid element
        int count = 1; // Counter to count occurrences of the current element

        for (int fast = 1; fast < nums.length; fast++) {
            if (nums[fast] == nums[fast - 1]) {
                // If the current element is the same as the previous one
                count++;
            } else {
                // If it's a different element, reset the count
                count = 1;
            }

            // Only add the element if the count is less than or equal to 2
            if (count <= 2) {
                slow++;
                nums[slow] = nums[fast];
            }
        }

        // The length of the modified array with valid elements
        return slow + 1;
    }
}
