class Solution {
    public int maxDistinctElements(int[] nums, int k) {
        
        Arrays.sort( nums);
        int count=1;
        int curr=nums[0]-k;
        for(int i=1;i<nums.length;i++){
            int st=nums[i]-k;
            int en=nums[i]+k;
            
            int val=Math.max(curr+1, st);

            if(val<=en){
                curr=val;
                count++;
            }
        }
        return count;
    }
}