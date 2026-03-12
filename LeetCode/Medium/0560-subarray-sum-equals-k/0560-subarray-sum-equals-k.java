class Solution {
    public int subarraySum(int[] nums, int k) {
        int n=nums.length;
        int[] prefix=new int[n];
        prefix[0]=nums[0];
        HashSet<Integer> hs=new HashSet<>();
        hs.add(0);
        hs.add(nums[0]);
        for(int i=1;i<n;i++){
            prefix[i]=prefix[i-1]+nums[i];
            hs.add(prefix[i]);
        }
        int count=0;
        for(int i=0;i<prefix.length;i++){
            if(hs.contains(prefix[i]-k))count++;
        }
        return count;

    }
}