class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hm = new HashMap<>();
        for (String s : strs) {
            char[] arr = s.toCharArray();
            Arrays.sort(arr);
            String st = new String(arr);
            if (hm.containsKey(st)) {
                hm.get(st).add(s);
            } else {
                hm.put(st, new ArrayList<>());
                hm.get(st).add(s);
            }
        }
        List<List<String>> ans = new ArrayList<>();

        for (List<String> ls : hm.values()) {
            ans.add(ls);
        }
        return ans;
    }
}