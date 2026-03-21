class Solution {
    public int subarraysDivByK(int[] nums, int k) {
        HashMap<Integer, Integer> hm=new HashMap<>();
        hm.put(0, 1);
        int count=0;
        int sum=0;

        for(int i=0;i<nums.length;i++){
            sum+=nums[i];
            int key=((sum%k)+k)%k;
            if(hm.containsKey(key)){
                count+=hm.get(key);
            }
            hm.put(key, hm.getOrDefault(key, 0)+1);
        }
        return count;
    }
}