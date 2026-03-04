class Solution {
    public int numSquares(int n) {
        Integer[] memo = new Integer[n + 1];
        return rec(n, memo);
    }

    int rec(int n, Integer[] memo) {
        if (n < 0) {
            return (int) 1e9;
        }
        if (n == 0)
            return 0;
        if (memo[n] != null)
            return memo[n];
        int min = (int) 1e9;
        for (int i = 1; i * i <= n; i++) {
            min = Math.min(min, 1 + rec(n - i * i, memo));
        }
        return memo[n] = min;
    }
}