class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int[] minIndex = new int[26];
        Arrays.fill(minIndex, -1);
        int[] maxIndex = new int[26];
        Arrays.fill(maxIndex, -1);
        for (int i = 0; i < s.length(); i++) {
            if (minIndex[s.charAt(i) - 'a'] == -1)
                minIndex[s.charAt(i) - 'a'] = i;
            maxIndex[s.charAt(i) - 'a'] = i;
        }
        List<int[]> ls = new ArrayList<>();
        for (char ch = 'a'; ch <= 'z'; ch++) {
            if (minIndex[ch - 'a'] == -1)
                continue;

            int l = minIndex[ch - 'a'];
            int r = maxIndex[ch - 'a'];
            boolean isValid = true;
            for (int i = l; i < r; i++) {
                char chi = s.charAt(i);
                if (minIndex[chi - 'a'] < l) {
                    isValid = false;
                    break;
                }
                r = Math.max(maxIndex[chi - 'a'], r);
            }
            if (isValid) {
                ls.add(new int[] { l, r });
            }

        }
        Collections.sort(ls, (a, b) -> {

            if (a[0] == b[0]) {
                return Integer.compare(b[0], a[0]);
            }
            return Integer.compare(a[1], b[1]);
        });
        List<String> ans = new ArrayList<>();
        int en = -1;
        for (int i = 0; i < ls.size(); i++) {
            if (en == -1) {
                ans.add(s.substring(ls.get(i)[0], ls.get(i)[1] + 1));
                en = ls.get(i)[1];
            } else {
                if (ls.get(i)[0] > en) {
                    ans.add(s.substring(ls.get(i)[0], ls.get(i)[1] + 1));
                    en = ls.get(i)[1];
                }
            }
        }
        return ans;
    }
}