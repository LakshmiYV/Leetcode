import java.util.Arrays;
import java.util.LinkedList;

class Solution {
    public int[][] merge(int[][] intervals) {
        // If there are no intervals, return an empty array
        if (intervals.length == 0) {
            return new int[0][];
        }
        
        // Sort intervals by start time
        Arrays.sort(intervals, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Use a LinkedList to store the merged intervals
        LinkedList<int[]> merged = new LinkedList<>();
        
        for (int[] interval : intervals) {
            // If merged is empty or there is no overlap with the last interval, add the new interval
            if (merged.isEmpty() || merged.getLast()[1] < interval[0]) {
                merged.add(interval);
            } else {
                // There is an overlap, merge the intervals
                merged.getLast()[1] = Math.max(merged.getLast()[1], interval[1]);
            }
        }
        
        return merged.toArray(new int[merged.size()][]);
    }
}
