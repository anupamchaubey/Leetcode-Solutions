class Solution {
    public boolean canJump(int[] nums) {
        // you dont care how u reached a position, u only care whether it is reachable 
        // so instead of thinking forward from each index, think in terms of maximum reachable boundary
        int maxReachable=0;
        for(int i=0;i<nums.length;i++){
            //tum us index pe ho, jispe tum kabhi pohonch hi nhi skte...
            if(i>maxReachable)return false;
            maxReachable=Math.max(maxReachable, i+nums[i]);
        }
        return true;
    }
}