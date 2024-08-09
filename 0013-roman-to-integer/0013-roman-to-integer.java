class Solution {  
    public int romanToInt(String s) {  
        // Map of Roman numerals and their values  
        Map<Character, Integer> romanMap = new HashMap<>();  
        romanMap.put('I', 1);  
        romanMap.put('V', 5);  
        romanMap.put('X', 10);  
        romanMap.put('L', 50);  
        romanMap.put('C', 100);  
        romanMap.put('D', 500);  
        romanMap.put('M', 1000);  
        
        int total = 0;  
        int prevValue = 0;  
        
        // Iterate through each character in the Roman numeral string  
        for (int i = s.length() - 1; i >= 0; i--) {  
            char currentChar = s.charAt(i);  
            int currentValue = romanMap.get(currentChar);  
            
            // If the current value is less than the previous value, we subtract it  
            if (currentValue < prevValue) {  
                total -= currentValue;  
            } else {  
                // Otherwise, we add it  
                total += currentValue;  
            }  
            
            // Update previous value  
            prevValue = currentValue;  
        }  
        
        return total;  
    }  
}