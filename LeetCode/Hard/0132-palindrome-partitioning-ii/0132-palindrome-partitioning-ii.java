class Solution {
    boolean[][] pal;
    int[] dp;
    public int minCut(String s) {
        int n = s.length();
        pal = new boolean[n][n];
        
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }
        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int len = j - i + 1;
                if (len == 2) {
                    pal[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    pal[i][j] = (s.charAt(i) == s.charAt(j)) && pal[i + 1][j - 1];
                }
            }
        }
        dp=new int[n];
        Arrays.fill(dp, -1);
        return rec(s, 0) - 1;
    }

    int rec(String s, int st) {
        if (st >= s.length())
            return 0;
        if(dp[st]!=-1)return dp[st];
        int min = Integer.MAX_VALUE;
        for (int i = st; i < s.length(); i++) {
            if (pal[st][i]) {
                min = Math.min(min, 1 + rec(s, i + 1));
            }
        }
        return dp[st]= min;
    }
}