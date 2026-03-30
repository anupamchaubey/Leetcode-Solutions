class Solution {
    Integer[][] dp;
    public int longestCommonSubsequence(String s1, String s2) {
        dp=new Integer[s1.length()][s2.length()];
        return rec(s1, s2, 0, 0);
    }
    int rec(String s1, String s2, int i, int j){
        if(i==s1.length() || j==s2.length())return 0;
        if(dp[i][j]!=null)return dp[i][j];
        int c=0;
        if(s1.charAt(i)==s2.charAt(j)){
            c=1+rec(s1, s2, i+1, j+1);
        }else{
            c=Math.max(rec(s1, s2, i+1, j), rec(s1, s2, i, j+1));
        }
        return dp[i][j]=c;
    }
}