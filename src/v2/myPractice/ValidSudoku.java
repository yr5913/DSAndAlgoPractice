package v2.myPractice;

public class ValidSudoku {
    public boolean isValidSudoku(char[][] board) {
        boolean[][][] visited = new boolean[board.length][3][9];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                char current = board[i][j];
                if (current == '.') {
                    continue;
                }
                int val = current - '0';
                if (visited[i][0][val] == true) {
                    return false;
                }
                if (visited[j][1][val] == true) {
                    return false;
                }
                int x = i / 3;
                int y = j / 3;
                int xCoordinate = y * 3 + x;
                if (visited[xCoordinate][2][val] == true) {
                    return false;
                }
                visited[i][0][val] = true;
                visited[j][1][val] = true;
                visited[xCoordinate][2][val] = true;

            }
        }
        return true;

    }
}
