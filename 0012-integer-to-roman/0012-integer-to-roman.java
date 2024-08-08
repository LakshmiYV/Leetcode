class Solution {  
    public String intToRoman(int num) {  
        // Define the values and corresponding Roman numeral symbols  
        int[] values = {1000, 900, 500, 400, 100, 90, 50, 40, 10, 9, 5, 4, 1};  
        String[] symbols = {"M", "CM", "D", "CD", "C", "XC", "L", "XL", "X", "IX", "V", "IV", "I"};  
        
        StringBuilder romanNumeral = new StringBuilder();  
        
        // Iterate through the values and symbols  
        for (int i = 0; i < values.length; i++) {  
            // While the current number is greater than or equal to the value  
            while (num >= values[i]) {  
                romanNumeral.append(symbols[i]); // Append the corresponding symbol  
                num -= values[i]; // Subtract the value from num  
            }  
        }  
        
        return romanNumeral.toString(); // Return the final Roman numeral as a string  
    }  
}