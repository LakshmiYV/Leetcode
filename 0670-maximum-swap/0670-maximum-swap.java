class Solution {
    public int maximumSwap(int num) {
        // Convert the number to a character array for easier manipulation
        char[] digits = Integer.toString(num).toCharArray();
        
        // Create an array to store the last index of each digit (0-9)
        int[] last = new int[10];
        
        // Fill the array with the last occurrence of each digit
        for (int i = 0; i < digits.length; i++) {
            last[digits[i] - '0'] = i;
        }
        
        // Traverse the number's digits from left to right
        for (int i = 0; i < digits.length; i++) {
            // For each digit, check if there's a larger digit that appears later
            for (int d = 9; d > digits[i] - '0'; d--) {
                if (last[d] > i) {
                    // Swap the current digit with the larger digit found
                    char temp = digits[i];
                    digits[i] = digits[last[d]];
                    digits[last[d]] = temp;
                    
                    // Return the new number after the swap
                    return Integer.parseInt(new String(digits));
                }
            }
        }
        
        // If no swap was made, return the original number
        return num;
    }
}
