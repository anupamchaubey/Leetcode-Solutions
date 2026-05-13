class Solution {
    char[][] grid;
    List<List<String>> ans=new ArrayList<>();
    public List<List<String>> solveNQueens(int n) {
        grid=new char[n][n];
        for(int i=0;i<n;i++){
            Arrays.fill(grid[i], '.');
        }
        rec(0);
        return ans;
    }
    void rec(int r){
        if(r==grid.length){
            List<String> ls=gridToList();
            ans.add(new ArrayList<>(ls));
            return;
        }
        for(int i=0;i<grid[0].length;i++){
            if(canPlace(r, i)){
                grid[r][i]='Q';
                rec(r+1);
                grid[r][i]='.';
            }
        }
    }
    boolean canPlace(int r, int c){
        for(int i=0;i<grid[0].length;i++){
            if(grid[r][i]=='Q')return false;
        }
        for(int i=0;i<grid.length;i++){
            if(grid[i][c]=='Q')return false;
        }
        for(int i=r, j=c;i>=0 && j>=0;i--, j--){
            if(grid[i][j]=='Q')return false;
        }
        for(int i=r, j=c;i>=0 && j<grid[0].length;i--, j++){
            if(grid[i][j]=='Q')return false;
        }
        return true;
    }
    List<String> gridToList(){
        List<String> ls=new ArrayList<>();
        for(int i=0;i<grid.length;i++){
            String s="";
            for(int j=0;j<grid[0].length;j++){
                s+=grid[i][j];
            }
            ls.add(s);
        }
        return ls;
    }
}