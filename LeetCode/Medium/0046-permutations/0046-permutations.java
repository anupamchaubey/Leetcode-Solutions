class Solution {
    List<List<Integer>> ans= new ArrayList<>();
    public List<List<Integer>> permute(int[] nums) {
        boolean[] visited= new boolean[nums.length];
        rec(nums, new ArrayList<>(), visited);
        return ans;
    }
    void rec(int[] nums, List<Integer> ls, boolean[] visited){
        if(ls.size()==nums.length){
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<nums.length;i++){
            if(!visited[i]){
                visited[i]=true;
                ls.add(nums[i]);
                rec(nums, ls, visited);
                ls.remove(ls.size()-1);
                visited[i]=false;
            }
        }
    }
}