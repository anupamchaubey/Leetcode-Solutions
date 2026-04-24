class Solution {
    class Pair{
        int c, pr;
        Pair(int c, int pr){
            this.c=c;
            this.pr=pr;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] f:flights){
            int u=f[0];
            int v=f[1];
            int pr=f[2];
            adj.get(u).add(new Pair(v, pr));
        }
        int[][] dist= new int[n+1][k+2];
        for(int[] arr: dist){
            Arrays.fill(arr, Integer.MAX_VALUE);
        }
        dist[src][0]=0;

        PriorityQueue<int[]> pq= new PriorityQueue<>((a, b)-> Integer.compare(a[1], b[1]));
        pq.offer(new int[]{src, 0, 0}); // city, price, stops

        while(!pq.isEmpty()){
            int[] arr= pq.poll();
            int u=arr[0];
            int pr=arr[1];
            int st=arr[2];
            if(st>k)continue;
            for(Pair p: adj.get(u)){
                int v=p.c;
                int npr=pr+p.pr;
                if(npr<dist[v][st+1]){
                    dist[v][st+1]=npr;
                    pq.offer(new int[]{v, dist[v][st+1], st+1});
                }
            }
        }
        int min=Integer.MAX_VALUE;
        for(int i=0;i<=k+1;i++){
            min=Math.min(min, dist[dst][k+1]);
        }
        if(min==Integer.MAX_VALUE)return -1;
        return min;

    }
}