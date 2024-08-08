class Solution {  
    public int canCompleteCircuit(int[] gas, int[] cost) {  
        int totalTank = 0; // Total gas surplus  
        int currentTank = 0; // Current tank while trying from a starting point  
        int startingStation = 0; // Starting index  

        for (int i = 0; i < gas.length; i++) {  
            totalTank += gas[i] - cost[i];  
            currentTank += gas[i] - cost[i];  

            // If current tank is negative, reset starting station to next index  
            if (currentTank < 0) {  
                startingStation = i + 1; // Move to the next station  
                currentTank = 0; // Reset current tank  
            }  
        }  

        // If total gas is non-negative, a solution exists  
        return totalTank >= 0 ? startingStation : -1;  
    }  
}