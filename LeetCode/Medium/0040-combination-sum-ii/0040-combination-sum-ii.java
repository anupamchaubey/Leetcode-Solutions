class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum2(int[] nums, int target) {
        Arrays.sort(nums);
        ans = new ArrayList<>();
        rec(nums, target, 0, new ArrayList<>());
        return ans;
    }

    void rec(int[] nums, int target, int idx, List<Integer> ls) {
        if (target == 0) {
            ans.add(new ArrayList<>(ls));   
            return;
        }
        for (int i = idx; i < nums.length; i++) {

            if(i>idx && nums[i]==nums[i-1])continue;

            if(nums[i]>target)break;

            ls.add(nums[i]);
            rec(nums, target - nums[i], i + 1, ls);
            ls.remove(ls.size() - 1);

        }
    }

}