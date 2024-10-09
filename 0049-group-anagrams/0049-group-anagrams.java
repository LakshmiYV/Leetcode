class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // Map to hold the sorted string as key and list of anagrams as values
        Map<String, List<String>> map = new HashMap<>();
        
        // Iterate over each string in the input array
        for (String str : strs) {
            // Convert the string to a character array and sort it
            char[] chars = str.toCharArray();
            Arrays.sort(chars);
            String sorted = new String(chars);
            
            // Add the string to the appropriate group in the map
            if (!map.containsKey(sorted)) {
                map.put(sorted, new ArrayList<>());
            }
            map.get(sorted).add(str);
        }
        
        // Return the values (groups of anagrams) as a list of lists
        return new ArrayList<>(map.values());
    }
}
