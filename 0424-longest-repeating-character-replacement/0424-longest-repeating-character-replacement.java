class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int l = 0, r = 0;
        int ans = 0;
        while (r < s.length()) {
            hm.put(s.charAt(r), hm.getOrDefault(s.charAt(r), 0) + 1);
            int len = r - l + 1;
            int max = 0;
            for (char ch = 'A'; ch <= 'Z'; ch++)
                max = Math.max(max, hm.getOrDefault(ch, 0));
            int other = len - max;
            if (other > k) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }
            ans = Math.max(ans, r - l + 1);
            r++;
        }
        return ans;
    }
}