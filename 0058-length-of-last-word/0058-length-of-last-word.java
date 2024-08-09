/*
class Solution {  
    public int lengthOfLastWord(String s) {  
        // Trim the string to remove any trailing spaces  
        s = s.trim();  
        
        // Find the last space in the trimmed string  
        int lastSpaceIndex = s.lastIndexOf(' ');  
        
        // If there is no space, return the length of the entire string  
        if (lastSpaceIndex == -1) {  
            return s.length();  
        }  
        
        // Return the length of the last word  
        return s.length() - lastSpaceIndex - 1;  
    }  
}
*/


class Solution {
    public int lengthOfLastWord(String s) {
        // Trim any trailing spaces
        s = s.trim();
        
        // Split the string into an array of words
        String[] words = s.split(" ");
        
        // Return the length of the last word
        return words[words.length - 1].length();
    }
}
