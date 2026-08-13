class Solution {
    public int characterReplacement(String s, int k) {
        return atmostK(s, k);
    }

    int atmostK(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0;
        int maxfreq = 0;
        int maxLen = 0;
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            maxfreq = Math.max(maxfreq, hm.get(s.charAt(i)));
            while (i - l + 1 - maxfreq > k) {
                hm.put(s.charAt(l), Math.max(0, hm.get(s.charAt(l)) - 1));
                l++;
            }
            maxLen = Math.max(maxLen, i - l + 1);
        }
        return maxLen;
    }
}