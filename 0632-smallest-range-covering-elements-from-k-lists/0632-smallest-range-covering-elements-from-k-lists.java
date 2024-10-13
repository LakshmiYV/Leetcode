import java.util.*;

class Solution {
    public int[] smallestRange(List<List<Integer>> nums) {
        // Min-heap to store (value, row index, column index)
        PriorityQueue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int max = Integer.MIN_VALUE;  // Track the maximum value in the current window
        
        // Initialize the heap with the first element of each list and find the initial max
        for (int i = 0; i < nums.size(); i++) {
            int value = nums.get(i).get(0);
            minHeap.offer(new int[]{value, i, 0});
            max = Math.max(max, value);
        }
        
        // Store the result range [a, b]
        int start = -100000, end = 100000;
        
        // While we have enough elements to form a valid range
        while (minHeap.size() == nums.size()) {
            int[] curr = minHeap.poll();  // Get the smallest element
            int min = curr[0];
            int row = curr[1];
            int col = curr[2];
            
            // Check if the current range is smaller than the previous one
            if (max - min < end - start) {
                start = min;
                end = max;
            }
            
            // Move to the next element in the same list (if available)
            if (col + 1 < nums.get(row).size()) {
                int nextValue = nums.get(row).get(col + 1);
                minHeap.offer(new int[]{nextValue, row, col + 1});
                max = Math.max(max, nextValue);  // Update the max value
            }
        }
        
        return new int[]{start, end};
    }
}
