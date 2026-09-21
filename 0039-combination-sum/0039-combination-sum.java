class Solution {
    List<List<Integer>> ans;

    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        ans = new ArrayList<>();
        rec(candidates, target, 0, 0, new ArrayList<>());
        return ans;
    }

    void rec(int[] arr, int target, int sum, int idx, List<Integer> ls) {
        if (idx == arr.length)
            return;
        if (sum > target)
            return;
        if (sum == target) {
            ans.add(new ArrayList<>(ls));
            return;
        }
        ls.add(arr[idx]);
        rec(arr, target, sum + arr[idx], idx, ls);
        ls.remove(ls.size() - 1);
        rec(arr, target, sum, idx + 1, ls);
    }
}