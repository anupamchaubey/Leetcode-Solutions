class Solution {
    int[] parent;
    int[] rank;
    public int removeStones(int[][] stones) {
        int n=stones.length;
        parent=new int[n];
        rank=new int[n];
        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=0;
        }
        for(int i=0;i<n;i++){
            int r=stones[i][0];
            int c=stones[i][1];

            for(int j=0;j<n;j++){
                int nr=stones[j][0];
                int nc=stones[j][1];
                if(nr==r || nc==c){
                    union(i,j);
                }
            }
        }
        int count=0;
        for(int i=0;i<n;i++){
            if(find(i)==i)count++;
        }
        return n-count;
    }
    int find(int x){
        if(parent[x]==x)return x;
        return parent[x]=find(parent[x]);
    }
    boolean union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return false;
        if(rank[py]>rank[px]){
            parent[px]=py;
        }else if(rank[px]>rank[py]){
            parent[py]=px;
        }else{
            parent[py]=px;
            rank[px]++;
        }
        return true;
    }
}