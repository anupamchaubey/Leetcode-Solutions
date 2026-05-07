class Solution {
    public int minPairSum(int[] nums) {
        
        Arrays.sort(nums);

        int max=-1;

        int i=0, j=nums.length-1;
        while(i<j){
            int sum=nums[i]+nums[j];
            max=Math.max(max, sum);
            i++;
            j--;
        }
        return max;
    }
}