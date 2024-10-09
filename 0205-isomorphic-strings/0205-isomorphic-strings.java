class Solution {
    public boolean isIsomorphic(String s, String t) {
        if (s.length() != t.length()) {
            return false;
        }

        // Two maps to store character mappings
        Map<Character, Character> mapS = new HashMap<>();
        Map<Character, Character> mapT = new HashMap<>();

        for (int i = 0; i < s.length(); i++) {
            char sChar = s.charAt(i);
            char tChar = t.charAt(i);

            // Check if sChar is already mapped to some other character
            if (mapS.containsKey(sChar)) {
                if (mapS.get(sChar) != tChar) {
                    return false;
                }
            } else {
                mapS.put(sChar, tChar);
            }

            // Check if tChar is already mapped to some other character
            if (mapT.containsKey(tChar)) {
                if (mapT.get(tChar) != sChar) {
                    return false;
                }
            } else {
                mapT.put(tChar, sChar);
            }
        }
        return true;
    }
}
