class Solution {
    int m, n;
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    public int numIslands(char[][] grid) {
        m=grid.length;
        n=grid[0].length;
        boolean[][] visited=new boolean[m][n];
        int count=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(!visited[i][j] && grid[i][j]=='1'){
                    dfs(grid, i, j, visited);
                    count++;
                }
            }
        }
        return count;
    }
    void dfs(char[][] grid, int r, int c, boolean[][] visited){
        if(r>=m || c>=n || r<0 || c<0 || visited[r][c] || grid[r][c]=='0')return;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            dfs(grid, nr, nc, visited);
        }
    }
}