class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            int[] freq = new int[26];
            for (char ch : str.toCharArray()) {
                freq[ch - 'a']++;
            }
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i < 26; i++) {
                sb.append(freq[i]).append('#');
            }
            String key = sb.toString();
            hm.putIfAbsent(key, new ArrayList<>());
            hm.get(key).add(str);
        }
        List<List<String>> ans = new ArrayList<>();
        for (List<String> ls : hm.values()) {
            ans.add(ls);
        }
        return ans;
    }
}