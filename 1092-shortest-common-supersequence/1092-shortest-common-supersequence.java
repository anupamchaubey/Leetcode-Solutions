class Solution {
    String[][] dp;

    public String shortestCommonSupersequence(String str1, String str2) {
        //dp = new String[str1.length()][str2.length()];
        // return rec(str1, str2, 0, 0);

        int[][] dp = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        StringBuilder sb = new StringBuilder();
        int i = dp.length - 1;
        int j = dp[0].length - 1;
        while (i > 0 && j > 0) {
            if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                sb.append(str1.charAt(i - 1));
                i--;
                j--;
            } else if (dp[i - 1][j] > dp[i][j - 1]) {
                sb.append(str1.charAt(i - 1));
                i--;
            } else {
                sb.append(str2.charAt(j - 1));
                j--;
            }
        }
        while (i > 0) {
            sb.append(str1.charAt(i - 1));
            i--;
        }
        while (j > 0) {
            sb.append(str2.charAt(j - 1));
            j--;
        }
        return sb.reverse().toString();
    }

    // String rec(String s1, String s2, int i, int j) {
    //     if (i == s1.length()) {
    //         return s2.substring(j);
    //     } else if (j == s2.length())
    //         return s1.substring(i);
    //     if (dp[i][j] != null)
    //         return dp[i][j];
    //     if (s1.charAt(i) == s2.charAt(j)) {
    //         return dp[i][j] = s1.charAt(i) + rec(s1, s2, i + 1, j + 1);
    //     } else {
    //         String str1 = s1.charAt(i) + rec(s1, s2, i + 1, j);
    //         String str2 = s2.charAt(j) + rec(s1, s2, i, j + 1);
    //         if (str1.length() < str2.length())
    //             return dp[i][j] = str1;
    //         return dp[i][j] = str2;
    //     }
    // }
}