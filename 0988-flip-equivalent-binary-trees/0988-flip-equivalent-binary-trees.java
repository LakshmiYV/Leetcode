class Solution {
    public boolean flipEquiv(TreeNode root1, TreeNode root2) {
        // Base cases
        if (root1 == null && root2 == null) return true; // Both nodes are null
        if (root1 == null || root2 == null) return false; // One of them is null
        if (root1.val != root2.val) return false; // Values do not match
        
        // Recursive case:
        // Check if (left, right) are equivalent or if (left, flipped-right) are equivalent
        boolean noFlip = flipEquiv(root1.left, root2.left) && flipEquiv(root1.right, root2.right);
        boolean flip = flipEquiv(root1.left, root2.right) && flipEquiv(root1.right, root2.left);
        
        return noFlip || flip;
    }
}