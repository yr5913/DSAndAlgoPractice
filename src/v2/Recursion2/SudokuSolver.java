package v2.Recursion2;

public class SudokuSolver {

    public void solveSudoku(char[][] board) {
        solveSudoku(board, 0);
    }

    public boolean solveSudoku(char[][] board, int index) {
        if (index == 81) {
            return true;
        }
        int row = index / 9;
        int column = index % 9;
        if (board[row][column] == '.') {
            for (char val = '1'; val <= '9'; val++) {
                if (validate(board, column, row, val)) {
                    board[row][column] = val;
                    boolean ret = solveSudoku(board, index + 1);
                    if (!ret)
                        board[row][column] = '.';
                    else {
                        return true;
                    }
                }
            }
        } else {
            return solveSudoku(board, index + 1);
        }
        return false;
    }

    public boolean validate(char[][] board, int column, int row, char val) {
        for (int i = column + 1; i < board[row].length; i++) {
            if (board[row][i] == val) {
                return false;
            }
        }

        for (int i = column - 1; i >= 0; i--) {
            if (board[row][i] == val) {
                return false;
            }
        }
        for (int i = row + 1; i < board.length; i++) {
            if (board[i][column] == val) {
                return false;
            }
        }
        for (int i = row - 1; i >= 0; i--) {
            if (board[i][column] == val) {
                return false;
            }
        }
        int vRow = (row / 3) * 3;
        int vColumn = (column / 3) * 3;
        for (int i = vRow; i < vRow + 3; i++) {
            for (int j = vColumn; j < vColumn + 3; j++) {
                if (board[i][j] == val) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        String[][] x = {{"5", "3", ".", ".", "7", ".", ".", ".", "."}, {"6", ".", ".", "1", "9", "5", ".", ".", "."}, {".", "9", "8", ".", ".", ".", ".", "6", "."}, {"8", ".", ".", ".", "6", ".", ".", ".", "3"}, {"4", ".", ".", "8", ".", "3", ".", ".", "1"}, {"7", ".", ".", ".", "2", ".", ".", ".", "6"}, {".", "6", ".", ".", ".", ".", "2", "8", "."}, {".", ".", ".", "4", "1", "9", ".", ".", "5"}, {".", ".", ".", ".", "8", ".", ".", "7", "9"}};
        char[][] chars = new char[9][9];
        for (int i = 0; i < chars.length; i++) {
            for (int j = 0; j < chars[i].length; j++) {
                chars[i][j] = x[i][j].charAt(0);
            }
        }
        new SudokuSolver().solveSudoku(chars);
    }
}
