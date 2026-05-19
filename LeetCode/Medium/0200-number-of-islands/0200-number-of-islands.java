class Solution {
    int[] parent;
    int[] rank;
    int find(int x){
        if(x==parent[x])return x;
        return parent[x]=find(parent[x]);
    }
    boolean union(int x, int y){
        int parentX=find(x);
        int parentY=find(y);

        if(parentX == parentY)return false;

        if(rank[parentX]>rank[parentY]){
            parent[parentY]=parentX;
        }else if(rank[parentY]>rank[parentX]){
            parent[parentX]=parentY;
        }else{
            parent[parentY]=parentX;
            rank[parentX]++;
        }
        return true;
    }
    public int numIslands(char[][] grid) {

        int m=grid.length;
        int n=grid[0].length;

        parent=new int[m*n];
        rank=new int[m*n];
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                int id=i*n+j;
                parent[id]=id;
                rank[id]=1;
            }
        }
        int islands=0;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]=='1'){
                    islands++;
                    int id=i*n+j;
                    if(i+1<m && grid[i+1][j]=='1'){
                        int nid=(i+1)*n+j;
                        if(union(id, nid))islands--;
                    }
                    if(j+1<n && grid[i][j+1]=='1'){
                        int nid=i*n+(j+1);
                        if(union(id, nid))islands--;
                    }
                }
            }
        }
        return islands;
    }
    public void dfs(char[][] grid, int i, int j){
        if(i<0 || j<0 || i>=grid.length || j>=grid[0].length || grid[i][j]=='0'){
            return;
        }
        grid[i][j]='0';
        dfs(grid,i+1,j);
        dfs(grid,i-1,j);
        dfs(grid,i,j+1);
        dfs(grid,i,j-1);
    }
}