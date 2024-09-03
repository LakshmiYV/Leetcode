class Solution {  
    public void rotate(int[][] matrix) {  
        int n = matrix.length;  

        // Step 1: Transpose the matrix  
        for (int i = 0; i < n; i++) {  
            for (int j = i + 1; j < n; j++) {  
                // Swap elements  
                int temp = matrix[i][j];  
                matrix[i][j] = matrix[j][i];  
                matrix[j][i] = temp;  
            }  
        }  

        // Step 2: Reverse each row  
        for (int i = 0; i < n; i++) {  
            for (int j = 0; j < n / 2; j++) {  
                // Swap elements  
                int temp = matrix[i][j];  
                matrix[i][j] = matrix[i][n - 1 - j];  
                matrix[i][n - 1 - j] = temp;  
            }  
        }  
    }  
}