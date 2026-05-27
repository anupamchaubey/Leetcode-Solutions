class Solution {
    public int numberOfSpecialChars(String word) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            if (ch >= 'a' && ch <= 'z') {
                hm.put(ch, i);
            } else {
                if (!hm.containsKey(ch)) {
                    hm.put(ch, i);
                }
            }
        }
        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char up = Character.toUpperCase(ch);
            if (hm.containsKey(ch) && hm.containsKey(up)) {
                if (hm.get(ch) < hm.get(up))
                    count++;
            }
        }
        return count;
    }
}