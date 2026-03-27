class Solution {
    public int minCut(String s) {
        int n=s.length();
        boolean[][] pal= new boolean[n+1][n+1];
        for(int i=n-1;i>=0;i--){
            for(int j=i+1;j<=n;j++){
                int len=j-i;
                if(len==1){
                    pal[i][j]=true;
                }else if(len==2){
                    pal[i][j]=(s.charAt(i)==s.charAt(j-1));
                }else{
                    if(pal[i+1][j-1] && s.charAt(i)==s.charAt(j-1)){
                        pal[i][j]=true;
                    }
                }
            }
        }
        int[] dp= new int[n+1];
        dp[0]=-1;
        for(int i=1;i<=n;i++){
            dp[i]=Integer.MAX_VALUE;
            for(int j=0;j<i;j++){
                if(pal[j][i]){
                    dp[i]=Math.min(dp[i], dp[j]+1);
                }
            }
        }
        return dp[n];
    }
}