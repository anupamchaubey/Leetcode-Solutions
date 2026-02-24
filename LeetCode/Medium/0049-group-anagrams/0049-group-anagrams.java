class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> ans= new HashMap<>();
        for(String str: strs){
            char[] chars=str.toCharArray();
            Arrays.sort(chars);
            String key=new String(chars);
            if(!ans.containsKey(key)){
                ans.put(key, new ArrayList<>());
            }
            ans.get(key).add(str);
        }
        return new ArrayList<>(ans.values());
    }
    
}