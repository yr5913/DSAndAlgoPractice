package arrays3;

public class Search2DMatrix {
    public boolean searchMatrix(int[][] matrix, int target) {
        return searchMatrixRow2(matrix, target, 0, matrix.length * matrix[0].length - 1);
    }

    public boolean searchMatrixRow2(int[][] matrix, int target, int start, int end) {
        if (start > end)
            return false;
        int mid = (start + end) / 2;
        if (matrix[mid / matrix[0].length][mid % matrix[0].length] > target)
            end = mid - 1;
        else if (matrix[mid / matrix[0].length][mid % matrix[0].length] < target)
            start = mid + 1;
        else
            return true;
        return searchMatrixRow2(matrix, target, start, end);
    }

    public boolean searchMatrixRow(int[][] matrix, int target, int start, int end) {
        if (start > end)
            return false;
        int mid = (start + end) / 2;
        if (matrix[mid][0] > target)
            end = mid - 1;
        else if (matrix[mid][matrix[mid].length - 1] < target)
            start = mid + 1;
        else
            return binarySearch(matrix[mid], target, 0, matrix[mid].length - 1);
        return searchMatrixRow(matrix, target, start, end);
    }

    public boolean binarySearch(int[] array, int target, int start, int end) {
        if (start > end)
            return false;
        int mid = (start + end) / 2;
        if (array[mid] > target)
            end = mid - 1;
        else if (array[mid] < target)
            start = mid + 1;
        else
            return true;
        return binarySearch(array, target, start, end);
    }

    public static void main(String[] args) {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {3, 30, 34, 60}};
        new Search2DMatrix().searchMatrix(matrix, 3);
    }
}
