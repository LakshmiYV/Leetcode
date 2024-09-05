class Solution {  
    public boolean canConstruct(String ransomNote, String magazine) {  
        int[] letterCount = new int[26];  

        // Count the letters in the magazine  
        for (char c : magazine.toCharArray()) {  
            letterCount[c - 'a']++;  
        }  

        // Check if ransomNote can be constructed  
        for (char c : ransomNote.toCharArray()) {  
            if (letterCount[c - 'a'] <= 0) {  
                return false; // Not enough letters  
            }  
            letterCount[c - 'a']--; // Use one letter  
        }  

        return true; // All letters are available  
    }  
}