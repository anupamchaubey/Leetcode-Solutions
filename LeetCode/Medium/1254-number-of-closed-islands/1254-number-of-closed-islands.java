class Solution {
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    int m, n;
    public int closedIsland(int[][] grid) {
        m=grid.length;
        n=grid[0].length;
        for(int i=0;i<m;i++){
            if(grid[i][0]==0){
                bfs(grid, i, 0);
            }
            if(grid[i][n-1]==0){
                bfs(grid, i, n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(grid[0][i]==0){
                bfs(grid, 0, i);
            }
            if(grid[m-1][i]==0){
                bfs(grid, m-1, i);
            }
        }
        int count=0;

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==0){
                    if(dfs(grid, i, j))count++;
                }
            }
        }
        return count;



    }
    boolean dfs(int[][] grid, int r, int c){
        if(grid[r][c]==1)return true;
        grid[r][c]=2;
        boolean ans=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==0 || grid[nr][nc]==1){
                ans=ans & dfs(grid, nr, nc);
            }
        }
        return ans;
    }
    void bfs(int[][] grid, int r, int c){
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{r, c});
        grid[r][c]=2;
        while(!q.isEmpty()){
            int[] p=q.poll();
            r=p[0];
            c=p[1];
            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==0){
                    grid[nr][nc]=2;
                    q.offer(new int[]{nr, nc});
                }
            }
        }
    }
}