class Solution {
    int ans=Integer.MAX_VALUE;
    int m;
    int n;
    boolean[][][] visited;
    public int minCost(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        visited= new boolean[m][n][1024];
        rec(grid, 0, 0, 0);
        return ans;
    }
    void rec(int[][] grid, int i, int j, int xor){
        if(i>=m || j>=n)return;
        if(visited[i][j][xor])return;
        visited[i][j][xor]=true;
        xor^=grid[i][j];
        if(i==m-1 && j==n-1){
            ans=Math.min(ans, xor);
            return;
        }
        
        rec(grid, i+1, j, xor);
        rec(grid, i, j+1, xor);
    }
}