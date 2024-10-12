import java.util.*;

class Solution {
    public int minGroups(int[][] intervals) {
        List<int[]> events = new ArrayList<>();
        
        // Create events for each interval
        for (int[] interval : intervals) {
            events.add(new int[]{interval[0], 1});  // Start of an interval
            events.add(new int[]{interval[1] + 1, -1});  // End of an interval (with +1)
        }
        
        // Sort events: first by time, then by type (start comes before end)
        Collections.sort(events, (a, b) -> (a[0] == b[0]) ? a[1] - b[1] : a[0] - b[0]);
        
        int activeIntervals = 0;
        int maxGroups = 0;
        
        // Process all events
        for (int[] event : events) {
            activeIntervals += event[1];  // Add 1 for a start, subtract 1 for an end
            maxGroups = Math.max(maxGroups, activeIntervals);
        }
        
        return maxGroups;
    }
}
