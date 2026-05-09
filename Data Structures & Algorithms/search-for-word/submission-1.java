class Solution {

    int[][] directions = {
        {1, 0},
        {-1, 0},
        {0, 1},
        {0, -1}
    };

    public boolean search(char[][] board, String word, int i, int j, int idx) {

        int m = board.length;
        int n = board[0].length;

        // out of bounds
        if (i < 0 || j < 0 || i >= m || j >= n) {
            return false;
        }

        // character mismatch
        if (board[i][j] != word.charAt(idx)) {
            return false;
        }

        // complete word found
        if (idx == word.length() - 1) {
            return true;
        }

        // mark visited
        char temp = board[i][j];
        board[i][j] = '#';

        // move in 4 directions
        for (int[] dir : directions) {

            int new_i = i + dir[0];
            int new_j = j + dir[1];

            if (search(board, word, new_i, new_j, idx + 1)) {
                return true;
            }
        }

        // backtrack
        board[i][j] = temp;

        return false;
    }

    public boolean exist(char[][] board, String word) {

        int m = board.length;
        int n = board[0].length;

        for (int i = 0; i < m; i++) {

            for (int j = 0; j < n; j++) {

                if (search(board, word, i, j, 0)) {
                    return true;
                }
            }
        }

        return false;
    }
}