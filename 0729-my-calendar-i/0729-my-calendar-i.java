import java.util.ArrayList;
import java.util.List;

class MyCalendar {
    private List<int[]> bookings;

    public MyCalendar() {
        bookings = new ArrayList<>();
    }
    
    public boolean book(int start, int end) {
        // Iterate over the existing bookings to check for overlaps
        for (int[] booking : bookings) {
            // If there is an overlap, return false
            if (start < booking[1] && end > booking[0]) {
                return false;
            }
        }
        // If no overlap, add the new booking
        bookings.add(new int[]{start, end});
        return true;
    }
}

/**
 * Your MyCalendar object will be instantiated and called as such:
 * MyCalendar obj = new MyCalendar();
 * boolean param_1 = obj.book(start,end);
 */
