class Solution {
    Integer[][] dp;

    public String stoneGameIII(int[] stones) {
        dp = new Integer[stones.length][2];
        int totalSum = 0;
        for (int x : stones)
            totalSum += x;
        int x = rec(stones, totalSum, 0, 1);
        if (x > 0)
            return "Alice";
        else if (x < 0)
            return "Bob";
        return "Tie";
    }

    int rec(int[] stones, int total, int idx, int alice) {
        if (idx == stones.length) {
            return 0;
        }
        if (dp[idx][alice] != null)
            return dp[idx][alice];
        if (alice == 1) {

            int max = stones[idx] + rec(stones, total, idx + 1, 0);
            if (idx + 1 < stones.length)
                max = Math.max(max, stones[idx] + stones[idx + 1] + rec(stones, total, idx + 2, 0));
            if (idx + 2 < stones.length)
                max = Math.max(max, stones[idx] + stones[idx + 1] + stones[idx + 2] + rec(stones, total, idx + 3, 0));
            return dp[idx][alice] = max;
        } else {
            int min = -stones[idx] + rec(stones, total, idx + 1, 1);
            if (idx + 1 < stones.length)
                min = Math.min(min, -stones[idx] - stones[idx + 1] + rec(stones, total, idx + 2, 1));
            if (idx + 2 < stones.length)
                min = Math.min(min, -stones[idx] - stones[idx + 1] - stones[idx + 2] + rec(stones, total, idx + 3, 1));

            return dp[idx][alice] = min;
        }
    }
}