import java.util.*;

class Solution {
    // Memoization map to store previously computed results for sub-expressions
    Map<String, List<Integer>> memo = new HashMap<>();
    
    public List<Integer> diffWaysToCompute(String expression) {
        // Check if the result for the current expression is already computed
        if (memo.containsKey(expression)) {
            return memo.get(expression);
        }
        
        List<Integer> result = new ArrayList<>();
        
        // Loop through the expression to find operators
        for (int i = 0; i < expression.length(); i++) {
            char c = expression.charAt(i);
            if (c == '+' || c == '-' || c == '*') {
                // Split the expression into left and right parts
                String left = expression.substring(0, i);
                String right = expression.substring(i + 1);
                
                // Recursively compute the results for left and right sub-expressions
                List<Integer> leftResults = diffWaysToCompute(left);
                List<Integer> rightResults = diffWaysToCompute(right);
                
                // Combine the results based on the operator
                for (int leftVal : leftResults) {
                    for (int rightVal : rightResults) {
                        if (c == '+') {
                            result.add(leftVal + rightVal);
                        } else if (c == '-') {
                            result.add(leftVal - rightVal);
                        } else if (c == '*') {
                            result.add(leftVal * rightVal);
                        }
                    }
                }
            }
        }
        
        // If no operator was found, the expression is a number
        if (result.isEmpty()) {
            result.add(Integer.parseInt(expression));
        }
        
        // Memoize the result for the current expression
        memo.put(expression, result);
        return result;
    }
}
