class Solution {
    public long maxTotalValue(int[] nums, int k) {
        long min=Long.MAX_VALUE;
        long max=Long.MIN_VALUE;
        for(int i: nums){
            if(i<min)min=i;
            if(i>max)max=i;
        }
        long ans=max-min;
        return ans*k;
    }
}