class Solution {  
    public void gameOfLife(int[][] board) {  
        int m = board.length;  
        int n = board[0].length;  
        
        // Directions for the 8 neighbors  
        int[][] directions = {  
            {-1, -1}, {-1, 0}, {-1, 1},  
            {0, -1},          {0, 1},  
            {1, -1}, {1, 0}, {1, 1}  
        };  
        
        // Iterate through each cell in the board  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                int liveNeighbors = 0;  
                
                // Count live neighbors  
                for (int[] dir : directions) {  
                    int newRow = i + dir[0];  
                    int newCol = j + dir[1];  
                    if (newRow >= 0 && newRow < m && newCol >= 0 && newCol < n) {  
                        if (board[newRow][newCol] == 1 || board[newRow][newCol] == 2) {  
                            liveNeighbors++;  
                        }  
                    }  
                }  
                
                // Apply the rules  
                if (board[i][j] == 1) { // Current cell is live  
                    if (liveNeighbors < 2 || liveNeighbors > 3) {  
                        board[i][j] = 2; // Mark as dead (1 -> 0)  
                    }  
                } else { // Current cell is dead  
                    if (liveNeighbors == 3) {  
                        board[i][j] = -1; // Mark as alive (0 -> 1)  
                    }  
                }  
            }  
        }  
        
        // Update the board to the next state  
        for (int i = 0; i < m; i++) {  
            for (int j = 0; j < n; j++) {  
                if (board[i][j] == 2) {  
                    board[i][j] = 0; // Dead  
                } else if (board[i][j] == -1) {  
                    board[i][j] = 1; // Alive  
                }  
            }  
        }  
    }  
}