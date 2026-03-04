class Solution {
    // DP solution
    Integer[] memo;
    public int integerBreak(int n) {
        memo=new Integer[n+1];
        return rec(n);
    }

    int rec(int n) {
        if (n == 1)
            return 0;
        if(memo[n]!=null)return memo[n];
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * Math.max(n-i, rec(n - i)));
        }
        return memo[n]= max;

    }
}