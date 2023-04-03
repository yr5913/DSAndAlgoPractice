package v2.Recursion2;

import java.util.ArrayList;
import java.util.List;

public class RatInMaze {
    public static ArrayList<String> findPath(int[][] m, int n) {
        // Your code here
        if (m[n - 1][n - 1] == 0 || m[0][0] == 0)
            return new ArrayList<>();
        ArrayList<String> ansList = new ArrayList<>();
        m[0][0] = 0;
        findPathRec(m, 0, 0, ansList, new ArrayList<>());
        return ansList;
    }

    public static void findPathRec(int[][] m, int i, int j, ArrayList<String> ans, List<Character> characters) {
        if (i == m.length - 1 && j == m.length - 1) {
            StringBuilder stringBuilder = new StringBuilder();
            for (int k = 0; k < characters.size(); k++) {
                stringBuilder.append(characters.get(k));
            }
            ans.add(stringBuilder.toString());
            return;
        }
        if (isValid(m, i + 1, j)) {
            characters.add('D');
            m[i + 1][j] = 0;
            findPathRec(m, i + 1, j, ans, characters);
            m[i + 1][j] = 1;
            characters.remove(characters.size() - 1);
        }

        if (isValid(m, i, j + 1)) {
            characters.add('R');
            m[i][j + 1] = 0;
            findPathRec(m, i, j + 1, ans, characters);
            m[i][j + 1] = 1;
            characters.remove(characters.size() - 1);
        }
        if (isValid(m, i, j - 1)) {
            characters.add('L');
            m[i][j - 1] = 0;
            findPathRec(m, i, j - 1, ans, characters);
            m[i][j - 1] = 1;
            characters.remove(characters.size() - 1);
        }

        if (isValid(m, i - 1, j)) {
            characters.add('U');
            m[i - 1][j] = 0;
            findPathRec(m, i - 1, j, ans, characters);
            m[i - 1][j] = 1;
            characters.remove(characters.size() - 1);
        }
    }

    public static boolean isValid(int[][] m, int i, int j) {
        return !(i < 0 || i == m.length || j < 0 || j == m.length || m[i][j] == 0);
    }
}
