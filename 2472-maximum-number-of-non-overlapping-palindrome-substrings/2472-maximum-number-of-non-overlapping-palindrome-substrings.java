class Solution {
    int[] memo;
    boolean[][] pal;

    public int maxPalindromes(String s, int k) {
        memo = new int[s.length()];
        pal = new boolean[s.length()][s.length()];
        for (int i = s.length() - 1; i >= 0; i--) {
            for (int j = i; j < s.length(); j++) {
                if (i == j)
                    pal[i][j] = true;
                else if (j - i + 1 == 2) {
                    pal[i][j] = s.charAt(i) == s.charAt(j);
                    pal[j][i] = s.charAt(i) == s.charAt(j);
                } else {
                    pal[i][j] = s.charAt(i) == s.charAt(j) && pal[i + 1][j - 1];
                    pal[j][i] = s.charAt(i) == s.charAt(j) && pal[j - 1][i + 1];
                }
            }
        }
        return rec(s, k, 0);
    }

    int rec(String s, int k, int st) {
        if (st == s.length())
            return 0;
        if (memo[st] != 0)
            return memo[st];
        int max = 0;
        for (int i = st; i < s.length(); i++) {
            if (i - st + 1 >= k && pal[st][i]) {
                max = Math.max(max, 1 + rec(s, k, i + 1));
            }
        }
        max = Math.max(max, rec(s, k, st + 1));
        return memo[st] = max;
    }
}