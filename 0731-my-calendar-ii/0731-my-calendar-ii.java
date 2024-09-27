import java.util.*;

class MyCalendarTwo {
    // List to store intervals with double bookings
    List<int[]> overlaps;
    // List to store all booked intervals
    List<int[]> bookings;

    public MyCalendarTwo() {
        overlaps = new ArrayList<>();
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Check if this new booking causes a triple booking
        for (int[] overlap : overlaps) {
            if (start < overlap[1] && end > overlap[0]) {
                // If there is any overlap with a double-booked time, it's a triple booking
                return false;
            }
        }
        
        // Update the overlaps based on new booking
        for (int[] booking : bookings) {
            if (start < booking[1] && end > booking[0]) {
                // Add the overlap interval to the overlaps list
                int overlapStart = Math.max(start, booking[0]);
                int overlapEnd = Math.min(end, booking[1]);
                overlaps.add(new int[]{overlapStart, overlapEnd});
            }
        }
        
        // If no triple booking, add the booking to the bookings list
        bookings.add(new int[]{start, end});
        return true;
    }
}

