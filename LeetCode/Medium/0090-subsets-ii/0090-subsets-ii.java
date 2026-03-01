class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(nums, 0, new ArrayList<>());
        return ans;
    }

    void rec(int[] nums, int idx, List<Integer> ls) {
        if (idx == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        ls.add(nums[idx]);

        int i = idx + 1;
        rec(nums, idx+1, ls);
        
        ls.remove(ls.size() - 1);
        while (i < nums.length && nums[i] == nums[idx]) {
            i++;
        }
        
       
        
        rec(nums, i, ls);
    }
}