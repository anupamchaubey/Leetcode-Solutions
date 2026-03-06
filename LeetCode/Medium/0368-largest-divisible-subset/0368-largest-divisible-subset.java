class Solution {
    public List<Integer> largestDivisibleSubset(int[] nums) {
        int n=nums.length;
        Arrays.sort(nums);
        
        int[] dp=new int[n];
        Arrays.fill(dp, 1);

        int max=0;
        int last=0;
        int[] parent=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            for(int j=0;j<i;j++){
                if(nums[j]%nums[i]==0 || nums[i]%nums[j]==0){
                    if(dp[j]+1>dp[i]){
                        dp[i]=dp[j]+1;
                        parent[i]=j;
                    }
                }
            }
            if(dp[i]>max){
                max=dp[i];
                last=i;
            }
        }
        List<Integer> ls= new ArrayList<>();
        ls.add(nums[last]);
        while(parent[last]!=last){
            ls.add(nums[parent[last]]);
            last=parent[last];
        }
        Collections.reverse(ls);
        return ls;
    }
}