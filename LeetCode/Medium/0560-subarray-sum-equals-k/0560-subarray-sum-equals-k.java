class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        HashMap<Integer, Integer> hm= new HashMap<>();
        hm.put(0, 1);
        int count=0;
        int prefixsum=0;
        for(int x: nums){
            prefixsum+=x;
            if(hm.containsKey(prefixsum-k))count+=hm.get(prefixsum-k);
            hm.put(prefixsum, hm.getOrDefault(prefixsum, 0)+1);
        }
        return count;
    }
}