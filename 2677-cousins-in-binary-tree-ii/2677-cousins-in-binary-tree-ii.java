import java.util.*;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode() {}
    TreeNode(int val) { this.val = val; }
    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

class Solution {
    public TreeNode replaceValueInTree(TreeNode root) {
        if (root == null) return null;

        // Step 1: BFS traversal with a queue
        Queue<TreeNode> queue = new LinkedList<>();
        queue.offer(root);

        root.val = 0;  // The root node doesn't have any cousins, so we set its value to 0.

        // Step 2: Traverse the tree level by level
        while (!queue.isEmpty()) {
            int levelSize = queue.size();  // Number of nodes at the current level
            int levelSum = 0;  // Sum of values of nodes at the current level
            
            // List to store nodes at the current level to update their values later
            List<TreeNode> currentLevelNodes = new ArrayList<>();

            // Step 3: Collect all nodes at the current level and calculate their sum
            for (int i = 0; i < levelSize; i++) {
                TreeNode currentNode = queue.poll();
                currentLevelNodes.add(currentNode);

                if (currentNode.left != null) {
                    levelSum += currentNode.left.val;
                    queue.offer(currentNode.left);
                }
                if (currentNode.right != null) {
                    levelSum += currentNode.right.val;
                    queue.offer(currentNode.right);
                }
            }

            // Step 4: For each node in the current level, calculate the sum of its cousins
            for (TreeNode node : currentLevelNodes) {
                int leftVal = (node.left != null) ? node.left.val : 0;
                int rightVal = (node.right != null) ? node.right.val : 0;

                // Set the left child's value to the sum of all other nodes at the same level (i.e., cousins)
                if (node.left != null) {
                    node.left.val = levelSum - leftVal - rightVal;
                }

                // Set the right child's value to the sum of all other nodes at the same level (i.e., cousins)
                if (node.right != null) {
                    node.right.val = levelSum - leftVal - rightVal;
                }
            }
        }

        return root;
    }
}
