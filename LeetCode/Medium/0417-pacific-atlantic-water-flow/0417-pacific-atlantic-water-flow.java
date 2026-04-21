class Solution {
    List<List<Integer>> ans;
    int m,n;
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        ans=new ArrayList<>();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific(heights, i, j, new boolean[m][n]) && atlantic(heights, i, j, new boolean[m][n])){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    boolean pacific(int[][] grid, int r, int c, boolean[][] visited){
        if(r==0 || c==0)return true;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && grid[nr][nc]<=grid[r][c]){
                if(pacific(grid, nr, nc, visited))return true;
            }
        }
        return false;
    }


    boolean atlantic(int[][] grid, int r, int c, boolean[][] visited){
        if(r==m-1 || c==n-1)return true;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && grid[nr][nc]<=grid[r][c]){
                if(atlantic(grid, nr, nc, visited))return true;
            }
        }
        return false;
    }
}