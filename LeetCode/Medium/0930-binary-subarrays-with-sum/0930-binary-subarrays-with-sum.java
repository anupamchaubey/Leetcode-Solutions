class Solution {
    public int numSubarraysWithSum(int[] nums, int goal) {
        int sum=0;
        int count=0;
        HashMap<Integer, Integer> hm= new HashMap<>();
        hm.put(0, 1);
        for(int r=0;r<nums.length;r++){
            sum+=nums[r];
            if(hm.containsKey(sum-goal)){
                count+=hm.get(sum-goal);
            }
            hm.put(sum, hm.getOrDefault(sum, 0)+1);
        }
        return count;

    }
    
}