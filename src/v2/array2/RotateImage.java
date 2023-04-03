package v2.array2;

import v2.util.PrintHelper;

public class RotateImage {
    public void rotate(int[][] matrix) {
        transpose(matrix);
        mirror(matrix);
    }

    public void transpose(int[][] matrix) {
        for (int i = 1; i < matrix.length; i++) {
            for (int j = 0; j < i; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
    }

    public void mirror(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length / 2; j++) {
                swap(j, matrix[i].length - j - 1, matrix[i]);
            }
        }
    }

    private void swap(int pos1, int pos2, int[] nums) {
        int temp = nums[pos1];
        nums[pos1] = nums[pos2];
        nums[pos2] = temp;
    }

    public static void main(String[] args) {
        int[][] image = new int[3][3];
        int[] one = {1, 2, 3};
        int[] two = {9, 8, 7};
        int[] three = {5, 6, 7};
        image[0] = one;
        image[1] = two;
        image[2] = three;
        RotateImage rotateImage = new RotateImage();
        rotateImage.transpose(image);
        rotateImage.mirror(image);
        PrintHelper.printArrayTwoDimensional(image);
    }


}
