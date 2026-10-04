class Solution {
    Integer[][] dp;

    public int lastStoneWeightII(int[] stones) {

        int sum = 0;
        for (int x : stones)
            sum += x;
        int half = sum / 2;
        dp = new Integer[stones.length][sum+1];
        int closestValueToHalf = rec(stones, 0, 0, half);
        return Math.abs(sum - 2 * closestValueToHalf);
    }

    int rec(int[] stones, int idx, int sum, int half) {
        if (idx == stones.length) {
            if (sum <= half)
                return sum;
            else
                return Integer.MIN_VALUE / 3;
        }
        if (dp[idx][sum] != null)
            return dp[idx][sum];
        int max = 0;
        max = Math.max(max, rec(stones, idx + 1, sum + stones[idx], half));
        max = Math.max(max, rec(stones, idx + 1, sum, half));
        return dp[idx][sum] = max;
    }
}