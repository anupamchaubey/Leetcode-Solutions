class Solution {
    public int maxSubarrayLength(int[] nums, int k) {
        return atmost(nums, k);
    }
    int atmost(int[] nums, int k){
        HashMap<Integer, Integer> hm= new HashMap<>();
        int max=0;
        int l=0;
        for(int r=0;r<nums.length;r++){
            hm.put(nums[r], hm.getOrDefault(nums[r], 0)+1);
            while(hm.get(nums[r])>k){
                hm.put(nums[l], hm.get(nums[l])-1);
                if(hm.get(nums[l])==0)hm.remove(nums[l]);
                l++;
            }
            max=Math.max(max, r-l+1);
        }
        return max;
    }

}