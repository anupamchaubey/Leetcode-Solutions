class Solution {
    public int[][] highestPeak(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        int[] row={-1, 1, 0, 0};
        int[] col={0, 0, -1, 1};
        int[][] ans=new int[m][n];
        Queue<int[]> q= new LinkedList<>();
        boolean[][] visited=new boolean[m][n];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    q.offer(new int[] {i, j});
                    visited[i][j]=true;
                }
            }
        }
        
        int d=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int p=0;p<size;p++){
                int[] arr=q.poll();
                int r=arr[0];
                int c=arr[1];
                ans[r][c]=d;
                for(int i=0;i<4;i++){
                    int nr=r+row[i];
                    int nc=c+col[i];
                    if(nr>=0 && nc>=0 && nr<m && nc<n && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            d++;
        }
        return ans;
    }
}