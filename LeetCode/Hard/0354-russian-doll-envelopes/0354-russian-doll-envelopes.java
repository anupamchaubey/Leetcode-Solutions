class Solution {
    public int maxEnvelopes(int[][] envelopes) {
        int n = envelopes.length;
        Arrays.sort(envelopes, (a, b) -> {
            if (a[0] == b[0])
                return b[1] - a[1];
            return a[0] - b[0];
        });
        int[] dp = new int[n];
        Arrays.fill(dp, 1);
        int size = 0;
        for (int[] v : envelopes) {
            int l = 0, r = size;
            while (l < r) {
                int mid = (l + r) / 2;
                if (dp[mid] < v[1]) {
                    l = mid + 1;
                } else {
                    r = mid;
                }
            }
            dp[l] = v[1];
            if (l == size)
                size++;
        }

        return size;
    }
}