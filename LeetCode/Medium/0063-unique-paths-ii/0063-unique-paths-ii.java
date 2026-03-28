class Solution {
    int m;
    int n;
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        m=obstacleGrid.length;
        n=obstacleGrid[0].length;
        if(obstacleGrid[0][0]==1 || obstacleGrid[m-1][n-1]==1)return 0;
        int[][] dp= new int[m][n];
        dp[m-1][n-1]=1;
        for(int i=m-1;i>=0;i--){
            if(obstacleGrid[i][n-1]==0){
                dp[i][n-1]=1;
            }
        }
        for(int i=n-1;i>=0;i--){
            if(obstacleGrid[m-1][i]==0){
                dp[m-1][i]=1;
            }
        }
        for(int i=m-2;i>=0;i--){
            for(int j=n-2;j>=0;j--){
                if(obstacleGrid[i][j]!=1){
                    dp[i][j]=dp[i+1][j]+dp[i][j+1];
                }
            }
        }
        return dp[0][0];

        // return rec(obstacleGrid, 0, 0);
    }
    int rec(int[][] obs, int i, int j){
        if(i==m-1 && j==n-1)return 1;
        int c=0;
        if(i+1<m && obs[i+1][j]!=1){
            c+=rec(obs, i+1, j);
        }
        if(j+1<n && obs[i][j+1]!=1){
            c+=rec(obs, i, j+1);
        }
        return c;
    }
}