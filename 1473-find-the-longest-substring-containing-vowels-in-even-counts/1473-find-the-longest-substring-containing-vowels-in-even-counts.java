class Solution {  
    public int findTheLongestSubstring(String s) {  
        // Map to store the first occurrence index of each state  
        Map<Integer, Integer> firstOccurrence = new HashMap<>();  
        firstOccurrence.put(0, -1); // state 0 occurs at index -1 (before the string starts)  

        int maxLength = 0;  
        int state = 0; // bitmask representing the count of vowels  

        for (int i = 0; i < s.length(); i++) {  
            char c = s.charAt(i);  
            switch (c) {  
                case 'a':  
                    state ^= 1 << 0; // Toggle the bit for 'a'  
                    break;  
                case 'e':  
                    state ^= 1 << 1; // Toggle the bit for 'e'  
                    break;  
                case 'i':  
                    state ^= 1 << 2; // Toggle the bit for 'i'  
                    break;  
                case 'o':  
                    state ^= 1 << 3; // Toggle the bit for 'o'  
                    break;  
                case 'u':  
                    state ^= 1 << 4; // Toggle the bit for 'u'  
                    break;  
            }  

            // If this state has been seen before, calculate the length of the substring  
            if (firstOccurrence.containsKey(state)) {  
                maxLength = Math.max(maxLength, i - firstOccurrence.get(state));  
            } else {  
                // Store the first occurrence of this state  
                firstOccurrence.put(state, i);  
            }  
        }  

        return maxLength;  
    }  
}