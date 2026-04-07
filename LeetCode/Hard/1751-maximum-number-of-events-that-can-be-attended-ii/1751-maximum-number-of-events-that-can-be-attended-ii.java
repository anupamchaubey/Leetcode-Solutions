class Solution {
    Integer[][] dp;

    public int maxValue(int[][] events, int k) {
        Arrays.sort(events, (a, b) -> a[0] - b[0]);
        dp=new Integer[events.length][k+1];
        return rec(events, k, 0, 0);
    }

    int rec(int[][] events, int k, int idx, int count) {

        if (idx == events.length)
            return 0;
        if (count >= k)
            return 0;
        if(dp[idx][count]!=null)return dp[idx][count];
        int st = events[idx][0];
        int en = events[idx][1];
        int value = events[idx][2];

        int take = 0;

        int index=binarySearch(events, idx+1, en);
        take = events[idx][2] + rec(events, k, index, count + 1);

        int nontake = rec(events, k, idx + 1, count);
        int ans = Math.max(take, nontake);
        
        return dp[idx][count] = ans;
    }
    int binarySearch(int[][] events, int st, int t){
        int left=st, right=events.length-1;
        int ans=events.length;
        while(left<=right){
            int mid=left+(right-left)/2;
            if(events[mid][0]>t){
                ans=mid;
                right=mid-1;
            }else{
                left=mid+1;
            }
        }
        return ans;
    }
}