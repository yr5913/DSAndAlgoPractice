package v2.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class NQueens {

    public List<List<String>> solveNQueens(int n) {
        int[][] board = new int[n][n];
        List<List<String>> ansList = new ArrayList<>();
        solveNQueensRec(0, ansList, board);
        return ansList;
    }

    public void solveNQueensRec(int index, List<List<String>> ansList, int[][] board) {
        if (index == board.length) {
            List<String> strList = new ArrayList<>();
            for (int i = 0; i < board.length; i++) {
                StringBuilder stringBuilder = new StringBuilder();
                for (int j = 0; j < board[i].length; j++) {
                    if (board[i][j] == 1) {
                        stringBuilder.append("Q");
                    } else
                        stringBuilder.append(".");
                }
                strList.add(stringBuilder.toString());
            }
            ansList.add(strList);
            return;
        }
        for (int i = 0; i < board[index].length; i++) {
            if (board[index][i] > -1) {
                board[index][i] = 1;
                boardFill(index, i, -1, board);
                solveNQueensRec(index + 1, ansList, board);
                board[index][i] = 0;
                boardFill(index, i, 1, board);
            }
        }

    }

    public void boardFill(int row, int column, int val, int[][] board) {
        for (int i = row + 1; i < board.length; i++) {
            board[i][column] += val;
        }
        int i = row + 1;
        int j = column - 1;
        int k = column + 1;
        while (i < board.length && (j >= 0 || k < board[i].length)) {
            if (j >= 0) {
                board[i][j] += val;
            }
            if (k < board[i].length) {
                board[i][k] += val;
            }
            i++;
            j--;
            k++;
        }
    }

    public static void main(String[] args) {
        new NQueens().solveNQueens(5);
    }
}
