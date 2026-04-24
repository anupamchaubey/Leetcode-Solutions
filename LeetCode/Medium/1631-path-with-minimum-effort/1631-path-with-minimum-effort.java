class Solution {
    class Pair{
        int r, c, eff;
        Pair(int r, int c, int eff){
            this.r=r;
            this.c=c;
            this.eff=eff;
        }
    }
    public int minimumEffortPath(int[][] heights) {
        int[] dr={-1, 1, 0, 0};
        int[] dc={0, 0, -1, 1};
        int[][] dist= new int[heights.length][heights[0].length];
        for(int[] arr: dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[0][0]=0;

        PriorityQueue<Pair> pq= new PriorityQueue<>((a,b)-> Integer.compare(a.eff, b.eff));
        pq.offer(new Pair(0, 0, 0));

        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int r=p.r;
            int c=p.c;
            int eff=p.eff;

            for(int i=0;i<4;i++){
                int nr=r+dr[i];
                int nc=c+dc[i];
                if(nr<0 || nc<0 || nr>=heights.length|| nc>=heights[0].length)continue;
                int neff=Math.max(eff, Math.abs(heights[nr][nc]-heights[r][c]));
                if(dist[nr][nc]>neff){
                    dist[nr][nc]=neff;
                    pq.offer(new Pair(nr, nc, neff));
                }
            }
        }
        return dist[heights.length-1][heights[0].length-1];
    }
}