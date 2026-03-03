class Solution {
    // Dynamic Programming
    public int maxProduct(int[] nums) {
        int maxSoFar=nums[0];
        int minTillHere=nums[0];
        int maxTillHere=nums[0];
        for(int i=1;i<nums.length;i++){
            int curr=nums[i];
            int tempMax=Math.max(curr, Math.max(curr*minTillHere, curr*maxTillHere));
            int tempMin=Math.min(curr, Math.min(curr*minTillHere, curr*maxTillHere));
            minTillHere=tempMin;
            maxTillHere=tempMax;
            maxSoFar=Math.max(maxSoFar, maxTillHere);
        }
        return maxSoFar;
    }
}