class Solution {
    public int maxConsecutiveAnswers(String answerKey, int k) {
        return atMost(answerKey, k);
    }

    int atMost(String s, int k) {
        int ans = 0;
        int maxFreq = 0;
        int tr = 0, fa = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T')
                tr++;
            else
                fa++;
            maxFreq = Math.max(tr, fa);
            while (i - l + 1 - maxFreq > k) {
                if (s.charAt(l) == 'T')
                    tr--;
                else
                    fa--;
                l++;
            }
            ans = Math.max(ans, i - l + 1);
        }
        return ans;
    }
}