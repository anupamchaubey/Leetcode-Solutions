class Solution {
    int[] dr={-1,1 , 0, 0};
    int[] dc={0, 0, -1,1 };
    public boolean exist(char[][] board, String word) {
        int m=board.length;
        int n=board[0].length;
        
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(word.charAt(0)==board[i][j]){
                    if(rec(board, i, j, word, 0, new boolean[m][n]))return true;
                }
            }
        }
        return false;
    }
    boolean rec(char[][] grid, int i, int j, String word, int k, boolean[][] visited){
        if(k==word.length())return true;
        if(i>=grid.length || j>=grid[0].length || i<0 || j<0 || visited[i][j] || grid[i][j]!=word.charAt(k))return false;
        visited[i][j]=true;
        boolean ans=false;
        for(int p=0;p<4;p++){
            int r=i+dr[p];
            int c=j+dc[p];
            ans|=rec(grid, r, c, word, k+1, visited);
        }
        visited[i][j]=false;
        return ans;
    }
}