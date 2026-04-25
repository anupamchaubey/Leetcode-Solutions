class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<Integer>> hm= new HashMap<>();

        for(int i=0;i<strs.length;i++){
            String str=strs[i];
            char[] arr=str.toCharArray();
            Arrays.sort(arr);
            String s=new String(arr);
            if(hm.containsKey(s)){
                hm.get(s).add(i);
            }
            else{
                hm.put(s, new ArrayList<>());
                hm.get(s).add(i);
            }
        }
        List<List<String>> ls= new ArrayList<>();
        for(List<Integer> list: hm.values()){
            List<String> ans=new ArrayList<>();
            for(int x:list){
                ans.add(strs[x]);
            }
            ls.add(ans);
        }
        return ls;
    }
}