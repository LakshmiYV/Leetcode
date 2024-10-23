import java.util.Arrays;

class Solution {
    public int findMinArrowShots(int[][] points) {
        if (points.length == 0) {
            return 0;
        }
        
        // Sort the balloons by their end points (xend)
        Arrays.sort(points, (a, b) -> Integer.compare(a[1], b[1]));
        
        int arrows = 1;  // At least one arrow is needed
        int end = points[0][1];  // The position of the first arrow at the end of the first balloon
        
        // Go through the sorted balloons
        for (int i = 1; i < points.length; i++) {
            // If the start of the current balloon is beyond the current arrow's range
            if (points[i][0] > end) {
                arrows++;  // We need a new arrow
                end = points[i][1];  // Update the end to the current balloon's end
            }
        }
        
        return arrows;
    }
}
