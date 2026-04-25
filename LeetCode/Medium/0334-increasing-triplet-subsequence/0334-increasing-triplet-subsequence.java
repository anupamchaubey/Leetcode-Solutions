class Solution {
    public boolean increasingTriplet(int[] nums) {
        if(nums.length<3)return false;
        int first=Integer.MAX_VALUE, second=Integer.MAX_VALUE;
        for(int x:nums){
            if(x<first){
                first=x;
            }else if(x<second){
                second=x;
            }else{
                return true;
            }
    }
        return false;
    }
}