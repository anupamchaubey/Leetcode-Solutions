class Solution {
    public int minOperations(String s) {
        int c1 = 0;
        int c2 = 0;
        for (int i = 0; i < s.length(); i++) {
            if (i % 2 == 0 && s.charAt(i) != '1')
                c1++;
            else if (i % 2 == 1 && s.charAt(i) != '0')
                c1++;
            if (i % 2 == 1 && s.charAt(i) != '1')
                c2++;
            else if (i % 2 == 0 && s.charAt(i) != '0')
                c2++;
        }
        return Math.min(c1, c2);
    }
}