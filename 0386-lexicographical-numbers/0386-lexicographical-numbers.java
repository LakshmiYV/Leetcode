import java.util.*;

class Solution {
    public List<Integer> lexicalOrder(int n) {
        List<Integer> result = new ArrayList<>();
        // Start the DFS from each digit 1 through 9.
        for (int i = 1; i <= 9; i++) {
            dfs(i, n, result);
        }
        return result;
    }
    
    private void dfs(int current, int n, List<Integer> result) {
        if (current > n) {
            return; // Stop the recursion if the number exceeds n.
        }
        result.add(current); // Add the current number to the result list.
        // Explore all numbers formed by appending digits 0-9 to the current number.
        for (int i = 0; i <= 9; i++) {
            int next = current * 10 + i;
            if (next > n) {
                break; // No need to continue if the number exceeds n.
            }
            dfs(next, n, result); // Recursively call DFS for the next number.
        }
    }
}
