class Solution {
    int m;
    int n;
    int steps;
    int count;
    int[] dr={1, -1, 0, 0};
    int[] dc={0, 0, -1, 1};
    public int uniquePathsIII(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        count=0;
        int str=-1;
        int stc=-1;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0)steps++;
                if(grid[i][j]==1){
                    str=i;
                    stc=j;
                }
            }
        }
        boolean[][] visited=new boolean[m][n];
        visited[str][stc]=true;
        dfs(grid, str, stc, steps, visited);
        return count;
    }
    void dfs(int[][] grid, int r, int c, int steps, boolean[][] visited){
        if(grid[r][c]==2 && steps==-1){
            count++;
            return;
        }
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]!=-1){
                visited[nr][nc]=true;
                dfs(grid, nr, nc, steps-1, visited);
                visited[nr][nc]=false;
            }
        }
    }
}