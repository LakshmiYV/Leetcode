class Solution {
    public boolean isCircularSentence(String sentence) {
        // Split the sentence into words
        String[] words = sentence.split(" ");
        
        // Check the condition between consecutive words
        for (int i = 0; i < words.length - 1; i++) {
            // Compare last character of the current word with first character of the next word
            if (words[i].charAt(words[i].length() - 1) != words[i + 1].charAt(0)) {
                return false; // Not circular
            }
        }
        
        // Check the condition between the last word and the first word
        if (words[words.length - 1].charAt(words[words.length - 1].length() - 1) != words[0].charAt(0)) {
            return false; // Not circular
        }
        
        return true; // All conditions are met, sentence is circular
    }
}
