class Solution {
    public boolean rotateString(String s, String goal) {
        // If lengths are not equal, `s` cannot be rotated to match `goal`
        if (s.length() != goal.length()) {
            return false;
        }
        
        // Concatenate `s` with itself
        String doubled = s + s;
        
        // Check if `goal` is a substring of `doubled`
        return doubled.contains(goal);
    }
}
