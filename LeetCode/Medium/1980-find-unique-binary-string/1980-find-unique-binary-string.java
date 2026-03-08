class Solution {
    public String findDifferentBinaryString(String[] nums) {
        HashSet<String> hs = new HashSet<>(Arrays.asList(nums));
        List<String> ans= new ArrayList<>();
        
        backtrack(nums.length,ans,new StringBuilder(),hs);
        
        return ans.get(0);

    }
    void backtrack(int n,List<String> ls,StringBuilder sb,Set<String> hs){
        if(sb.length()==n){
            if(!hs.contains(sb.toString()))ls.add(sb.toString());
            return;
        }

        for(int i=0;i<=1;i++){
            sb.append(i);
            backtrack(n,ls,sb,hs);
            sb.deleteCharAt(sb.length()-1);
        }

    }
}