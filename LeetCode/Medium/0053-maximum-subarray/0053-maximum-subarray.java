 class Solution {

    public  int maxSubArray(int[] nums) {
        return findMaxSum(nums, 0, nums.length - 1);
    }

    private  int findMaxSum(int[] nums, int left, int right) {
        // Base Case: Only one element
        if (left == right) {
            return nums[left];
        }

        int mid = left + (right - left) / 2;

        // Recursively find the max in the left and right halves
        int leftMax = findMaxSum(nums, left, mid);
        int rightMax = findMaxSum(nums, mid + 1, right);
        
        // Find the max sum that crosses the midpoint
        int crossMax = findCrossingSum(nums, left, mid, right);

        // Return the best of the three
        return Math.max(Math.max(leftMax, rightMax), crossMax);
    }

    private  int findCrossingSum(int[] nums, int left, int mid, int right) {
        // Find max sum starting from mid and moving left
        int sum = 0;
        int leftPartMax = Integer.MIN_VALUE;
        for (int i = mid; i >= left; i--) {
            sum += nums[i];
            if (sum > leftPartMax) {
                leftPartMax = sum;
            }
        }

        // Find max sum starting from mid + 1 and moving right
        sum = 0;
        int rightPartMax = Integer.MIN_VALUE;
        for (int i = mid + 1; i <= right; i++) {
            sum += nums[i];
            if (sum > rightPartMax) {
                rightPartMax = sum;
            }
        }

        return leftPartMax + rightPartMax;
    }

    
}