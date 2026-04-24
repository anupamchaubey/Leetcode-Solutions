class Solution {
    class Pair{
        int v;
        int t;
        Pair(int v, int t){
            this.v=v;
            this.t=t;
        }
    }
    public int networkDelayTime(int[][] times, int n, int k) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<=n;i++){
            adj.add(new ArrayList<>());
        }
        for(int[] e:times){
            int u=e[0];
            int v=e[1];
            int t=e[2];
            adj.get(u).add(new Pair(v, t));
        }
        int[] dist=new int[n+1];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[k]=0;

        PriorityQueue<Pair> pq= new PriorityQueue<>((a, b)-> Integer.compare(a.t, b.t));
        pq.offer(new Pair(k, 0));
        while(!pq.isEmpty()){
            Pair p=pq.poll();
            int u=p.v;
            int t=p.t;
            if(t>dist[u])continue;
            for(Pair pair: adj.get(u)){
                int v=pair.v;
                int ct=pair.t;
                if(t+ct<dist[v]){
                    dist[v]=t+ct;
                    pq.offer(new Pair(v, dist[v]));
                }
            }
        }
        int max=0;
        for(int i=1;i<=n;i++){
            int x=dist[i];
            if(x==Integer.MAX_VALUE)return -1;
            max=Math.max(max, x);
        }
        return max;
    }
}