class Solution {
    //GREEDY SOLUTION
    //WHEN U REACH THE END OF CURRENT JUMP RANGE, U MUST JUMP AND EXTEND THE RANGE TO THE FARTHEST REACHABLE INDEX
    
    public int jump(int[] nums) {
        //NEVER NEED TO JUMP FROM LAST INDEX SO TILL N-2
        int jumps=0;
        int farthest=0;
        int currEnd=0;
        for(int i=0;i<nums.length;i++){
            
            if(i>currEnd){
                jumps++;
                currEnd=farthest;
            }
            farthest=Math.max(farthest, i+nums[i]);
        }
        return jumps;
    }
}