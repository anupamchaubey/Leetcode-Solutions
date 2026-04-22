class Solution {
    HashMap<String, Integer> hm;
    public int findTargetSumWays(int[] nums, int target) {
        hm=new HashMap<>();
        return rec(nums, 0, target);
    }
    int rec(int[] nums, int idx, int target){
        if(idx==nums.length){
            if(target==0)return 1;
            return 0;
        }
        String key=idx+"-"+target;
        if(hm.containsKey(key))return hm.get(key);
        int count=0;
        count+=rec(nums, idx+1, target-nums[idx]);
        count+=rec(nums, idx+1, target+nums[idx]);
        hm.put(key, count);
        return count;
    }
}