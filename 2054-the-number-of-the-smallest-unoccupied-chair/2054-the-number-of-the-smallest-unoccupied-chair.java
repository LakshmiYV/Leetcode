import java.util.*;

class Solution {
    public int smallestChair(int[][] times, int targetFriend) {
        int n = times.length;
        
        // Create an array to store {arrival time, friend index} for sorting
        int[][] events = new int[n][2];
        for (int i = 0; i < n; i++) {
            events[i][0] = times[i][0];  // Arrival time
            events[i][1] = i;            // Friend index
        }
        
        // Sort the events by arrival time
        Arrays.sort(events, (a, b) -> Integer.compare(a[0], b[0]));
        
        // Min-heap to track available chairs
        PriorityQueue<Integer> availableChairs = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            availableChairs.add(i);  // Initially all chairs from 0 to n-1 are available
        }
        
        // Min-heap to track leaving times {leaving time, chair number}
        PriorityQueue<int[]> leavingTimes = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        
        // Iterate over the sorted events (friends' arrivals)
        for (int[] event : events) {
            int arrivalTime = event[0];
            int friend = event[1];
            
            // Free up chairs for any friends who have already left before the current arrival time
            while (!leavingTimes.isEmpty() && leavingTimes.peek()[0] <= arrivalTime) {
                int[] leftEvent = leavingTimes.poll();
                availableChairs.add(leftEvent[1]);  // Chair becomes available
            }
            
            // Assign the smallest available chair
            int chair = availableChairs.poll();
            
            // If this is the target friend, return the chair number
            if (friend == targetFriend) {
                return chair;
            }
            
            // Add the leaving event for this friend to the leavingTimes heap
            leavingTimes.add(new int[] {times[friend][1], chair});
        }
        
        return -1;  // This line should never be reached
    }
}
