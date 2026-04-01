class Solution {
    int[][] dp;
    public int minCost(int len, int[] cuts) {
        Arrays.sort(cuts);
        int n = cuts.length;
        dp=new int[n+2][n+2];
        for(int[] arr: dp)Arrays.fill(arr, -1);
        //padding
        int[] arr = new int[cuts.length + 2];
        arr[0] = 0;
        arr[n + 1] = len;
        for (int i = 0; i < n; i++) {
            arr[i + 1] = cuts[i];
        }

        return rec(arr, 0, n + 1);
    }

    int rec(int[] arr, int st, int en) {
        if (st+1==en)
            return 0;
        if(dp[st][en]!=-1)return dp[st][en];
        int min = Integer.MAX_VALUE;
        for (int k = st + 1; k < en; k++) {
            int left = rec(arr, st, k);
            int right = rec(arr, k, en);
            int cost = arr[en] - arr[st] + left + right;
            min = Math.min(min, cost);
        }
        return dp[st][en]= min;
    }
}