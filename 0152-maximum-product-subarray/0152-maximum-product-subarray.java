class Solution {
    public int maxProduct(int[] nums) {
        int max = nums[0];
        int maxTillHere = nums[0];
        int minTillHere = nums[0];

        //in this for loop, 
        //every time we introduce a new element, we have three choices, 
        //start a new subarray for product
        //multiply the current element with minimum till now 
        //multiply the current element with maximum till now
        // we will take the maximum of these three each time we introduce a new element and store it in max which will be our result

        for (int i = 1; i < nums.length; i++) {
            int currMax = Math.max(maxTillHere * nums[i], minTillHere * nums[i]);
            int currMin = Math.min(minTillHere * nums[i], maxTillHere * nums[i]);
            max = Math.max(max, Math.max(nums[i], currMax));
            maxTillHere = Math.max(currMax, nums[i]);
            minTillHere = Math.min(currMin, nums[i]);
        }
        return max;
    }

}