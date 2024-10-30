import java.util.Stack;

class Solution {
    public String simplifyPath(String path) {
        // Split the path by "/"
        String[] components = path.split("/");
        Stack<String> stack = new Stack<>();
        
        // Process each component
        for (String part : components) {
            if (part.isEmpty() || part.equals(".")) {
                // Ignore empty parts and current directory symbol
                continue;
            } else if (part.equals("..")) {
                // Go up one directory if possible
                if (!stack.isEmpty()) {
                    stack.pop();
                }
            } else {
                // Valid directory name, push onto the stack
                stack.push(part);
            }
        }
        
        // Construct the simplified path from the stack
        StringBuilder result = new StringBuilder();
        for (String dir : stack) {
            result.append("/").append(dir);
        }
        
        // Return root "/" if stack is empty
        return result.length() > 0 ? result.toString() : "/";
    }
}
