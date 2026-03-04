class Solution {
    // DP solution
    Integer[] memo;

    public int integerBreak(int n) {
        int[] dp= new int[n+1];
        dp[1]=0;
        for(int i=2;i<=n;i++){
            for(int j=1;j<i;j++){
                dp[i]=Math.max(dp[i], Math.max(j*(i-j), j*dp[i-j]));
            }
        }
        return dp[n];
    }

    int rec(int n) {
        if (n == 1)
            return 0;
        if (memo[n] != null)
            return memo[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * Math.max(n - i, rec(n - i)));
        }
        return memo[n] = max;

    }
}