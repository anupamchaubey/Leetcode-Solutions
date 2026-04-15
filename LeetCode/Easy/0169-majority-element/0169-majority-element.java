class Solution {
    public int majorityElement(int[] nums) {
        HashSet<Integer> hs= new HashSet<>();

        int n=nums.length;
        for(int i=0;i<n;i++){

            int x=nums[i];
            if(hs.contains(x))continue;
            int cnt=0;
            for(int j=0;j<n;j++){
                if(nums[j]==x)cnt++;
                if(cnt>(n/2))return x;
            }
            hs.add(x);
        }
        return -1;
    }
}