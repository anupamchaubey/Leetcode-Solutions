class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        StringBuilder sb = new StringBuilder();
        for (String str : strs) {
            int[] freq = new int[26];
            for (char ch : str.toCharArray())
                freq[ch - 'a']++;
            sb.setLength(0);
            for (int i = 0; i < 26; i++) {
                sb.append(freq[i]).append('#');
            }
            hm.putIfAbsent(sb.toString(), new ArrayList<>());
            hm.get(sb.toString()).add(str);
        }
        return new ArrayList<>(hm.values());
    }
}