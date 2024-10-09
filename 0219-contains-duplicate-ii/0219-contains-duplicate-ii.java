import java.util.HashMap;

class Solution {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        // Create a HashMap to store the number and its most recent index
        HashMap<Integer, Integer> map = new HashMap<>();
        
        // Iterate through the array
        for (int i = 0; i < nums.length; i++) {
            // If the number is already in the map
            if (map.containsKey(nums[i])) {
                // Check if the difference between indices is <= k
                if (i - map.get(nums[i]) <= k) {
                    return true;
                }
            }
            // Update the index of the number in the map
            map.put(nums[i], i);
        }
        
        // If no such pair was found, return false
        return false;
    }
}
