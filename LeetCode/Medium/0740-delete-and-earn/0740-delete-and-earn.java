class Solution {
    public int deleteAndEarn(int[] nums) {
        int n=0;
        for(int x:nums)n=Math.max(x, n);
        int[] points=new int[n+1];
        for(int x:nums){
            points[x]+=x;
        }
        int prev1=points[0];
        int prev2=0;
        for(int i=1;i<n+1;i++){
            int curr=Math.max(points[i]+prev2, prev1);
            prev2=prev1;
            prev1=curr;
        }
        return prev1;
    }
}