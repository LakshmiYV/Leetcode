import java.util.*;

class Solution {
    public int[] maximumBeauty(int[][] items, int[] queries) {
        // Sort items by price, and if prices are the same, keep the item with maximum beauty
        Arrays.sort(items, (a, b) -> a[0] - b[0]);
        
        // Prepare a list of prices and a corresponding list of maximum beauties up to each price
        List<Integer> prices = new ArrayList<>();
        List<Integer> beauties = new ArrayList<>();
        
        int maxBeauty = 0;
        for (int[] item : items) {
            int price = item[0];
            int beauty = item[1];
            // Only update maxBeauty if the current item's beauty is greater
            maxBeauty = Math.max(maxBeauty, beauty);
            
            // Avoid duplicate prices in prices list
            if (prices.isEmpty() || prices.get(prices.size() - 1) != price) {
                prices.add(price);
                beauties.add(maxBeauty);
            } else {
                // Update the beauty at the last price to the maximum beauty so far
                beauties.set(beauties.size() - 1, maxBeauty);
            }
        }
        
        // Sort queries and maintain their original indices
        int n = queries.length;
        int[][] queryWithIndex = new int[n][2];
        for (int i = 0; i < n; i++) {
            queryWithIndex[i][0] = queries[i];
            queryWithIndex[i][1] = i;
        }
        Arrays.sort(queryWithIndex, (a, b) -> a[0] - b[0]);
        
        // Result array to store the answer for each query
        int[] result = new int[n];
        
        // Process each query using binary search
        for (int[] query : queryWithIndex) {
            int queryPrice = query[0];
            int index = query[1];
            
            // Binary search to find the rightmost price <= queryPrice
            int pos = Collections.binarySearch(prices, queryPrice);
            if (pos < 0) pos = -pos - 2;
            
            // If pos is -1, there is no valid item with price <= queryPrice
            result[index] = pos >= 0 ? beauties.get(pos) : 0;
        }
        
        return result;
    }
}
