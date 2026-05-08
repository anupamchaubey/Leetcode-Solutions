class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        Arrays.sort(nums);
        int n = nums.length;
        int prev = Integer.MIN_VALUE;
        int distinct = 0;

        for (int i = 0; i < n; i++) {
            int start = nums[i] - k;
            int end = nums[i] + k;
            int consume = Math.max(prev + 1, start);

            if (consume <= end) {
                distinct++;
                prev = consume;
            }
        }
        return distinct;
    }
}