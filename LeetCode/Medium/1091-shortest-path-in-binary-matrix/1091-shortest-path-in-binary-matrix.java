class Solution {
    int[] dr={-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc={-1, 0, 1, -1, 1, 1, -1, 0};
    
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]==1 || grid[m-1][n-1]==1)return -1;
        Queue<int[]> q=new LinkedList<>();
        boolean[][] visited=new boolean[m][n];

        visited[0][0]=true;
        q.offer(new int[]{0, 0});
        int length=1;
        while(!q.isEmpty()){
            int size=q.size();
            for(int p=0;p<size;p++){
                int[] arr=q.poll();
                int r=arr[0];
                int c=arr[1];
                
                if(r==m-1 && c==n-1)return length;

                for(int i=0;i<8;i++){
                    int nr=r+dr[i];
                    int nc=c+dc[i];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc] && grid[nr][nc]==0){
                        visited[nr][nc]=true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            length++;
        }
        return -1;
    }
}