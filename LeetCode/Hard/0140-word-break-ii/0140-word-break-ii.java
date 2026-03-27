class Solution {
    List<String> ans;

    public List<String> wordBreak(String s, List<String> wordDict) {
        ans = new ArrayList<>();
        HashSet<String> hs = new HashSet<>();
        for (String p : wordDict)
            hs.add(p);
        rec(s, hs, "", 0, 1);
        return ans;
    }

    void rec(String s, HashSet<String> hs, String str, int i, int j) {
        if (i >= s.length()) {
            ans.add(str.trim());
        }
        if (j > s.length())
            return;
        if (hs.contains(s.substring(i, j))) {
            rec(s, hs, str + s.substring(i, j) + " ", j, j + 1);
        }
        rec(s, hs, str, i, j + 1);
    }
}