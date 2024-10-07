class Solution {
    public int minLength(String s) {
        // Use a stack to handle the removals
        Stack<Character> stack = new Stack<>();
        
        for (char ch : s.toCharArray()) {
            // Check the last two characters in the stack if they form "AB" or "CD"
            if (!stack.isEmpty()) {
                if ((stack.peek() == 'A' && ch == 'B') || (stack.peek() == 'C' && ch == 'D')) {
                    // Remove the "AB" or "CD" pair
                    stack.pop();
                } else {
                    // Otherwise, push the character onto the stack
                    stack.push(ch);
                }
            } else {
                // If the stack is empty, push the current character
                stack.push(ch);
            }
        }
        
        // The size of the stack is the minimum length
        return stack.size();
    }
}
