class Solution {
    public int numDecodings(String s) {
        Integer[] dp = new Integer[s.length()];
        return rec(s, 0, dp);
    }
    int rec(String s, int idx, Integer[] dp){
        if(idx>s.length())return 0;
        if(idx==s.length())return 1;
        if(s.charAt(idx)=='0')return 0;
        if(dp[idx]!=null)return dp[idx];
        int c=0;
        if(s.charAt(idx)=='1'){
            c+=rec(s, idx+1, dp);
            c+=rec(s, idx+2, dp);
        }else if(idx+1<s.length() && s.charAt(idx)=='2' && s.charAt(idx+1)<='6'){
            c+=rec(s, idx+1, dp);
            c+=rec(s, idx+2, dp);
        }else{
            c+=rec(s, idx+1, dp);
        }
        return dp[idx]= c;
    }
}