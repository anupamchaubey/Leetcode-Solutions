class Solution {
    int[] r={1, -1, 0, 0};
    int[] c={0, 0, -1, 1};
    public void solve(char[][] board) {
        int m=board.length;
        int n=board[0].length;
        for(int i=0;i<m;i++){
            if(board[i][0]=='O'){
                dfs(board, i, 0);
            }
            if(board[i][n-1]=='O'){
                dfs(board, i, n-1);
            }
        }
        for(int i=0;i<n;i++){
            if(board[0][i]=='O'){
                dfs(board, 0, i);
            }
            if(board[m-1][i]=='O'){
                dfs(board, m-1, i);
            }
        }
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(board[i][j]=='O'){
                    board[i][j]='X';
                }
                if(board[i][j]=='P'){
                    board[i][j]='O';
                }
            }
        }

    }
    void dfs(char[][] board, int i, int j){
        board[i][j]='P';
        for(int p=0;p<4;p++){
            int nr=i+r[p];
            int nc=j+c[p];
            if(nr>=0 && nr<board.length && nc>=0 && nc<board[0].length && board[nr][nc]=='O'){
                dfs(board, nr, nc);
            }
        }
    }
}