class Solution {
    class Pair{
        int node;
        int price;
        Pair(int n, int price){
            this.node=n;
            this.price=price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj= new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        int[] dist=new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        for(int[] f:flights){
            int s=f[0];
            int d=f[1];
            int p=f[2];
            adj.get(s).add(new Pair(d, p));
        }

        Queue<int[]> pq= new LinkedList<>();
        pq.offer(new int[]{src, 0, 0});
        dist[src]=0;

        while(!pq.isEmpty()){
            int[] curr=pq.poll();
            int s=curr[0];
            int price=curr[1];
            int stops=curr[2];
            if(stops>k)continue;

            for(Pair p: adj.get(s)){
                int ns=p.node;
                int nprice=price+p.price;
                int nstops=stops+1;

                if(dist[ns]>nprice ){
                    dist[ns]=nprice;
                    pq.offer(new int[]{ns, dist[ns], nstops});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)return -1;
        return dist[dst];
    }
}