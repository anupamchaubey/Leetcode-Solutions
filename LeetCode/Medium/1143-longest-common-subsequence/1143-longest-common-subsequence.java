class Solution {
    public int longestCommonSubsequence(String s1, String s2) {
        int[][] dp= new int[s1.length()+1][s2.length()+1];

        for(int i=1;i<=s1.length();i++){
            for(int j=1;j<=s2.length();j++){
                if(s1.charAt(i-1)==s2.charAt(j-1)){
                    dp[i][j]=dp[i-1][j-1]+1;
                }else{
                    int skip1=dp[i-1][j];
                    int skip2=dp[i][j-1];
                    dp[i][j]=Math.max(skip1, skip2);
                }
            }
        }
        return dp[s1.length()][s2.length()];
    }
    int lcs(String s1, String s2, int i, int j){
        if(i>=s1.length() || j>=s2.length())return 0;

        if(s1.charAt(i)==s2.charAt(j)){
            return 1+lcs(s1, s2, i+1, j+1);
        }else{
            int skip1=lcs(s1, s2, i+1, j);
            int skip2=lcs(s1, s2, i, j+1);
            return Math.max(skip1, skip2);
        }
    }
}