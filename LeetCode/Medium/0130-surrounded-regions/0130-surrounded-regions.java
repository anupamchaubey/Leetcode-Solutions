class Solution {
    int[] dr={-1, 1, 0, 0};
    int[] dc={0, 0, -1, 1};
    int m, n;
    public void solve(char[][] board) {
        m=board.length;
        n=board[0].length;

        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0, true);
            }
        }
        for(int i=0;i<m;i++){
            if(board[i][n-1]=='O'){
                dfs(board, i, n-1, true);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board, 0, i, true);
            }
        }
        for(int i=0;i<n;i++){
            if(board[m-1][i]=='O'){
                dfs(board, m-1, i, true);
            }
        }

        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    dfs(board, i, j, false);
                }
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='P'){
                    board[i][j]='O';
                }
            }
        }
    }
    void dfs(char[][] grid, int r, int c, boolean flag){
        if(r<0 || c<0 || r>=m || c>=n || grid[r][c]!='O')return;
        
        if(flag){
            grid[r][c]='P';
        }else{
            grid[r][c]='X';
        }
        for(int i=0;i<4;i++){
            int nr=r+dr[i];
            int nc=c+dc[i];
            dfs(grid, nr, nc, flag);
        }
    }

}