package v2.myPractice;

/**
 * https://leetcode.com/problems/battleships-in-a-board/
 * 419. Battleships in a Board
 * Given an m x n matrix board where each cell is a battleship 'X' or empty '.', return the number of the battleships on board.
 * <p>
 * Battleships can only be placed horizontally or vertically on board. In other words, they can only be made of the shape 1 x k (1 row, k columns) or k x 1 (k rows, 1 column), where k can be of any size. At least one horizontal or vertical cell separates between two battleships (i.e., there are no adjacent battleships).
 */
public class BattleShipsOnBoard {

    public int countBattleships(char[][] board) {
        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == 'X') {
                    count++;
                    int newX = i;
                    int newY = j + 1;
                    while (newY < board[i].length && board[i][newY] == 'X') {
                        board[i][newY++] = '.';
                    }
                    newX = i + 1;
                    newY = j;
                    while (newX < board.length && board[newX][newY] == 'X') {
                        board[newX++][newY] = '.';
                    }
                }
            }
        }
        return count;
    }
}
