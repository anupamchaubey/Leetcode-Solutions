class Solution {
    int max;
    Integer[][][] dp;
    int[] dr={1, -1, 0, 0};
    int[] dc={0,0, -1, 1};
    int MOD=1000000007;
    public int findPaths(int m, int n, int maxMove, int startRow, int startColumn) {
        max=maxMove;
        dp= new Integer[m][n][maxMove+1];
        return rec(m, n, startRow, startColumn, 0);
        
    }
    int rec(int m, int n, int r, int c, int moves){
        if(r<0 || c<0 || r>=m || c>=n){
            if(moves<=max)return 1;
            return 0;
        }
        if(moves>max){
            return 0;
        }
        if(dp[r][c][moves]!=null)return dp[r][c][moves];
        int count=0;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            count=(count+rec(m, n, nr, nc, moves+1))%MOD;
        }
        return dp[r][c][moves]= count;
    }
}