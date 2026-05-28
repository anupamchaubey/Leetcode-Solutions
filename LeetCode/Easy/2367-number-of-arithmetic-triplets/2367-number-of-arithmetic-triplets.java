class Solution {
    public int arithmeticTriplets(int[] nums, int diff) {
        int count = 0;
        int k = nums.length - 1;
        while (k >= 2) {
            int j = k - 1;
            while (j>0 && nums[k] - nums[j] < diff)
                j--;
            if (nums[k] - nums[j] != diff) {
                k--;
                continue;
            }
            for (int i = 0; i < j; i++) {
                if (nums[j] - nums[i] == diff)
                    count++;
            }
            k--;
        }
        return count;
    }
}