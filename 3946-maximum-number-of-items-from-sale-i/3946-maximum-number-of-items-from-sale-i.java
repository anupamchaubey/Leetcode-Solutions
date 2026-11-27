class Solution {
    int[] factors;
    int[][][] dp;

    public int maximumSaleItems(int[][] items, int budget) {

        dp = new int[items.length][budget + 1][2];

        for (int i = 0; i < items.length; i++)
            for (int j = 0; j <= budget; j++)
                Arrays.fill(dp[i][j], -1);

        factors = new int[items.length];

        for (int i = 0; i < items.length; i++) {

            for (int j = 0; j < items.length; j++) {
                if (i == j)
                    continue;
                if (items[j][0] % items[i][0] == 0) {
                    factors[i]++;
                }
            }
        }
        return rec(items, 0, budget, 0);

    }

    int rec(int[][] items, int idx, int remainingBudget, int boughtOnce) {
        if (idx == items.length)
            return 0;

        if (dp[idx][remainingBudget][boughtOnce] != -1)
            return dp[idx][remainingBudget][boughtOnce];
        int ans = 0;

        //buy this item if the price of this is less than remaining budget

        if (items[idx][1] <= remainingBudget) {

            ans = ((boughtOnce == 0) ? factors[idx] : 0) + 1 + rec(items, idx, remainingBudget - items[idx][1], 1);

            ans = Math.max(ans, ((boughtOnce == 0) ? factors[idx] : 0) + 1
                    + rec(items, idx + 1, remainingBudget - items[idx][1], 0));
        }

        ans = Math.max(ans, rec(items, idx + 1, remainingBudget, 0));

        return dp[idx][remainingBudget][boughtOnce] = ans;
    }
}