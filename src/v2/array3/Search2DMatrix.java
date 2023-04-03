package v2.array3;

public class Search2DMatrix {


    public boolean searchMatrix(int[][] matrix, int target) {
        int rows = matrix.length;
        int columns = matrix[0].length;
        int start = 0;
        int end = rows * columns - 1;
        while (start <= end) {
            int mid = (end + start) / 2;
            int row = mid / columns;
            int column = mid % columns;
            if (matrix[row][column] == target)
                return true;
            else if (matrix[row][column] > target) {
                end = mid - 1;
            } else
                start = mid + 1;
        }
        return false;
    }
}
