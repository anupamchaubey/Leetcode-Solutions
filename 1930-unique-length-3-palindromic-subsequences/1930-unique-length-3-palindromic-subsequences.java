class Solution {
    public int countPalindromicSubsequence(String s) {

        int count = 0;
        for (char ch = 'a'; ch <= 'z'; ch++) {
            int first = -1, last = -1;
            HashSet<Character> hs = new HashSet<>();

            for (int i = 0; i < s.length(); i++) {
                if (s.charAt(i) == ch) {
                    if (first == -1)
                        first = i;
                    last = i;
                }
            }

            if (first != -1 && first < last) {
                for (int i = first + 1; i < last; i++) {
                    hs.add(s.charAt(i));
                }
            }
            count += hs.size();
        }
        return count;
    }
}