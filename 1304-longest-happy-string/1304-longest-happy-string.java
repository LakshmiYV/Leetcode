

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        // Max heap to store the characters based on their remaining counts
        PriorityQueue<Pair> maxHeap = new PriorityQueue<>((x, y) -> y.count - x.count);

        // Add the available characters to the heap if their counts are non-zero
        if (a > 0) maxHeap.add(new Pair('a', a));
        if (b > 0) maxHeap.add(new Pair('b', b));
        if (c > 0) maxHeap.add(new Pair('c', c));

        StringBuilder result = new StringBuilder();

        while (!maxHeap.isEmpty()) {
            // Pick the most frequent character
            Pair first = maxHeap.poll();

            // Check if the last two characters in the result are the same as the current character
            int len = result.length();
            if (len >= 2 && result.charAt(len - 1) == first.ch && result.charAt(len - 2) == first.ch) {
                // If adding this character would violate the "no three consecutive characters" rule
                if (maxHeap.isEmpty()) {
                    break;  // No other option, so return the current result
                }

                // Pick the second most frequent character
                Pair second = maxHeap.poll();
                result.append(second.ch);  // Append the second character
                second.count--;  // Decrease its count

                // Put the second character back into the heap if it still has remaining occurrences
                if (second.count > 0) {
                    maxHeap.add(second);
                }

                // Put the first character back into the heap since we haven't used it yet
                maxHeap.add(first);
            } else {
                // We can safely add the current most frequent character
                result.append(first.ch);
                first.count--;

                // Put the character back into the heap if it still has remaining occurrences
                if (first.count > 0) {
                    maxHeap.add(first);
                }
            }
        }

        return result.toString();
    }

    // Helper class to store characters and their remaining counts
    static class Pair {
        char ch;
        int count;
        public Pair(char ch, int count) {
            this.ch = ch;
            this.count = count;
        }
    }
}
