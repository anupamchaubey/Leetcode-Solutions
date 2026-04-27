class Solution {
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    int m;
    int n;
    
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        m=heights.length;
        n=heights[0].length;
        List<List<Integer>> ans= new ArrayList<>();
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(pacific(heights, i, j, new boolean[m][n]) && atlantic(heights, i, j, new boolean[m][n])){
                    ans.add(Arrays.asList(i, j));
                }
            }
        }
        return ans;
    }
    boolean pacific(int[][] heights, int r, int c, boolean[][] visited){
        if(r==0 || c==0)return true;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && heights[nr][nc]<=heights[r][c]){
                if(pacific(heights, nr, nc, visited))return true;
            }
        }
        return false;
    }
    boolean atlantic(int[][] heights, int r, int c, boolean[][] visited){
        if(r==m-1 || c==n-1)return true;
        visited[r][c]=true;
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc] && heights[nr][nc]<=heights[r][c]){
                if(atlantic(heights, nr, nc, visited))return true;
            }
        }
        return false;
    }
}