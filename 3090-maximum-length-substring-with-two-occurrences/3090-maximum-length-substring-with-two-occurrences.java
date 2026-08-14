class Solution {
    public int maximumLengthSubstring(String s) {
        return atmostK(s);
    }

    int atmostK(String s) {
        HashMap<Character, Integer> hm = new HashMap<>();
        int max = 0;
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            hm.put(s.charAt(i), hm.getOrDefault(s.charAt(i), 0) + 1);
            while (hm.get(s.charAt(i)) > 2) {
                hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}