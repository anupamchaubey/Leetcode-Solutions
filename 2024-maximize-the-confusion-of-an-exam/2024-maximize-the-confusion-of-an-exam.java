class Solution {
    public int maxConsecutiveAnswers(String s, int k) {
        int trueFreq = 0, falseFreq = 0;
        int maxFreq = 0;
        int l = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == 'T')
                trueFreq++;
            else
                falseFreq++;
            maxFreq = Math.max(trueFreq, falseFreq);

            if (i - l + 1 - maxFreq > k) {
                if (s.charAt(l) == 'T')
                    trueFreq--;
                else
                    falseFreq--;
                l++;
            }

            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}