class Solution {
    Set<List<Integer>> ans;

    public List<List<Integer>> findSubsequences(int[] nums) {
        ans = new HashSet<>();
        rec(nums, 0, -1, new ArrayList<>());
        List<List<Integer>> ls = new ArrayList<>(ans);
        return ls;
    }

    void rec(int[] nums, int idx, int prev, List<Integer> ls) {
        if (idx == nums.length) {
            if (ls.size() >= 2)
                ans.add(new ArrayList<>(ls));
            return;
        }
        if (prev == -1 || nums[idx] >= nums[prev]) {
            ls.add(nums[idx]);
            rec(nums, idx + 1, idx, ls);
            ls.remove(ls.size() - 1);// ls.size()-1 is primitive but auto wrapped into Integer and element at index ls.size()-1 removed
        }
        rec(nums, idx + 1, prev, ls);
    }
}