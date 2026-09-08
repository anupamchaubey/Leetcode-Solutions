class Solution {
    public int countCommas(int n) {
        int cnt = 0;
        for (int i = 1000; i <= n; i++) {
            String s = i + "";
            cnt += ((s.length() + 2) / 3) - 1;
        }
        return cnt;
    }
}