class Solution {
    Integer[] dp;
    public int numDecodings(String s) {
        if(s.charAt(0)=='0')return 0;
        dp= new Integer[s.length()];
        return rec(s, 0);
    }
    int rec(String s, int idx){
        if(idx>s.length())return 0;
        if(idx==s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        if(dp[idx]!=null)return dp[idx];
        int c=rec(s, idx+1);
        if(idx+1<s.length()){
            int val=Integer.parseInt(s.substring(idx, idx+2));
            if(val>=10 && val<=26){
                c+=rec(s, idx+2);
            }
        }
        return dp[idx]= c;
    }
}