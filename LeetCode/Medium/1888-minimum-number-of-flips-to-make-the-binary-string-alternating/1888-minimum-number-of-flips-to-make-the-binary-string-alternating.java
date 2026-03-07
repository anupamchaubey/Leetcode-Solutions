class Solution {
    public int minFlips(String str) {
        int n = str.length();
        StringBuilder s = new StringBuilder(str + str);
        int ans = Integer.MAX_VALUE;
        int min = 0, miny = 0;
        int st = 0;
        for (int k = 0; k < 2 * n; k++) {
            if (k % 2 == 0 && s.charAt(k) != '0')
                min++;
            if (k % 2 == 1 && s.charAt(k) != '1')
                min++;
            if (k % 2 == 0 && s.charAt(k) != '1')
                miny++;
            if (k % 2 == 1 && s.charAt(k) != '0')
                miny++;
            if (k - st + 1 == n) {
                ans = Math.min(ans, Math.min(min, miny));
                if (st % 2 == 0 && s.charAt(st) != '0')
                    min--;
                if (st % 2 == 1 && s.charAt(st) != '1')
                    min--;
                if (st % 2 == 0 && s.charAt(st) != '1')
                    miny--;
                if (st % 2 == 1 && s.charAt(st) != '0')
                    miny--;
                st++;
            }

        }
        return ans;
    }
}