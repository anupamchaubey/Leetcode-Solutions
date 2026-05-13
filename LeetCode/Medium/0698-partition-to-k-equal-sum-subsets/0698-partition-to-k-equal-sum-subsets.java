class Solution {
    int sum;
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int totalsum = 0;
        for (int x : nums)
            totalsum += x;
        if (totalsum % k != 0)
            return false;
        sum = totalsum / k;
        int[] arr = new int[k];
        Arrays.sort(nums);
        reverse(nums);
        if(nums[0]>sum)return false;
        return rec(nums, arr, 0);
    }
    void reverse(int[] nums){
        int i=0, j=nums.length-1;
        while(i<j){
            int temp=nums[i];
            nums[i]=nums[j];
            nums[j]=temp;
            i++;
            j--;
        }
    }

    boolean rec(int[] nums, int[] arr, int idx) {
        if (idx == nums.length) {
            for (int i = 0; i < arr.length; i++) {
                if (arr[i] != sum)
                    return false;
            }
            return true;
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] + nums[idx] > sum)
                continue;
            arr[i] += nums[idx];
            if (rec(nums, arr, idx + 1))
                return true;
            arr[i] -= nums[idx];
            if(arr[i]==0)break;
        }
        return false;
    }
}