class Solution {
    int[] houses;
    int[][] costs;
    int m;
    int n;
    int target;
    Integer[][][] dp;
    public int minCost(int[] houses, int[][] cost, int m, int n, int target) {
        this.houses=houses;
        this.costs=cost;
        this.m=m;
        this.n=n;
        this.target=target;
        dp= new Integer[m][n+1][target+1];
        int ans=rec(0, 0, 0);
        return ans==Integer.MAX_VALUE/2? -1 : ans;
    }
    int rec(int idx, int prev, int nei){
        if(nei>target)return Integer.MAX_VALUE/2;

        if(idx==m){
            if(nei==target)return 0;
            else return Integer.MAX_VALUE/2;
        }
        if(dp[idx][prev][nei]!=null)return dp[idx][prev][nei];
        int cost=Integer.MAX_VALUE/2;
        if(houses[idx]!=0){
            int newnei=nei;
            if(houses[idx]!=prev)newnei++;
            cost=rec(idx+1, houses[idx], newnei);
        }else{
            for(int i=1;i<=n;i++){
                int newnei=nei;
                if(i!=prev)newnei++;

                int currentCost=costs[idx][i-1]+rec(idx+1, i, newnei);
                cost=Math.min(cost, currentCost);
            }
        }
        return dp[idx][prev][nei]=cost;
    }
}