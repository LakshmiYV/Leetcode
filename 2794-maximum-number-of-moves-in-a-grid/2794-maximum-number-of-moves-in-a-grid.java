class Solution {
    public int maxMoves(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        
        int[][] dp = new int[m][n];
        
        // Fill dp array by iterating from the last column to the first column
        int maxMoves = 0;
        for (int col = n - 2; col >= 0; col--) {
            for (int row = 0; row < m; row++) {
                int currentVal = grid[row][col];
                int maxNextMoves = 0;
                
                // Check the three possible moves: top-right, right, and bottom-right
                if (row > 0 && grid[row - 1][col + 1] > currentVal) {
                    maxNextMoves = Math.max(maxNextMoves, dp[row - 1][col + 1] + 1);
                }
                if (grid[row][col + 1] > currentVal) {
                    maxNextMoves = Math.max(maxNextMoves, dp[row][col + 1] + 1);
                }
                if (row < m - 1 && grid[row + 1][col + 1] > currentVal) {
                    maxNextMoves = Math.max(maxNextMoves, dp[row + 1][col + 1] + 1);
                }
                
                dp[row][col] = maxNextMoves;
                
                // Update the global maxMoves if we are in the first column
                if (col == 0) {
                    maxMoves = Math.max(maxMoves, dp[row][col]);
                }
            }
        }
        
        return maxMoves;
    }
}
