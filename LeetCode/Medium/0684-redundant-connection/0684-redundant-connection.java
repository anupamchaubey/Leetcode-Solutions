class Solution {
    int[] parent;
    int[] size;
    
    int find(int x){
        if(parent[x]!=x)return find(parent[x]);
        return x;
    }
    boolean union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(size[px]>size[py]){
            parent[py]=px;
        }else if(size[py]>size[px]){
            parent[px]=py;
        }else{
            parent[px]=py;
            size[py]+=size[px];
        }
        return true;
    }
    public int[] findRedundantConnection(int[][] edges) {
        parent=new int[edges.length];
        size=new int[edges.length];
        for(int i=0;i<edges.length;i++){
            parent[i]=i;
        }
        int[] ans={-1, -1};
        for(int[] e: edges){
            if(!union(e[0]-1, e[1]-1)){
                ans=e;
            }
        }
        return ans;
    }
}