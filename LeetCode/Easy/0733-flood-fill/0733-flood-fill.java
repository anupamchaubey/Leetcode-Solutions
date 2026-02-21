class Solution {
    int m;
    int n;
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    public int[][] floodFill(int[][] image, int sr, int sc, int color) {
        if(image[sr][sc]==color)return image;
        m=image.length;
        n=image[0].length;
        int org=image[sr][sc];
        image[sr][sc]=color;
        dfs(image, sr, sc, org, color);
        return image;
    }
    void dfs(int[][] grid, int r, int c, int org, int color){
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && grid[nr][nc]==org){
                grid[nr][nc]=color;
                dfs(grid, nr, nc, org, color);
            }
        }
    }
}