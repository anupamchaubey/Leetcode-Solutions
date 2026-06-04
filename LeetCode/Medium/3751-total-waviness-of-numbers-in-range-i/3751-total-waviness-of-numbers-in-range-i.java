class Solution {
    public int totalWaviness(int num1, int num2) {
        int total = 0;
        for (int i = num1; i <= num2; i++) {
            total += (int) wave(i);
        }
        return total;
    }

    int wave(long num) {
        String s = Long.toString(num);
        if (s.length() < 3)
            return 0;
        int w = 0;
        for (int i = 1; i < s.length() - 1; i++) {
            char a = s.charAt(i - 1);
            char b = s.charAt(i);
            char c = s.charAt(i + 1);
            if (a > b && b < c)
                w++;
            if (a < b && b > c)
                w++;
        }
        return w;

    }
}