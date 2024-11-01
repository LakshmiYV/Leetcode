class Solution {
    public String makeFancyString(String s) {
        StringBuilder result = new StringBuilder();
        int count = 1; // Start with 1 since the first character will always be added

        // Append the first character to the result
        result.append(s.charAt(0));
        
        // Iterate over the string starting from the second character
        for (int i = 1; i < s.length(); i++) {
            // Check if the current character is the same as the previous one
            if (s.charAt(i) == s.charAt(i - 1)) {
                count++;
            } else {
                count = 1; // Reset count if the character is different
            }
            
            // Append to result only if it does not form three consecutive characters
            if (count < 3) {
                result.append(s.charAt(i));
            }
        }

        return result.toString();
    }
}
