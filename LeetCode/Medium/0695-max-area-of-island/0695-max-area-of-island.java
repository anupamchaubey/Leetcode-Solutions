class Solution {
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    int m, n;
    public int maxAreaOfIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int max=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    max=Math.max(max, dfs(grid, i, j));
                }
            }
        }
        return max;
    }
    int dfs(int[][] grid, int r, int c){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!=1)return 0;
        grid[r][c]=2;
        int ans=1;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            ans+=dfs(grid, nr, nc);
        }
        return ans;
    }
}