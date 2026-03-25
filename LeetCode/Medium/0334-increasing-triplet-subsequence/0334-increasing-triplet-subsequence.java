class Solution {
    public boolean increasingTriplet(int[] nums) {
        int max1=Integer.MAX_VALUE;
        int max2=Integer.MAX_VALUE;
        for(int x:nums){
            if(x<=max1){
                max1=x;
            }else if(x<=max2){
                max2=x;
            }else{
                return true;
            }
        }
        return false;
    }
}