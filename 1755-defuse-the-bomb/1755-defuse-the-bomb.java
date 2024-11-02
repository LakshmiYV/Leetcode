class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] result = new int[n];
        
        if (k == 0) {
            // If k is 0, all elements in the result should be 0
            return result;
        }
        
        for (int i = 0; i < n; i++) {
            int sum = 0;
            
            if (k > 0) {
                // Sum of the next k numbers
                for (int j = 1; j <= k; j++) {
                    sum += code[(i + j) % n];
                }
            } else {
                // Sum of the previous |k| numbers
                for (int j = 1; j <= -k; j++) {
                    sum += code[(i - j + n) % n];
                }
            }
            
            result[i] = sum;
        }
        
        return result;
    }
}
