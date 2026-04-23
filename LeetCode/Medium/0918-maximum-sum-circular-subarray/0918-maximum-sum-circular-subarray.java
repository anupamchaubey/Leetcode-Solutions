class Solution {
    public int maxSubarraySumCircular(int[] nums) {
        int n=nums.length;
        int total=0;
        int max1=Integer.MIN_VALUE;
        for(int i=0;i<n;i++){
            int sum=0;
            for(int j=i;j<n;j++){
                sum+=nums[j];
                max1=Math.max(max1, sum);
            }
            total+=nums[i];
        }
        int max2=Integer.MIN_VALUE;
        int esum=0;
        for(int i=n-1;i>=0;i--){
            esum+=nums[i];
            int sum=0;
            for(int j=0;j<i;j++){
                sum+=nums[j];
                max2=Math.max(max2, sum+esum);
            }
        }
        return Math.max(max1, max2);
    }
}