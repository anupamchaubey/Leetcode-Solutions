class Solution {
    HashMap<String, Integer> hm;

    public int minRemovals(int[] nums, int target) {
        hm = new HashMap<>();
        int res = rec(nums, 0, target, 0);
        if (res == Integer.MAX_VALUE / 3)
            return -1;
        return res;
    }

    int rec(int[] nums, int idx, int target, int xor) {
        if (idx == nums.length) {
            if (xor == target)
                return 0;
            else
                return Integer.MAX_VALUE / 3;
        }
        String s = idx + "-" + xor;
        if (hm.containsKey(s))
            return hm.get(s);
        int minRemovals = Integer.MAX_VALUE / 3;

        minRemovals = Math.min(minRemovals, 1 + rec(nums, idx + 1, target, xor));
        minRemovals = Math.min(minRemovals, rec(nums, idx + 1, target, xor ^ nums[idx]));
        hm.put(s, minRemovals);
        return minRemovals;
    }
}