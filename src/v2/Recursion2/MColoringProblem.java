package v2.Recursion2;

public class MColoringProblem {


    // Function to determine if graph can be coloured with at most M colours
    // such
    // that no two adjacent vertices of graph are coloured with same colour.
    public boolean graphColoring(boolean graph[][], int m, int n) {
        return graphColoringRec(graph, m, n, 0, new int[n]);
    }

    public boolean graphColoringRec(boolean graph[][], int m, int n, int index, int[] color) {
        if (index == n) {
            return true;
        }
        for (int i = 1; i <= m; i++) {
            if (!isConnected(graph, index, color, i)) {
                color[index] = i;
                boolean ret = graphColoringRec(graph, m, n, index + 1, color);
                if (ret)
                    return true;
                else
                    color[index] = 0;
            }

        }
        return false;
    }

    public boolean isConnected(boolean graph[][], int index, int[] color, int currentColor) {
        for (int i = 0; i < index; i++) {
            if (graph[i][index] || graph[index][i]) {
                if (color[i] == currentColor) {
                    return true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) {
        boolean[][] graph = new boolean[4][4];
        graph[0][1] = true;
        graph[1][2] = true;
        graph[2][3] = true;
        graph[3][0] = true;
        graph[0][2] = true;
        new MColoringProblem().graphColoring(graph, 3, 4);
    }
}
