class Solution {
    class Pair{
        int r;
        int c;
        int d;
        Pair(int r, int c, int d){
            this.r=r;
            this.c=c;
            this.d=d;
        }
    }
    int[] dr={-1, -1, -1, 0, 0, 1, 1, 1};
    int[] dc={-1, 0, 1, -1, 1, -1, 0, 1};
    public int shortestPathBinaryMatrix(int[][] grid) {
        int m=grid.length;
        int n=grid[0].length;
        if(grid[0][0]!=0)return -1;
        boolean[][] visited= new boolean[m][n];
        Queue<Pair> q= new ArrayDeque<>();
        visited[0][0]=true;
        q.offer(new Pair(0, 0, 1));
        while(!q.isEmpty()){
            Pair p=q.poll();
            int row=p.r;
            int col=p.c;
            int dist=p.d;
            if(row==m-1 && col==n-1)return dist;
            for(int i=0;i<8;i++){
                int r=row+dr[i];
                int c=col+dc[i];
                if(r>=0 && c>=0 && r<m && c<n && grid[r][c]==0 && !visited[r][c]){
                    visited[r][c]=true;
                    q.offer(new Pair(r, c, dist+1));
                }
            }
        }
        return -1;
    }
}