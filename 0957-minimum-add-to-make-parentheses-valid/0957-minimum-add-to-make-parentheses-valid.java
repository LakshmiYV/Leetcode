class Solution {
    public int minAddToMakeValid(String s) {
        int open = 0; // Tracks unmatched opening parentheses
        int unbalanced_closing = 0; // Tracks unmatched closing parentheses
        
        for (char c : s.toCharArray()) {
            if (c == '(') {
                open++; // Unmatched opening parenthesis
            } else { // c == ')'
                if (open > 0) {
                    open--; // Match with an unmatched opening parenthesis
                } else {
                    unbalanced_closing++; // Unmatched closing parenthesis
                }
            }
        }
        
        // The result is the sum of unmatched opening and closing parentheses
        return open + unbalanced_closing;
    }
}
