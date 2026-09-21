class Solution {
    int[] dr = { -1, 1, 0, 0 };
    int[] dc = { 0, 0, -1, 1 };

    public boolean exist(char[][] board, String word) {
        boolean[][] visited = new boolean[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[0].length; j++) {
                if (board[i][j] == word.charAt(0)) {

                    if (valid(board, word, i, j, 0, visited))
                        return true;
                }
            }
        }
        return false;
    }

    boolean valid(char[][] board, String word, int r, int c, int idx, boolean[][] visited) {
        if (idx == word.length())
            return true;
        if (r < 0 || c < 0 || r == board.length || c == board[0].length || board[r][c] != word.charAt(idx)
                || visited[r][c])
            return false;

        visited[r][c] = true;
        for (int i = 0; i < 4; i++) {
            int nr = r + dr[i];
            int nc = c + dc[i];
            if (valid(board, word, nr, nc, idx + 1, visited))
                return true;
        }
        visited[r][c] = false;
        return false;
    }
}