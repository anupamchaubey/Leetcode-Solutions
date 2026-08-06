class Solution {
    public int minMovesToMakePalindrome(String s) {
        return rec(s);
    }

    int rec(String s) {
        if (s.length() <= 1)
            return 0;
        int i = 0, j = s.length() - 1;
        if (s.charAt(i) == s.charAt(j)) {
            return rec(s.substring(1, j));
        }
        int min = Integer.MAX_VALUE / 2;

        int pos = 0;
        if (s.charAt(i) != s.charAt(j)) {
            for (int idx = i; idx < j; idx++) {
                if (s.charAt(idx) == s.charAt(j)) {
                    if (idx - i < min) {
                        min = idx - i;
                        pos = 0;
                    }
                    break;
                }
            }
            for (int idx = j; idx > i; idx--) {
                if (s.charAt(idx) == s.charAt(i)) {
                    if (j - idx < min) {
                        min = j - idx;
                        pos = 1;
                    }
                    break;
                }
            }
        }
        if (pos == 1) {
            return min + rec(s.substring(1, j - min) + s.substring(j - min + 1));
        } else {
            return min + rec(s.substring(0, min) + s.substring(min + 1, j));
        }
    }
}