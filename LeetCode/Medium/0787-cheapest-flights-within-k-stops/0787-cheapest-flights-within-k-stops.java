class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        int[] price= new int[n];
        Arrays.fill(price, Integer.MAX_VALUE);
        price[src]=0;

        int INF=Integer.MAX_VALUE;

        for(int i=0;i<=k;i++){
            int[] temp=price.clone();
            for(int[] f: flights){
                int u=f[0];
                int v=f[1];
                int c=f[2];
                if(price[u]!=INF){
                    temp[v]=Math.min(temp[v], price[u]+c);
                }
            }
            price=temp;
        }
        return price[dst]==INF? -1: price[dst];

    }
}