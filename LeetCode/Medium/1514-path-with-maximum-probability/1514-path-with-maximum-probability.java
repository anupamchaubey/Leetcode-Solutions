class Solution {
    class Pair{
        int v;
        double pr;
        Pair(int v, double pr){
            this.v=v;
            this.pr=pr;
        }
    }
    public double maxProbability(int n, int[][] edges, double[] succ, int st, int en) {
        List<List<Pair>> adj=new ArrayList<>();
        for(int i=0;i<n;i++){
            adj.add(new ArrayList<>());
        }
        
        for(int i=0;i<succ.length;i++){
            int u=edges[i][0];
            int v=edges[i][1];
            double pr=succ[i];
            adj.get(u).add(new Pair(v, pr));
            adj.get(v).add(new Pair(u, pr));
        }
        double[] prob=new double[n];
        Arrays.fill(prob, -1.00000);
        prob[st]=1.00000;

        PriorityQueue<Pair> pq= new PriorityQueue<>((a, b)-> Double.compare(b.pr, a.pr));
        pq.offer(new Pair(st, 1.00000));

        while(!pq.isEmpty()){
            Pair arr=pq.poll();
            int u=arr.v;
            double pro=arr.pr;
            if(u==en)return prob[u];
            for(Pair p: adj.get(u)){
                int v=p.v;
                double npr=p.pr*pro;
                if(prob[v]<npr){
                    prob[v]=npr;
                    pq.offer(new Pair(v, prob[v]));
                }
            }
        }
        return 0;
    }
}