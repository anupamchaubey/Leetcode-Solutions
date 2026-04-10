class Solution {
    public int minimumDistance(int[] nums) {
        int ans=Integer.MAX_VALUE;
        for(int i=0;i<nums.length;i++){
            int sum=0;
            int sec=-1;
            for(int j=i+1;j<nums.length;j++){
                if(nums[j]==nums[i]){
                    if(sec!=-1){
                        sum+=Math.abs(sec-j);
                        sum+=Math.abs(j-i);
                        ans=Math.min(ans,sum);
                    }
                    else{
                        sum+=Math.abs(i-j);
                    sec=j;
                    }
                }
            }
        }
        return ans==Integer.MAX_VALUE? -1: ans;
    }
}