package matrix;

/**
 * Created by amit on 9/12/18.
 */
public class RotateAntiClockWiseMatrix {

    public static void main(String[] args) {
        int N = 4;

        // Test Case 1
        int mat[][] =
                {
                        {1, 2, 3, 4},
                        {5, 6, 7, 8},
                        {9, 10, 11, 12},
                        {13, 14, 15, 16}
                };

        int mat2[][] = {

                        {1,  2,  3},
                        {4,  5,  6},
                        {7,  8,  9}

        };

        int N2=3;

        //rotateMatrixClockWise(N,mat);
        //rotateMatrix(N,mat);
        displayMatrix(N2,mat2);
//        transpose(mat);
//        reverseColumns(mat);

        rotateMatrix180(mat2, N2-1);

        // Print rotated matrix
        displayMatrix(N2,mat2);
    }

    // After transpose we swap elements of
    // column one by one for finding left
    // rotation of matrix by 90 degree
    static void reverseColumns(int arr[][])
    {
        for (int i = 0; i < arr[0].length; i++)
            for (int j = 0, k = arr[0].length - 1;
                 j < k; j++, k--) {
                int temp = arr[j][i];
                arr[j][i] = arr[k][i];
                arr[k][i] = temp;
            }
    }

    // Function for do transpose of matrix
    static void transpose(int arr[][])
    {
        for (int i = 0; i < arr.length; i++)
            for (int j = i; j < arr[0].length; j++) {
                int temp = arr[j][i];
                arr[j][i] = arr[i][j];
                arr[i][j] = temp;
            }
    }

    static void rotateMatrix180(int arr[][],int n) {

        for (int i = 0; i < arr.length /2; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                int temp = arr[i][j];
                arr[i][j] = arr[n - i][n - j];
                arr[n - i][n - j] = temp;
            }
        }
        System.out.println("Here");
    }

    static void displayMatrix(int N, int mat[][])
    {
        for (int i = 0; i < N; i++)
        {
            for (int j = 0; j < N; j++)
                System.out.print(" " + mat[i][j]);

            System.out.print("\n");
        }
        System.out.print("\n");
    }
    static void rotateMatrixClockWise(int N, int [][] matrix) {
        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j <N-i -1; j++) {
                int temp = matrix[i][j];
                // left  to top
                matrix[i][j] = matrix[N-1-j][i];
                // bottom to left
                matrix[N-1-j][i] = matrix[N-1-i][N-1-j];
                // right to bottom
                matrix[N-1-i][N-1-j] = matrix[j][N-1-i];

                matrix[j][N-1-i] = temp;

                //
//        int temp = mat[x][y];
//
//        // move values from right to top
//        mat[x][y] = mat[y][N-1-x];
//
//        // move values from bottom to right
//        mat[y][N-1-x] = mat[N-1-x][N-1-y];
//
//        // move values from left to bottom
//        mat[N-1-x][N-1-y] = mat[N-1-y][x];
//
//        // assign temp to left
//        mat[N-1-y][x] = temp;
            }
        }
    }

    static void rotateMatrix(int N, int [][] matrix) {
//
//        int temp = mat[x][y];
//
//        // move values from right to top
//        mat[x][y] = mat[y][N-1-x];
//
//        // move values from bottom to right
//        mat[y][N-1-x] = mat[N-1-x][N-1-y];
//
//        // move values from left to bottom
//        mat[N-1-x][N-1-y] = mat[N-1-y][x];
//
//        // assign temp to left
//        mat[N-1-y][x] = temp;

        for (int i = 0; i < N / 2; i++) {
            for (int j = i; j <N-i -1; j++) {
                int temp = matrix[i][j];
                // right to top
                matrix[i][j] = matrix[j][N-i-1];
                //bottom to right
                matrix[j][N-i-1] = matrix[N-i-1][N-j-1];
                //left to bottom
                matrix[N-i-1][N-j-1] = matrix[N-1-j][i];

                // top to left
                matrix[N-1-j][i] = temp;

//                        int temp = matrix[i][j];
//
//        // move values from right to top
//                matrix[i][j] = matrix[j][N-1-i];
//
//        // move values from bottom to right
//                matrix[j][N-1-i] = matrix[N-1-i][N-1-j];
//
//        // move values from left to bottom
//                matrix[N-1-i][N-1-j] = matrix[N-1-j][i];
//
//        // assign temp to left
//                matrix[N-1-j][i] = temp;

            }

        }
    }
}
