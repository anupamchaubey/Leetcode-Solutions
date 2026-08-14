class Solution {
    public String minWindow(String s, String t) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : t.toCharArray()) {
            hm.put(ch, hm.getOrDefault(ch, 0) - 1);
        }
        int min = Integer.MAX_VALUE;
        int st = 0, en = 0;

        int val = -hm.size();
        int l = 0;
        for (int i = 0; i < s.length(); i++) {
            if (!hm.containsKey(s.charAt(i)))
                continue;
            hm.put(s.charAt(i), hm.get(s.charAt(i)) + 1);
            if (hm.get(s.charAt(i)) == 0)
                val++;
            while (val == 0) {
                if (hm.containsKey(s.charAt(l))) {
                    hm.put(s.charAt(l), hm.get(s.charAt(l)) - 1);
                    if (hm.get(s.charAt(l)) < 0)
                        val--;
                }
                if (i - l + 1 < min) {
                    min = i - l + 1;
                    st = l;
                    en = i + 1;
                }
                l++;
            }
        }
        return s.substring(st, en);
    }
}