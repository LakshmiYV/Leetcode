class Solution {
    class TrieNode {
        TrieNode[] children;
        int count; // To store how many words have this prefix
        
        public TrieNode() {
            children = new TrieNode[26]; // 26 lowercase letters
            count = 0;
        }
    }
    
    class Trie {
        TrieNode root;
        
        public Trie() {
            root = new TrieNode();
        }
        
        // Insert a word into the Trie and increment the count of each prefix
        public void insert(String word) {
            TrieNode node = root;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                if (node.children[index] == null) {
                    node.children[index] = new TrieNode();
                }
                node = node.children[index];
                node.count++; // Increment the count for this prefix
            }
        }
        
        // Get the sum of prefix scores for a word
        public int getPrefixScore(String word) {
            TrieNode node = root;
            int score = 0;
            for (char c : word.toCharArray()) {
                int index = c - 'a';
                node = node.children[index];
                score += node.count; // Add the count for this prefix
            }
            return score;
        }
    }
    
    public int[] sumPrefixScores(String[] words) {
        Trie trie = new Trie();
        // Insert all words into the Trie
        for (String word : words) {
            trie.insert(word);
        }
        
        // Calculate the sum of prefix scores for each word
        int[] result = new int[words.length];
        for (int i = 0; i < words.length; i++) {
            result[i] = trie.getPrefixScore(words[i]);
        }
        
        return result;
    }
}
