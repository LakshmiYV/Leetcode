class Solution {     
    public void sortColors(int[] nums) {         
        // Initialize three pointers:
        int low = 0;        // Points to the next position of '0'
        int mid = 0;        // Current element being considered
        int high = nums.length - 1;  // Points to the next position of '2'
        
        // Iterate while mid pointer is less than or equal to high pointer
        while (mid <= high) {
            
            // Case 1: If the current element is 0
            if (nums[mid] == 0) {
                // Swap the element at mid with the element at low
                int temp = nums[low];
                nums[low] = nums[mid];
                nums[mid] = temp;
                
                // Move both low and mid pointers to the right
                low++;
                mid++;
            }
            // Case 2: If the current element is 1
            else if (nums[mid] == 1) {
                // Simply move the mid pointer to the right
                mid++;
            }
            // Case 3: If the current element is 2
            else {
                // Swap the element at mid with the element at high
                int temp = nums[mid];
                nums[mid] = nums[high];
                nums[high] = temp;
                
                // Move the high pointer to the left
                high--;
                // Notice: mid is not incremented here because the new element at mid needs to be checked again
            }
        }
    }
}