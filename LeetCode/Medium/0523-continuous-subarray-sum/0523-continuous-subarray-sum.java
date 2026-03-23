class Solution {
    public boolean checkSubarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm= new HashMap<>();
        hm.put(0, -1);
        int sum=0;
        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int rem=0;
            if(k==0)rem=sum;
            else rem=((sum%k)+k)%k;
            if(hm.containsKey(rem) && i-hm.get(rem)>=2)return true;
            if(!hm.containsKey(rem)){
                hm.put(rem, i);
            }
        }
        return false;
    }
}