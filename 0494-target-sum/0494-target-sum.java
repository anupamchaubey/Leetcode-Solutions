class Solution {
    HashMap<String, Integer> hm;

    public int findTargetSumWays(int[] nums, int target) {
        hm = new HashMap<>();
        int sum = 0;
        for (int x : nums)
            sum += x;
        return rec(nums, target, 0);
    }

    int rec(int[] nums, int target, int idx) {
        if (idx == nums.length) {
            return (target == 0) ? 1 : 0;
        }
        String str = target + "-" + idx;
        if (hm.containsKey(str))
            return hm.get(str);
        int cnt = 0;
        cnt += rec(nums, target + nums[idx], idx + 1);
        cnt += rec(nums, target - nums[idx], idx + 1);
        hm.put(str, cnt);
        return cnt;
    }
}