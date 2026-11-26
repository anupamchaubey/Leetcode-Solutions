class Solution {
    public int[] productExceptSelf(int[] nums) {
        int[] arr = new int[nums.length];
        Arrays.fill(arr, 1);
        int curr = 1;
        for (int i = 0; i < nums.length; i++) {
            arr[i] *= curr;
            curr *= nums[i];
        }
        curr = 1;
        for (int i = nums.length - 1; i >= 0; i--) {
            arr[i] *= curr;
            curr *= nums[i];
        }
        return arr;
    }
}