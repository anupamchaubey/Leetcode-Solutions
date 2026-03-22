class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return atmost(nums, k)-atmost(nums, k-1);
    }
    int atmost(int[] nums, int k){
        HashMap<Integer, Integer> hm=new HashMap<>();
        int l=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            while(hm.size()>k){
                int x=nums[l];
                hm.put(x, hm.get(x)-1);
                if(hm.get(x)==0)hm.remove(x);
                l++;
            }
            count+=i-l+1;
        }
        return count;
    }
}