class Solution {
    public boolean checkMove(char[][] board, int r, int c, char color) {
        int m = board.length;
        int n = board[0].length;
        board[r][c] = color;
        //up left diagonal
        int i = r - 1, j = c - 1;
        if (board[0][0] == color) {
            while (i > 0 && j > 0) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                i--;
                j--;
            }
            if (i == 0 || j == 0)
                return true;
        }
        //down right diagonal
        i = r + 1;
        j = c + 1;
        if (board[m - 1][n - 1] == color) {
            while (i < m - 1 && j < n - 1) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                i++;
                j++;
            }
            if (i == m - 1 || j == n - 1)
                return true;
        }
        //down left diagonal
        i = r + 1;
        j = c - 1;
        if (board[m - 1][0] == color) {
            while (i < m - 1 && j > 0) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                i++;
                j--;
            }
            if (i == m - 1 || j == 0)
                return true;
        }
        //up right diagonal
        i = r - 1;
        j = c + 1;
        if (board[0][n - 1] == color) {
            while (i > 0 && j < n - 1) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                i--;
                j++;
            }
            if (i == 0 || j == n - 1)
                return true;
        }
        //up
        i = r - 1;
        j = c;
        if (board[0][j] == color) {
            while (i > 0) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                i--;
            }
            if (i == 0)
                return true;
        }
        //down
        i = r + 1;
        j = c;
        if (board[m - 1][j] == color) {
            while (i < m - 1) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                i++;
            }
            if (i == m - 1)
                return true;
        }
        //left
        i = r;
        j = c - 1;
        if (board[i][0] == color) {
            while (j > 0) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                j--;
            }
            if (j == 0)
                return true;
        }
        //right
        i = r;
        j = c + 1;
        if (board[i][n - 1] == color) {
            while (j < n - 1) {
                if (board[i][j] == color || board[i][j]=='.')
                    break;
                j++;
            }
            if (j == n - 1)
                return true;
        }
        return false;
    }
}