import java.util.*;

class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        int index = 0;
        
        while (index < words.length) {
            int totalChars = words[index].length();
            int last = index + 1;
            
            while (last < words.length) {
                if (totalChars + 1 + words[last].length() > maxWidth) break;
                totalChars += 1 + words[last].length();
                last++;
            }
            
            StringBuilder line = new StringBuilder();
            int numberOfWords = last - index;
            int numberOfSpaces = maxWidth - totalChars;
            
            // If we're on the last line or the line contains only one word, left-justify
            if (last == words.length || numberOfWords == 1) {
                for (int i = index; i < last; i++) {
                    line.append(words[i]);
                    if (i != last - 1) line.append(" ");
                }
                // Add remaining spaces
                while (line.length() < maxWidth) {
                    line.append(" ");
                }
            } else {
                int spacesBetweenWords = numberOfSpaces / (numberOfWords - 1);
                int extraSpaces = numberOfSpaces % (numberOfWords - 1);
                
                for (int i = index; i < last - 1; i++) {
                    line.append(words[i]);
                    line.append(" ");
                    
                    // Add an extra space if needed
                    for (int j = 0; j < spacesBetweenWords + (i - index < extraSpaces ? 1 : 0); j++) {
                        line.append(" ");
                    }
                }
                
                line.append(words[last - 1]); // Add the last word in the line
            }
            
            result.add(line.toString());
            index = last; // Move to the next line
        }
        
        return result;
    }
}
