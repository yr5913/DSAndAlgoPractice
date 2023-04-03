package v2.myPractice;

public class WordSearch {

    public boolean exist(char[][] board, String word) {
        char[] chars = word.toCharArray();
        int[] xInc = {1, -1, 0, 0};
        int[] yInc = {0, 0, 1, -1};
        int length = board.length;
        int width = board[0].length;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (isThere(length, width, i, j, chars, 0, board, xInc, yInc)) {
                    return true;
                }

            }
        }
        return false;

    }


    public boolean isThere(int length, int width, int x, int y, char[] chars, int index, char[][] board,
                           int[] xinc, int[] yinc) {
        if (x < 0 || x == length || y < 0 || y == width || board[x][y] != chars[index] || board[x][y] == '(') {
            return false;
        }
        if (index == chars.length - 1) {
            return true;
        }
        char temp = board[x][y];
        board[x][y] = '(';
        for (int i = 0; i < xinc.length; i++) {
            if (isThere(length, width, x + xinc[i], y + yinc[i], chars, index + 1, board, xinc, yinc)) {
                return true;
            }
        }
        board[x][y] = temp;
        return false;

    }

    public static void main(String[] args) {
        char[][] board = {{'A', 'B', 'C', 'E' }, {'S', 'F', 'E', 'S' }, {'A', 'D', 'E', 'E' }};
        new WordSearch().exist(board, "ABCESEEEFS");
    }
}
