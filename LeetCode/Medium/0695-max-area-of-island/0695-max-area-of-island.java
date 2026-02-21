class Solution {
    int m;
    int n;
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    public int maxAreaOfIsland(int[][] grid) {
        int max=0;
        m=grid.length;
        n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1 && !visited[i][j]){
                    visited[i][j]=true;
                    max=Math.max(max, dfs(grid, i, j, visited));
                }
            }
        }
        return max;
    }
    int dfs(int[][] grid, int r, int c, boolean[][] visited){
        int area=1;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr<0 || nc<0 || nr>=m || nc>=n || visited[nr][nc] || grid[nr][nc]!=1)continue;
            visited[nr][nc]=true;
            area+=dfs(grid, nr, nc, visited);
        }
        return area;
    }
}