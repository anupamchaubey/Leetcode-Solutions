class Solution {
    public int majorityElement(int[] nums) {
        int x=0;
        int freq=0;
        for(int i=0;i<nums.length;i++){
            if(x==nums[i])freq++;
            else{
                freq--;
                if(freq<0){
                    freq=1;
                    x=nums[i];
                }
            }
        }
        return x;
    }
}