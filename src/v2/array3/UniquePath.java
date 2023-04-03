package v2.array3;

public class UniquePath {
    private int count = 0;

    public int uniquePathsOne(int m, int n) {
        int[][] matrix = new int[m][n];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                matrix[i][j] = -1;
            }
        }
        return foundLast(matrix, 0, 0, m - 1, n - 1);
    }

    public int foundLast(int[][] matrix, int i, int j, int m, int n) {
        if (i > m || j > n) {
            return 0;
        }
        if (matrix[i][j] != -1) {
            return matrix[i][j];
        }
        if (i == m && j == n) {
            return 1;
        }
        matrix[i][j] = foundLast(matrix, i + 1, j, m, n) + foundLast(matrix, i, j + 1, m, n);
        return matrix[i][j];
    }


    public int uniquePaths(int m, int n) {
        int x = m-1;
        int y = n-1;
        int c = Math.min(m-1, n-1);
        int upper = x+y;
        double numerator = 1;
        double demoninator = 1;
        for(int i=1;i<=c;i++){
            numerator*=(upper-i+1);
            demoninator*=(i);
        }
        return (int) (numerator/demoninator);
    }

    public static void main(String[] args) {
        System.out.println(new UniquePath().uniquePaths(3, 7));
    }
}
