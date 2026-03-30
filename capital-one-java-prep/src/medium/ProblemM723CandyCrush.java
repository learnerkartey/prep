public class ProblemM723CandyCrush {
    public int[][] candyCrush(int[][] board) {
        int rows = board.length;
        int cols = board[0].length;
        boolean changed = true;

        while (changed) {
            changed = false;

            for (int r = 0; r < rows; r++) {
                for (int c = 0; c + 2 < cols; c++) {
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && Math.abs(board[r][c + 1]) == v && Math.abs(board[r][c + 2]) == v) {
                        int k = c;
                        while (k < cols && Math.abs(board[r][k]) == v) {
                            board[r][k] = -v;
                            k++;
                        }
                        changed = true;
                    }
                }
            }

            for (int c = 0; c < cols; c++) {
                for (int r = 0; r + 2 < rows; r++) {
                    int v = Math.abs(board[r][c]);
                    if (v != 0 && Math.abs(board[r + 1][c]) == v && Math.abs(board[r + 2][c]) == v) {
                        int k = r;
                        while (k < rows && Math.abs(board[k][c]) == v) {
                            board[k][c] = -v;
                            k++;
                        }
                        changed = true;
                    }
                }
            }

            if (changed) {
                for (int c = 0; c < cols; c++) {
                    int write = rows - 1;
                    for (int r = rows - 1; r >= 0; r--) {
                        if (board[r][c] > 0) {
                            board[write--][c] = board[r][c];
                        }
                    }
                    while (write >= 0) board[write--][c] = 0;
                }
            }
        }
        return board;
    }
}
