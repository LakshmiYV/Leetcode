import java.util.PriorityQueue;

class Solution {
    public long maxKelements(int[] nums, int k) {
        // Create a max heap using a priority queue (invert values for max behavior)
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>((a, b) -> b - a);
        
        // Add all elements to the max heap
        for (int num : nums) {
            maxHeap.add(num);
        }
        
        long score = 0; // Initialize the score to 0
        
        // Perform k operations
        for (int i = 0; i < k; i++) {
            // Get the maximum element
            int maxValue = maxHeap.poll();
            score += maxValue; // Increase score by maxValue
            
            // Calculate the new value and push it back into the heap
            int newValue = (maxValue + 2) / 3; // Using (maxValue + 2) / 3 to achieve ceil(maxValue / 3)
            maxHeap.add(newValue);
        }
        
        return score; // Return the final score
    }
}
