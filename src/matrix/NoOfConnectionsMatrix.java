package matrix;

/**
 * Created by amit on 30/12/18.
 */
public class NoOfConnectionsMatrix {

    public static void main(String[] args) {
        int M[][]=  new int[][] {
                {1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}
        };
        NoOfConnectionsMatrix I = new NoOfConnectionsMatrix();
        System.out.println("Number of islands is: "+ I.countNoOfConnection(M, 5, 5));
    }

    private int countNoOfConnection(int[][] m, int i, int j) {
        int count = 0;
        for (int k = 0; k < i; k++) {

            for (int l = 0; l < j; l++) {
                if(m[k][l]== 1) {
                    // left
                    if(isSafe(m, k, l+1, i, j)) {
                        count++;
                    }
                    //right
                    if(isSafe(m, k, l-1, i, j)) {
                        count++;
                    }
                    // up
                    if(isSafe(m, k+1, l, i, j)) {
                        count++;
                    }
                    // down
                    if(isSafe(m, k-1, l, i, j)) {
                        count++;
                    }
                    m[k][l] = 2;

                }
            }

        }

        printMatrix(m,i,j);
        return count;
    }

    private void printMatrix(int[][]m, int r, int c) {
        for (int i = 0; i < r; i++) {

            for (int j = 0; j < c; j++) {
                System.out.print(m[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private boolean isSafe(int[][]m, int i, int j, int R, int C) {
        return (i>= 0 && i< R) && (j>=0 && j<C) && (m[i][j]==1);
    }
}
