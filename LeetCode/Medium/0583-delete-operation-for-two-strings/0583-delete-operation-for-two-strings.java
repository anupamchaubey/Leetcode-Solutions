class Solution {
    Integer[][] dp;
    public int minDistance(String s1, String s2) {
        dp=new Integer[s1.length()][s2.length()];
        return rec(s1, s2, 0, 0);
    }
    int rec(String s1, String s2, int i, int j){
        if(i==s1.length()){
            return s2.length()-j;
        }
        if(j==s2.length()){
            return s1.length()-i;
        }
        if(dp[i][j]!=null)return dp[i][j];
        int min;
        if(s1.charAt(i)==s2.charAt(j)){
            min = rec(s1, s2, i+1, j+1);
        }else{
            int x=1+rec(s1, s2, i+1, j);
            int y=1+rec(s1, s2, i, j+1);
            min=Math.min(x, y);
        }
        return dp[i][j]= min;
    }
}