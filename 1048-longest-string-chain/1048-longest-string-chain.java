class Solution {
    Integer[][] dp;

    public int longestStrChain(String[] words) {
        dp = new Integer[words.length + 1][words.length + 1];
        Arrays.sort(words, (a, b) -> a.length() - b.length());
        return rec(words, 0, -1);
    }

    int rec(String[] words, int idx, int prev) {
        if (idx == words.length)
            return 0;
        if (prev != -1 && dp[idx][prev] != null)
            return dp[idx][prev];
        int max = 0;
        if (prev == -1 || isPredecessor(words[prev], words[idx])) {
            max = 1 + rec(words, idx + 1, idx);
        }
        max = Math.max(max, rec(words, idx + 1, prev));
        if (prev != -1)
            dp[idx][prev] = max;
        return max;
    }

    boolean isPredecessor(String a, String b) {
        if (b.length() <= a.length())
            return false;
        int c = 0;
        int i = 0, j = 0;
        while (i < a.length() && j < b.length()) {
            if (a.charAt(i) == b.charAt(j)) {
                i++;
                j++;
            } else {
                j++;
                c++;
            }
            if (c > 1)
                return false;
        }
        c += (b.length() - j);

        return c == 1;
    }
}