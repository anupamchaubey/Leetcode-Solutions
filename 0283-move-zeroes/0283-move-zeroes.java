class Solution {
    public void moveZeroes(int[] nums) {
        int k = -1;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != 0) {
                int temp = nums[k + 1];
                nums[k + 1] = nums[i];
                nums[i] = temp;
                k++;
            }
        }
    }
}