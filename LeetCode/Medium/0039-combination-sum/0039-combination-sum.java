class Solution {
    List<List<Integer>> ans;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        ans=new ArrayList<>();
        rec(nums, 0, new ArrayList<>(), target);
        return ans;
    }
    void rec(int[] nums, int idx, List<Integer> ls, int target){
        if(target==0){
            ans.add(new ArrayList<>(ls));
            return;
        }
        if(idx==nums.length || target<0){
            return;
        }
        ls.add(nums[idx]);
        rec(nums, idx, ls, target-nums[idx]);
        ls.remove(ls.size()-1);
        rec(nums, idx+1, ls, target);
    }
}