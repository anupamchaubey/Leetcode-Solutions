class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String str : strs) {
            char[] arr = str.toCharArray();
            Arrays.sort(arr);
            String s = new String(arr);
            hm.putIfAbsent(s, new ArrayList<>());
            hm.get(s).add(str);
        }
        List<List<String>> ls = new ArrayList(hm.values());
        return ls;
    }
}