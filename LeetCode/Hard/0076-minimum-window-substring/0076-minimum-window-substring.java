class Solution {
    public String minWindow(String s, String t) {

        int[] ch = new int[128];
        for (char c : t.toCharArray()) {
            ch[c]++;
        }
        int count = t.length();

        int min = Integer.MAX_VALUE;
        int st = -1, en = -1;
        int i = 0, j = 0;
        while (j < s.length()) {

            if (ch[s.charAt(j)] > 0) {
                count--;
            }
            ch[s.charAt(j)]--;

            while (count == 0) {
                if (min > (j - i + 1)) {
                    min = j - i + 1;
                    st = i;
                    en = j + 1;
                }

                ch[s.charAt(i)]++;
                if (ch[s.charAt(i)] > 0)
                    count++;

                i++;
            }
            j++;
        }
        if (st == -1)
            return "";
        return s.substring(st, en);

    }

    boolean isValid(String s, String t) {
        int[] chars = new int[128];
        for (char ch : t.toCharArray()) {
            chars[ch]++;
        }
        for (char ch : s.toCharArray()) {
            chars[ch]--;

        }
        for (int x : chars) {
            if (x > 0)
                return false;
        }
        return true;

    }
}