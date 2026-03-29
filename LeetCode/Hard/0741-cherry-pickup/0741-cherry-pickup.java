class Solution {
    int m, n;
    public int cherryPickup(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        Integer[][][][] dp= new Integer[m][n][m][n];
        return Math.max(0, rec(grid, 0, 0, 0, 0, dp));
    }
    int rec(int[][] grid, int i, int j, int p, int q, Integer[][][][] dp){
        if(i==m-1 && j==n-1 && p==m-1 && q==n-1)return grid[i][j];
        if(i>=m || j>=n || p>=m || q>=n)return Integer.MIN_VALUE;
        if(grid[i][j]==-1 || grid[p][q]==-1)return Integer.MIN_VALUE;
        
        if(dp[i][j][p][q]!=null)return dp[i][j][p][q];
        int cherries=0;
        if(i==p && j==q){
            cherries+=grid[i][j];
        }else{
            cherries+=grid[i][j];
            cherries+=grid[p][q];
        }
        int max=Integer.MIN_VALUE;
        max=Math.max(max, rec(grid, i+1, j, p+1, q, dp));
        max=Math.max(max, rec(grid, i, j+1, p, q+1, dp));
        max=Math.max(max, rec(grid, i+1, j, p, q+1, dp));
        max=Math.max(max, rec(grid, i, j+1, p+1, q, dp));
        cherries+=max;
        return dp[i][j][p][q]=cherries;
    }
}