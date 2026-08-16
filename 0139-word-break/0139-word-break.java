class Solution {
    Boolean[][] memo;

    public boolean wordBreak(String s, List<String> ls) {
        memo = new Boolean[s.length()][s.length()];
        HashSet<String> hs = new HashSet<>(ls);
        return rec(s, hs, 0, 0);
    }

    boolean rec(String s, HashSet<String> hs, int st, int en) {
        if (en == s.length()) {
            return hs.contains(s.substring(st, en));
        }
        if (memo[st][en] != null)
            return memo[st][en];

        if (st == s.length())
            return true;
        boolean ans = false;
        if (hs.contains(s.substring(st, en))) {
            ans = ans | rec(s, hs, en, en + 1);
        }
        ans = ans | rec(s, hs, st, en + 1);
        return memo[st][en] = ans;
    }
}