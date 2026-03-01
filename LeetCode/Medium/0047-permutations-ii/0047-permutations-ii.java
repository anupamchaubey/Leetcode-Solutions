class Solution {
    List<List<Integer>> ans = new ArrayList<>();

    public List<List<Integer>> permuteUnique(int[] nums) {
        boolean[] visited = new boolean[nums.length];
        Arrays.sort(nums);
        rec(nums, new ArrayList<>(), visited);
        return ans;
    }

    void rec(int[] nums, List<Integer> ls, boolean[] visited) {
        if (ls.size() == nums.length) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        for (int i = 0; i < nums.length; ) {
            if (!visited[i]) {
                visited[i] = true;
                ls.add(nums[i]);
                rec(nums, ls, visited);
                ls.remove(ls.size() - 1);
                visited[i] = false;
                int idx=i+1;
                while(idx<nums.length && nums[idx]==nums[i]){
                    idx++;
                }
                i=idx;
            }else{
                i++;
            }

        }
    }
}