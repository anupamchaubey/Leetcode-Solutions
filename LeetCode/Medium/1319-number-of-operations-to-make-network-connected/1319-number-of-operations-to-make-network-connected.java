class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(parent[x]!=x){
            parent[x]=find(parent[x]);
        }
        return parent[x];
    }
    void union(int x, int y){
        int px=find(x);
        int py=find(y);

        if(px==py)return;

        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(parent[py]>px){
            parent[px]=py;
        }else{
            parent[px]=py;
            rank[py]++;
        }
    }
    public int makeConnected(int n, int[][] connections) {
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        
        int extraCables=0;
        for(int[] c: connections){
            int x=c[0];
            int y=c[1];
            if(find(x)==find(y))extraCables++;
            else{
                union(x, y);
            }
        }
        int comps=0;
        for(int i=0;i<n;i++){
            if(parent[i]==i)comps++;
        }
        if(extraCables<(comps-1))return -1;
        return comps-1;
    }
}