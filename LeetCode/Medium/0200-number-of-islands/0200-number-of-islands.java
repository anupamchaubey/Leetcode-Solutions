class Solution {
    int[] parent;
    int[] rank;

    int find(int x){
        if(parent[x]!=x)parent[x]=find(parent[x]);
        return parent[x];
    }
    void union(int x, int y){
        int px=find(x);
        int py=find(y);
        if(px==py)return;

        if(rank[px]>rank[py]){
            parent[py]=px;
        }else if(rank[py]>rank[px]){
            parent[px]=py;
        }else{
            parent[py]=px;
            rank[px]++;
        }
    }
    public int numIslands(char[][] grid) {
        int r=grid.length;
        int c=grid[0].length;
        int n=r*c;
        parent=new int[n];
        rank=new int[n];

        for(int i=0;i<n;i++){
            parent[i]=i;
            rank[i]=1;
        }
        int cnt=0;
        for(int i=0;i<r;i++){
            for(int j=0;j<c;j++){
                if(grid[i][j]=='1'){
                    cnt++;
                    int id=i*c+j;
                    //up
                    if(i>0 && grid[i-1][j]=='1'){
                        if(find(id)!=find((i-1)*c+j)){
                            union(id, (i-1)*c+j);
                            cnt--;
                        }
                    }
                    //left
                    if(j>0 && grid[i][j-1]=='1'){
                        if(find(id)!=find(i*c+(j-1))){
                            union(id, i*c+(j-1));
                            cnt--;
                        }
                    }
                }
            }
        }
        return cnt;
    }
}