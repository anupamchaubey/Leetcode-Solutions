class Solution {
    public int maxJumps(int[] arr, int d) {
        int max = 1;
        int[] dp = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            
            max = Math.max(max, rec(arr, d, i, dp));
        }
        return max;
    }

    int rec(int[] arr, int d, int idx, int[] dp) {
        if (dp[idx] != 0)
            return dp[idx];

        int ans = 1;
        for (int i = idx + 1; i <= Math.min(arr.length - 1, idx + d); i++) {
            if (arr[i] >= arr[idx])
                break;
            ans = Math.max(ans, 1 + rec(arr, d, i, dp));
        }
        for (int i = idx - 1; i >= Math.max(0, idx - d); i--) {
            if (arr[i] >= arr[idx])
                break;
            ans = Math.max(ans, 1 + rec(arr, d, i, dp));
        }
        return dp[idx] = ans;
    }
}