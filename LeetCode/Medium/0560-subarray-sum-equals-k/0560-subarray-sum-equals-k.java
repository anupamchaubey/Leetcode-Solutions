class Solution {
    public int subarraySum(int[] nums, int k) {
        int n = nums.length;
        int count = 0;
        
        HashMap<Integer, Integer> hm= new HashMap<>();
        hm.put(0, 1);
        int prefixsum=0;
        for(int i=0;i<n;i++){
            prefixsum+=nums[i];
            hm.put(prefixsum, hm.getOrDefault(prefixsum, 0)+1);
            if(hm.containsKey(prefixsum-k))count+=hm.get(prefixsum-k);
            
        }

        return count;

    }
}