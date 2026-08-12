class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        int max = 0;
        int l = 0;
        HashMap<Integer, Integer> hm = new HashMap<>();

        for (int i = 0; i < nums.length; i++) {
            hm.put(nums[i], hm.getOrDefault(nums[i], 0) + 1);
            while (hm.get(nums[i]) > k) {
                hm.put(nums[l], Math.max(hm.get(nums[l]) - 1, 0));
                l++;
            }
            max = Math.max(max, i - l + 1);
        }
        return max;
    }
}