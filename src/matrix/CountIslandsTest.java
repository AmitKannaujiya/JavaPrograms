package matrix;

/**
 * Created by amit on 30/12/18.
 */
public class CountIslandsTest {
    //No of rows and columns
    static final int ROW = 3, COL = 4;

    public static void main(String[] args) {
//        int M[][]=  new int[][] {{1, 1, 0, 0, 0},
//                {0, 1, 0, 0, 1},
//                {1, 0, 0, 1, 1},
//                {0, 0, 0, 0, 0},
//                {1, 0, 1, 0, 1}
//        };
        int M[][] = new int[][]{
                {1, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 0, 0, 1}
        };
        CountIslandsTest I = new CountIslandsTest();
        System.out.println("Number of islands is: " + I.countIslands(M));
    }

    private int countIslands(int[][] m) {
        int[][] visited = new int[ROW][COL];
        int count = 0;
        for (int i = 0; i < ROW; i++) {
            for (int j = 0; j < COL; j++) {
                if (visited[i][j] != 1 && m[i][j] == 1) {
                    dfs(m, i, j, visited);

                    count++;
                }
            }
        }
        return count;

    }

    private void dfs(int[][] m, int i, int j, int[][] visited) {
        int[] rows = new int[]{-1, -1, -1, 0, 0, 1, 1, 1};
        int[] cols = new int[]{-1, 0, 1, -1, 1, -1, 0, 1};
        visited[i][j] = 1;
        for (int k = 0; k < 8; k++) {
            if (isSafe(m, i + rows[k], j + cols[k], visited)) {
                dfs(m, i + rows[k], j + cols[k], visited);
            }
        }

    }

    private boolean isSafe(int[][] m, int i, int j, int[][] visited) {

        return (i >= 0 && i < ROW) && (j >= 0 && j < COL) && (m[i][j] == 1 && visited[i][j] != 1);
    }
}
