class Solution {     
    public String reverseWords(String s) {  
        // Split the string by whitespace and filter out empty words  
        String[] words = s.trim().split("\\s+");  
        
        // Use a StringBuilder to create the result  
        StringBuilder reversed = new StringBuilder();  
        
        // Reverse the words  
        for (int i = words.length - 1; i >= 0; i--) {  
            reversed.append(words[i]);  
            if (i != 0) {  
                reversed.append(" "); // Add a space between words  
            }  
        }  

        return reversed.toString();  
    }   
}