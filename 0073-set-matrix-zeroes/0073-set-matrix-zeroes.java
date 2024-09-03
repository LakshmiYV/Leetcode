class Solution {  
    public void setZeroes(int[][] matrix) {  
        int m = matrix.length;  
        int n = matrix[0].length;  
        boolean isFirstRowZero = false;  
        boolean isFirstColZero = false;  

        // Check if the first row has any zero  
        for (int j = 0; j < n; j++) {  
            if (matrix[0][j] == 0) {  
                isFirstRowZero = true;  
                break;  
            }  
        }  

        // Check if the first column has any zero  
        for (int i = 0; i < m; i++) {  
            if (matrix[i][0] == 0) {  
                isFirstColZero = true;  
                break;  
            }  
        }  

        // Use the first row and first column to mark zeroes  
        for (int i = 1; i < m; i++) {  
            for (int j = 1; j < n; j++) {  
                if (matrix[i][j] == 0) {  
                    matrix[i][0] = 0; // Mark the first column  
                    matrix[0][j] = 0; // Mark the first row  
                }  
            }  
        }  

        // Set the matrix to zero using the marks  
        for (int i = 1; i < m; i++) {  
            for (int j = 1; j < n; j++) {  
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {  
                    matrix[i][j] = 0;  
                }  
            }  
        }  

        // Set the first row to zero if needed  
        if (isFirstRowZero) {  
            for (int j = 0; j < n; j++) {  
                matrix[0][j] = 0;  
            }  
        }  

        // Set the first column to zero if needed  
        if (isFirstColZero) {  
            for (int i = 0; i < m; i++) {  
                matrix[i][0] = 0;  
            }  
        }  
    }  
}