class Solution {
    public int characterReplacement(String s, int k) {
        int[] arr = new int[26];
        int maxLen = 0;
        int l = 0;
        int maxFreq = 0;

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            arr[ch - 'A']++;

            maxFreq = Math.max(maxFreq, arr[ch - 'A']);

            if (i - l + 1 - maxFreq > k) {
                arr[s.charAt(l) - 'A']--;
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);

        }
        return maxLen;
    }
}