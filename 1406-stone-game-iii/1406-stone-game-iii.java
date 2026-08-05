class Solution {
    Integer[] dp;

    public String stoneGameIII(int[] stones) {
        dp = new Integer[stones.length];
        int x = rec(stones, 0);
        if (x > 0)
            return "Alice";
        else if (x < 0)
            return "Bob";
        return "Tie";
    }

    int rec(int[] stones, int idx) {
        if (idx == stones.length) {
            return 0;
        }
        if (dp[idx] != null)
            return dp[idx];
        int max = Integer.MIN_VALUE;
        int sum = 0;
        for (int i = idx; i < stones.length && i < idx + 3; i++) {
            sum += stones[i];
            max = Math.max(max, sum - rec(stones, i + 1));
        }
        return dp[idx] = max;
    }
}