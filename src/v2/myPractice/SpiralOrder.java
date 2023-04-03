package v2.myPractice;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder {

    public List<Integer> spiralOrder(int[][] matrix) {
        int x = 0;
        int y = 0;
        int lowerBound = 0;
        int upperBoundX = matrix.length;
        int upperBoundY = matrix[0].length;
        int total = matrix.length * matrix[0].length;
        int count = 0;
        int loop = 0;
        List<Integer> list = new ArrayList<>();
        while (true) {
            if (count == total) {
                break;
            }
            if (loop == 0) {
                while (y < upperBoundY) {
                    list.add(matrix[x][y++]);
                    count++;
                }
                y--;
                x++;
            } else if (loop == 1) {
                while (x < upperBoundX) {
                    list.add(matrix[x++][y]);
                    count++;
                }
                x--;
                y--;
            } else if (loop == 2) {
                while (y >= lowerBound) {
                    list.add(matrix[x][y--]);
                    count++;
                }
                y++;
                x--;
            } else {
                lowerBound++;
                upperBoundY--;
                upperBoundX--;
                while (x >= lowerBound) {
                    list.add(matrix[x--][y]);
                    count++;
                }
                x++;
                y++;
                loop = -1;
            }
            loop++;
        }
        return list;
    }

    public static void main(String[] args) {
        int[][] arr = {{1, 2, 3, 4}, {4, 5, 6, 7}, {7, 8, 9, 10}};
        System.out.println(new SpiralOrder().spiralOrder(arr));
    }
}
