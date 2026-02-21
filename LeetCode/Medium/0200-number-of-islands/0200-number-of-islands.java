class Solution {
    int m;
    int n;
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        int c=0;
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1' && !visited[i][j]){
                    visited[i][j]=true;
                    dfs(grid, i, j, visited);
                    c++;
                }
            }
        }
        return c;
    }
    void dfs(char[][] grid, int r, int c, boolean[][] visited){
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && grid[nr][nc]=='1'){
                visited[nr][nc]=true;
                dfs(grid, nr, nc, visited);
            }
        }
    }
}