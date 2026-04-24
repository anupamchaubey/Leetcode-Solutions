class Solution {
    public int findMaxLength(int[] nums) {
        HashMap<Integer, Integer> hm = new HashMap<>();
        hm.put(0, -1);
        int max=0;
        int one=0;
        int zero=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==0)zero++;
            else one++;
            int diff=one-zero;
            if(hm.containsKey(diff)){
                max=Math.max(max, i-hm.get(diff));
            }
            if(!hm.containsKey(diff)){
                hm.put(diff, i);
            }
        }
        return max;
    }
}