import java.util.Stack;

class Solution {
    public int maxWidthRamp(int[] nums) {
        Stack<Integer> stack = new Stack<>();
        
        // Step 1: Build a decreasing monotonic stack
        for (int i = 0; i < nums.length; i++) {
            // Only add index to the stack if nums[i] is less than the element at the top of the stack
            // (ensuring a strictly decreasing order in the stack)
            if (stack.isEmpty() || nums[stack.peek()] > nums[i]) {
                stack.push(i);
            }
        }
        
        int maxWidth = 0;
        
        // Step 2: Traverse from right to left to find maximum width ramp
        for (int j = nums.length - 1; j >= 0; j--) {
            // As long as the current value nums[j] is greater or equal to the top of the stack
            // calculate width and pop the stack
            while (!stack.isEmpty() && nums[stack.peek()] <= nums[j]) {
                maxWidth = Math.max(maxWidth, j - stack.pop());
            }
        }
        
        return maxWidth;
    }
}
