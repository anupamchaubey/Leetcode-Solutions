
class Solution {
    int ans = 0;
    public int totalNQueens(int n) {
        
        char[][] grid = new char[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                grid[i][j] = '.';
            }
        }
        backtrack(grid, 0);
        return ans;

    }

    void backtrack(char[][] grid, int col) {
        if (col == grid.length) {
            ans++;
            return;
        }
        for (int i = 0; i < grid.length; i++) {
            if (isValid(grid, i, col)) {
                grid[i][col] = 'Q';
                backtrack(grid, col + 1);
                grid[i][col] = '.';
            }
        }
    }


    boolean isValid(char[][] grid, int r, int col) {
        for (int i = 0; i < grid.length; i++) {
            if (grid[i][col] == 'Q')
                return false;
            if (grid[r][i] == 'Q')
                return false;
        }
        for (int i = r, j = col; i >= 0 && j >= 0; i--, j--) {
            if (grid[i][j] == 'Q')
                return false;
        }
        for (int i = r, j = col; i < grid.length && j >= 0; i++, j--) {
            if (grid[i][j] == 'Q')
                return false;
        }
        return true;
    }
}