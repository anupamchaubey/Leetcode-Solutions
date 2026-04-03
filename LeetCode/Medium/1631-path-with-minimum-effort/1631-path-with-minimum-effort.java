class Solution {
    public int minimumEffortPath(int[][] height) {
        int[] dr={1, -1, 0, 0};
        int[] dc={0, 0, -1, 1};

        int m=height.length;
        int n=height[0].length;
        int[][] dist=new int[m][n];

        for(int[] arr: dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][0]=0;

        PriorityQueue<int[]> q= new PriorityQueue<>((a, b)-> Integer.compare(a[2], b[2])); // i, j, diff 

        q.offer(new int[] {0, 0, 0});

        while(!q.isEmpty()){
            int[] arr=q.poll();
            int i=arr[0];
            int j=arr[1];
            int d=arr[2];
            if(i==m-1 && j==n-1){
                return dist[i][j];
            }
            for(int p=0;p<4;p++){
                int nr=i+dr[p];
                int nc=j+dc[p];
                if(nr>=0 && nc>=0 && nr<m && nc<n){
                    int newEff=Math.max(d, Math.abs(height[i][j]-height[nr][nc]));
                    if(newEff<dist[nr][nc]){
                        dist[nr][nc]=newEff;
                        q.offer(new int[]{nr, nc, dist[nr][nc]});
                    }
                }
            }
        }
        return dist[m-1][n-1];
    }
}