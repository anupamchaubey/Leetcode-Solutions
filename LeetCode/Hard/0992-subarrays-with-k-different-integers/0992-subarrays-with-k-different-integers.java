class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        // exactly(k) = atmost(nums, k) - atmost(nums, k-1)
        return atmost(nums, k)-atmost(nums, k-1);
    }
    int atmost(int[] nums, int k){
        if(k<0)return 0;
        HashMap<Integer, Integer> hm=new HashMap<>();
        int l=0;
        int count=0;
        for(int i=0;i<nums.length;i++){
            hm.put(nums[i], hm.getOrDefault(nums[i], 0)+1);
            while(hm.size()>k){
                hm.put(nums[l], hm.get(nums[l])-1);
                if(hm.get(nums[l])==0)hm.remove(nums[l]);
                l++;
            }
            count+=(i-l+1);
        }
        return count;
    }
}