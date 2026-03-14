class Solution {
    public int[][] highestPeak(int[][] isWater) {
        int m=isWater.length;
        int n=isWater[0].length;
        
        boolean[][] visited=new boolean[m][n];

        Queue<int[]> q=new LinkedList();
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(isWater[i][j]==1){
                    
                    visited[i][j]=true;
                    q.offer(new int[]{i, j});
                }
            }
        }
        int[][] dir={{-1, 0}, {0, -1}, {1, 0}, {0, 1}};
        int level=0;
        while(!q.isEmpty()){
            int size=q.size();
            for(int p=0;p<size;p++){
                int[] arr=q.poll();
                int r=arr[0];
                int c=arr[1];
                isWater[r][c]=level;
                for(int i=0;i<4;i++){
                    int nr=r+dir[i][0];
                    int nc=c+dir[i][1];
                    if(nr>=0 && nr<m && nc>=0 && nc<n && !visited[nr][nc]){
                        visited[nr][nc]=true;
                        q.offer(new int[]{nr, nc});
                    }
                }
            }
            level++;
        }
        return isWater;
    }
}