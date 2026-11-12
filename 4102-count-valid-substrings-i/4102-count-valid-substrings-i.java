class Solution {
    public long countValidSubstrings(String s) {
        long cnt = 0L;
        int p = -1;
        for (int i = 0; i < s.length(); i++) {
            if (i >= 2 && s.charAt(i - 2) == 'a' && s.charAt(i - 1) == 'b' && s.charAt(i) == 'c') {
                p = i - 2;
            }
            cnt += (i - p);
        }
        return cnt;
    }
}