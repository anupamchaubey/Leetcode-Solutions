class Solution {
    List<List<Integer>> hs;

    public List<List<Integer>> subsetsWithDup(int[] nums) {
        Arrays.sort(nums);

        hs = new ArrayList<>();
        rec(nums, 0, new ArrayList<>());
        return hs;
    }

    void rec(int[] nums, int idx, List<Integer> ls) {
        if (idx == nums.length) {
            hs.add(new ArrayList<>(ls));
            return;
        }

        ls.add(nums[idx]);

        rec(nums, idx + 1, ls);

        ls.remove(ls.size() - 1);

        int i = idx + 1;
        while (i < nums.length && nums[i] == nums[idx])
            i++;

        rec(nums, i, ls);
    }
}