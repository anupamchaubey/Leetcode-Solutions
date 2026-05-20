class Solution {
    public int numDecodings(String s) {
        int[] dp=new int[s.length()];
        Arrays.fill(dp, -1);
        return rec(s, 0, dp);
    }
    int rec(String s, int idx, int[] dp){
        if(idx==s.length())return 1;
        if(idx>s.length())return 0;
        if(s.charAt(idx)=='0')return 0;

        if(dp[idx]!=-1)return dp[idx];

        int ans=rec(s, idx+1, dp);
        if(s.charAt(idx)=='1'){
            ans+=rec(s, idx+2, dp);
        }
        if(idx+1<s.length() && s.charAt(idx)=='2' && s.charAt(idx+1)<='6'){
            ans+=rec(s, idx+2, dp);
        }
        return dp[idx]=ans;
    }
}