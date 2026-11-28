class Solution {
    public int characterReplacement(String s, int k) {
        int n = s.length();
        int l = 0;
        int max = 0;
        int maxFreq = 0;
        int[] freq = new int[26];

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            freq[ch - 'A']++;
            maxFreq = Math.max(maxFreq, freq[ch - 'A']);
            if ((i - l + 1) - maxFreq > k) {
                freq[s.charAt(l) - 'A']--;
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}