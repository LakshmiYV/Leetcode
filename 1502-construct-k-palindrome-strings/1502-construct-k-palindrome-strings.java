class Solution {
    public boolean canConstruct(String s, int k) {
        // If k is greater than the length of the string, it's impossible
        if (k > s.length()) return false;

        // Count the frequency of each character
        int[] charCount = new int[26];
        for (char c : s.toCharArray()) {
            charCount[c - 'a']++;
        }

        // Count the number of odd frequencies
        int oddCount = 0;
        for (int count : charCount) {
            if (count % 2 != 0) oddCount++;
        }

        // We can construct k palindromes if oddCount <= k
        return oddCount <= k;
    }
}
