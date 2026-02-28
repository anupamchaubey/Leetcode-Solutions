class Solution {
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int val = 0;

        for (int i : nums) {
            val += i;
        }
        if (val % k != 0)
            return false;
        val /= k;
        int[] arr = new int[k];
        Arrays.sort(nums);
        return rec(nums, arr, 0, val);
    }

    boolean rec(int[] nums, int[] arr, int idx, int target) {
        if (idx >= nums.length) {
            boolean ans = true;
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != target)
                    ans = false;
            }
            return ans;
        }
        for (int i = arr.length - 1; i >= 0; i--) {
            if(arr[i]+nums[idx]>target)continue;
            arr[i] += nums[idx];
            
            boolean ans = rec(nums, arr, idx + 1, target);
            if (ans)
                return ans;
            arr[i] -= nums[idx];
            // important pruning
            if (arr[i] == 0) break;
        }
        return false;
    }
}