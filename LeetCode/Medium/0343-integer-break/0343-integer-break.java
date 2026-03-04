class Solution {
    // DP solution
    public int integerBreak(int n) {
        return rec(n);
    }

    int rec(int n) {
        if (n == 1)
            return 0;
        
        int max = 0;
        for (int i = 1; i < n; i++) {
            max = Math.max(max, i * Math.max(n-i, rec(n - i)));
        }
        return max;

    }
}