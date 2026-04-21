class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };
    int m, n;

    public int closedIsland(int[][] grid) {
        m = grid.length;
        n = grid[0].length;

        boolean[][] visited = new boolean[m][n];
        
        int count = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!visited[i][j] && grid[i][j] == 0) {
                    if(dfs(grid, i, j, visited)){
                        count++;
                    }
                }
            }
        }
        return count;
    }

    boolean dfs(int[][] grid, int r, int c, boolean[][] visited) {
        if(r>=m || c>=n || r<0 || c<0 )return false;
        
       
        if(grid[r][c]==1)return true;
        if(visited[r][c])return true;
        visited[r][c]=true;

        boolean closed=true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if(!dfs(grid, nr, nc, visited))closed= false;
        }
        return closed;
    }
}