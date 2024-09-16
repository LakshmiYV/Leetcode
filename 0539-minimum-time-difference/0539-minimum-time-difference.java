import java.util.*;  

class Solution {  
    public int findMinDifference(List<String> timePoints) {  
        // Step 1: Convert time points to minutes  
        List<Integer> minutes = new ArrayList<>();  
        for (String time : timePoints) {  
            String[] parts = time.split(":");  
            int HH = Integer.parseInt(parts[0]);  
            int MM = Integer.parseInt(parts[1]);  
            minutes.add(HH * 60 + MM);  
        }  

        // Step 2: Sort the list of minutes  
        Collections.sort(minutes);  

        // Step 3: Find the minimum difference  
        int minDiff = Integer.MAX_VALUE;  

        for (int i = 1; i < minutes.size(); i++) {  
            int diff = minutes.get(i) - minutes.get(i - 1);  
            minDiff = Math.min(minDiff, diff);  
        }  

        // Step 4: Check the wrap-around difference  
        int wrapAroundDiff = (1440 - minutes.get(minutes.size() - 1) + minutes.get(0));  
        minDiff = Math.min(minDiff, wrapAroundDiff);  

        return minDiff;  
    }  
}