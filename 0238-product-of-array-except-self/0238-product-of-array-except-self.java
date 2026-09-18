class Solution {
    public int[] productExceptSelf(int[] nums) {
        // in O(1) extra space complexity
        int[] output = new int[nums.length];

        int left = 1;
        for (int i = 0; i < nums.length; i++) {
            output[i] = 1;
            output[i] = left;
            left *= nums[i];
        }

        int right = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            output[i] *= right;
            right *= nums[i];
        }

        return output;
    }
}