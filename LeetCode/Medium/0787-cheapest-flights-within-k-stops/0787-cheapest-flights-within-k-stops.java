class Solution {
    class Pair{
        int node;
        int price;
        public Pair(int node, int price){
            this.node=node;
            this.price=price;
        }
    }
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        for(int i=0;i<flights.length;i++){
            int a=flights[i][0];
            int b=flights[i][1];
            int w=flights[i][2];
            adj.get(a).add(new Pair(b,w));
        }
        int[] dist= new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src]=0;
        Queue<int[]> q= new LinkedList<>();
        q.offer(new int[]{src, 0, 0});
        while(!q.isEmpty()){
            int[] curr=q.poll();
            int node=curr[0];
            int d=curr[1];
            int st=curr[2];
            if(st>k)continue;
            for(Pair p: adj.get(node)){
                int nr=p.node;
                int nd=p.price+d;
                if(dist[nr]>nd){
                    dist[nr]=nd;
                    q.offer(new int[]{nr, nd, st+1});
                }
            }
        }
        if(dist[dst]==Integer.MAX_VALUE)return -1;
        return dist[dst];
    }
}