class Solution {
    HashSet<List<Integer>> hs = new HashSet<>();

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);
        rec(nums, 0, new ArrayList<>());
        List<List<Integer>> ans = new ArrayList<>(hs);
        return ans;
    }

    void rec(int[] nums, int idx, List<Integer> ls) {
        if (idx == nums.length) {
            if (!hs.contains(ls)) {
                hs.add(new ArrayList<>(ls));
            }
            return;
        }

        ls.add(nums[idx]);
        rec(nums, idx + 1, ls);
        int i = idx + 1;
        ls.remove(ls.size() - 1);
        while (i < nums.length && nums[i] == nums[idx])
            i++;

        rec(nums, idx + 1, ls);
    }
}