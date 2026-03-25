class Solution {
    //GREEDY SOLUTION
    //WHEN U REACH THE END OF CURRENT JUMP RANGE, U MUST JUMP AND EXTEND THE RANGE TO THE FARTHEST REACHABLE INDEX
    
    public int jump(int[] nums) {
        int jumps=0;
        int end=0;
        int farthest=0;
        //NEVER NEED TO JUMP FROM LAST INDEX SO TILL N-2
        for(int i=0;i<nums.length-1;i++){
            farthest=Math.max(farthest, i+nums[i]);

            if(i==end){
                jumps++;
                end=farthest;
            }
        }
        return jumps;
    }
}