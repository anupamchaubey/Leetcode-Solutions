class Solution {
    public int numberOfSpecialChars(String word) {
        HashSet<Character> hs = new HashSet<>();
        for (char ch : word.toCharArray()) {
            hs.add(ch);
        }
        int cnt = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            char l = Character.toLowerCase(ch);
            char u = Character.toUpperCase(ch);
            if (hs.contains(u) && hs.contains(l))
                cnt++;
        }
        return cnt;
    }
}