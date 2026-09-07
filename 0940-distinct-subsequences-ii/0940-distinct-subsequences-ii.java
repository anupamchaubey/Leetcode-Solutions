class Solution {
    // 1, 3, 7, 15, 31
    int mod = 1000000007;

    public int distinctSubseqII(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int[] dp = new int[s.length() + 1];
        dp[0] = 0;
        for (int i = 0; i < s.length(); i++) {

            if (hm.containsKey(s.charAt(i))) {
                int val = (2 * dp[i]) % mod;
                dp[i + 1] = (val - dp[hm.get(s.charAt(i)) - 1] + mod) % mod;
            } else {
                dp[i + 1] = (2 * dp[i]) % mod + 1;
            }
            hm.put(s.charAt(i), i + 1);
        }
        return dp[s.length()];
    }
}