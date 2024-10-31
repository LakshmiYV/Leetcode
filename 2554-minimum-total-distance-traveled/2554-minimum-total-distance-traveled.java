import java.util.*;

class Solution {
    public long minimumTotalDistance(List<Integer> robot, int[][] factory) {
        int n = robot.size();
        int m = factory.length;

        // Sort robots and factories by position
        Collections.sort(robot);
        Arrays.sort(factory, Comparator.comparingInt(a -> a[0]));

        // Memoization array to store computed distances
        Long[][] memo = new Long[n][m];
        return calculateMinDistance(robot, factory, 0, 0, memo);
    }

    private long calculateMinDistance(List<Integer> robot, int[][] factory, int robotIdx, int factoryIdx, Long[][] memo) {
        int n = robot.size();
        int m = factory.length;

        // Base case: All robots are assigned
        if (robotIdx == n) return 0;
        // Base case: No more factories to consider
        if (factoryIdx == m) return Long.MAX_VALUE / 2; // Large value to indicate invalid path

        // Check if solution is already computed
        if (memo[robotIdx][factoryIdx] != null) return memo[robotIdx][factoryIdx];

        // Option 1: Skip current factory
        long minDistance = calculateMinDistance(robot, factory, robotIdx, factoryIdx + 1, memo);

        // Option 2: Assign robots to the current factory up to its limit
        long cost = 0;
        for (int i = 0; i < factory[factoryIdx][1] && robotIdx + i < n; i++) {
            cost += Math.abs(robot.get(robotIdx + i) - factory[factoryIdx][0]);
            minDistance = Math.min(minDistance, cost + calculateMinDistance(robot, factory, robotIdx + i + 1, factoryIdx + 1, memo));
        }

        // Memoize and return the result
        memo[robotIdx][factoryIdx] = minDistance;
        return minDistance;
    }
}
