class Solution {
    //GREEDY SOLUTION
    //WHEN U REACH THE END OF CURRENT JUMP RANGE, U MUST JUMP AND EXTEND THE RANGE TO THE FARTHEST REACHABLE INDEX

    public int jump(int[] nums) {
        
        int currmax=0, jumps=0, farthest=0;

        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest, nums[i]+i);
            if(i==currmax){
                currmax=farthest;
                jumps++;
            }
        }
        return jumps;
    }
}