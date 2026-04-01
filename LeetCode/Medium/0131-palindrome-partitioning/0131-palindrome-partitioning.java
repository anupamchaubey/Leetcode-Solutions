class Solution {
    List<List<String>> ans;
    boolean[][] pal;

    public List<List<String>> partition(String s) {
        ans = new ArrayList<>();

        int n = s.length();
        pal = new boolean[n][n];
        for (int i = 0; i < n; i++) {
            pal[i][i] = true;
        }
        for (int j = 0; j < n; j++) {
            for (int i = j - 1; i >= 0; i--) {
                int len = j - i + 1;
                if (len == 2) {
                    pal[i][j] = s.charAt(i) == s.charAt(j);
                } else {
                    pal[i][j] = (s.charAt(i) == s.charAt(j)) && pal[i + 1][j - 1];
                }
            }
        }
        rec(s, new ArrayList<>(), 0);
        return ans;
    }

    void rec(String s, List<String> ls, int st) {
        if (st == s.length()) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = st; i < s.length(); i++) {
            if (pal[st][i]) {
                ls.add(s.substring(st, i + 1));
                rec(s, ls, i + 1);
                ls.remove(ls.size() - 1);
            }
        }
    }
}