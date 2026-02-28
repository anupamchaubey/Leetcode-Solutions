class Solution {
    int max = 0;

    public int maxScoreWords(String[] words, char[] letters, int[] score) {
        HashMap<Character, Integer> hm = new HashMap<>();
        for (char ch : letters) {
            hm.put(ch, hm.getOrDefault(ch, 0) + 1);
        }
        backtrack(words, 0, score, 0, hm);
        return max;
    }

    void backtrack(String[] words, int idx, int[] score, int profit, HashMap<Character, Integer> hm) {

        if (idx >= words.length) {
            max = Math.max(profit, max);
            return;
        }

        if (isValid(words[idx], hm)) {
            //take
            char[] arr = words[idx].toCharArray();
            int pr = 0;
            for (char ch : arr) {
                pr += score[ch - 'a'];
                hm.put(ch, hm.get(ch) - 1);
            }
            backtrack(words, idx + 1, score, profit + pr, hm);
            for (char ch : arr) {
                hm.put(ch, hm.get(ch) + 1);
            }
        }
        //nontake
        backtrack(words, idx + 1, score, profit, hm);
    }

    boolean isValid(String s, HashMap<Character, Integer> hm) {
        int[] cha = new int[26];
        for (char ch : s.toCharArray()) {
            cha[ch - 'a']++;
        }
        for (int i = 0; i < 26; i++) {
            if (cha[i] > 0) {
                char ch = (char) (i + 'a');
                if (!hm.containsKey(ch))
                    return false;
                if (hm.get(ch) < cha[i])
                    return false;
            }
        }
        return true;
    }
}