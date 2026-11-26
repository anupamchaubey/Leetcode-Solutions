class Solution {
    public boolean isValidSudoku(char[][] board) {

        for (int i = 0; i < 9; i++) {
            HashSet<Character> hs = new HashSet<>();
            for (int j = 0; j < 9; j++) {
                if (board[i][j] == '.')
                    continue;
                if (hs.contains(board[i][j]))
                    return false;
                hs.add(board[i][j]);
            }
            hs = new HashSet<>();

            for (int j = 0; j < 9; j++) {
                if (board[j][i] == '.')
                    continue;
                if (hs.contains(board[j][i]))
                    return false;
                hs.add(board[j][i]);
            }
        }
        for (int i = 0; i < 9; i += 3) {
            for (int j = 0; j < 9; j += 3) {
                HashSet<Character> hs = new HashSet<>();
                for (int l = i; l < i + 3; l++) {
                    for (int k = j; k < j + 3; k++) {
                        if (board[l][k] == '.')
                            continue;
                        if (hs.contains(board[l][k]))
                            return false;
                        hs.add(board[l][k]);
                    }
                }
            }
        }
        return true;

    }
}