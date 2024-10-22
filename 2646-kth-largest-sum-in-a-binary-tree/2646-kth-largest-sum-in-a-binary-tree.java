import java.util.*;

class Solution {
    public long kthLargestLevelSum(TreeNode root, int k) {
        if (root == null) return -1;
        
        // Step 1: Perform a level-order traversal (BFS)
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);
        
        List<Long> levelSums = new ArrayList<>();
        
        while (!queue.isEmpty()) {
            int size = queue.size();
            long currentLevelSum = 0;
            
            // Traverse all nodes at the current level
            for (int i = 0; i < size; i++) {
                TreeNode node = queue.poll();
                currentLevelSum += node.val;
                
                // Add children to the queue for the next level
                if (node.left != null) queue.offer(node.left);
                if (node.right != null) queue.offer(node.right);
            }
            
            // Store the sum of the current level
            levelSums.add(currentLevelSum);
        }
        
        // Step 2: Sort the level sums in descending order
        Collections.sort(levelSums, Collections.reverseOrder());
        
        // Step 3: Return the Kth largest sum or -1 if k is greater than the number of levels
        if (k > levelSums.size()) {
            return -1;
        }
        
        return levelSums.get(k - 1);
    }
}
