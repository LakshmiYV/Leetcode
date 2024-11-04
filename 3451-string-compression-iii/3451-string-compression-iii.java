class Solution {
    public String compressedString(String word) {
        StringBuilder comp = new StringBuilder();
        int n = word.length();
        int count = 0;
        
        for (int i = 0; i < n; i++) {
            count++;
            // Check if the next character is different or if the count has reached 9
            if (i == n - 1 || word.charAt(i) != word.charAt(i + 1) || count == 9) {
                comp.append(count).append(word.charAt(i));
                count = 0; // Reset count for the next character
            }
        }
        
        return comp.toString();
    }
}
