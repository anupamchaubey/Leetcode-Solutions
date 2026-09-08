class Solution {
    public int longestValidParentheses(String s) {
        int max = 0;
        int l = 0;
        int open = 0, closed = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                open++;
            } else
                closed++;
            while (closed > open) {
                if (s.charAt(l) == '(')
                    open--;
                else
                    closed--;
                l++;
            }
            if (open == closed)
                max = Math.max(max, i - l + 1);
        }
        l = s.length() - 1;
        open = 0;
        closed = 0;
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) == '(') {
                open++;
            } else
                closed++;
            while (closed < open) {
                if (s.charAt(l) == '(')
                    open--;
                else
                    closed--;
                l--;
            }
            if (open == closed)
                max = Math.max(max, l - i + 1);
        }

        return max;
    }
}