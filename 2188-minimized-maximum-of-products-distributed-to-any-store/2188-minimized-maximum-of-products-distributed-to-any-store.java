class Solution {
    public int minimizedMaximum(int n, int[] quantities) {
        int left = 1;
        int right = Arrays.stream(quantities).max().getAsInt();

        while (left < right) {
            int mid = left + (right - left) / 2;

            if (canDistribute(n, quantities, mid)) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }

        return left;
    }

    private boolean canDistribute(int n, int[] quantities, int maxPerStore) {
        int requiredStores = 0;

        for (int quantity : quantities) {
            requiredStores += (quantity + maxPerStore - 1) / maxPerStore; // Equivalent to ceil(quantity / maxPerStore)
            if (requiredStores > n) {
                return false;
            }
        }

        return true;
    }
}
