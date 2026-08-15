class Solution {
    public int minOperations(String s) {
        int min = Integer.MAX_VALUE;
        int n = s.length();

        for (int k = 0; k < n; k++) {
            int cost = k;
            for (int j = 0; j < n / 2; j++) {
                int a = s.charAt(j) - 'a';
                int b = s.charAt(n - j - 1) - 'a';

                int forward = (b - a + 26) % 26;
                int backward = (a - b + 26) % 26;
                cost += Math.min(forward, backward);
            }
            s = s.substring(1) + s.charAt(0);
            min = Math.min(min, cost);
        }
        return min;
    }
}