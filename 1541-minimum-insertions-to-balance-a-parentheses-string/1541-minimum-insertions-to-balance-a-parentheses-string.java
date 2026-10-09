class Solution {
    public int minInsertions(String s) {
        int cnt = 0;
        int depth = 0;
        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (ch == '(') {
                depth++;
            } else {
                if (i + 1 < s.length() && s.charAt(i + 1) == ')') {
                    i++;
                } else {
                    cnt++;
                }
                depth--;
            }
            if (depth < 0) {
                cnt++;
                depth++;
            }
        }
        if (depth > 0)
            cnt += 2 * depth;
        return cnt;
    }
}