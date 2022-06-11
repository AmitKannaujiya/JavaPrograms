package algoMadeEasyBook;

public class MaxRactangleSubMatrixOf1s {
    public static void main(String[] args) {
        int M[][] = {{0, 1, 1, 0, 1},
                {1, 1, 0, 1, 0},
                {0, 1, 1, 1, 0},
                {1, 1, 1, 1, 0},
                {1, 1, 1, 1, 1},
                {0, 0, 0, 0, 0}};

        MaxRactangleSubMatrixOf1s obj =new MaxRactangleSubMatrixOf1s();
        int max = obj.maxRactanglematrixOf1(M, M.length, M[0].length);

    }

    public int maxRactanglematrixOf1(int[][] matrix, int m,int n) {
        int max = 0;
        int max_i = 0;
        int max_j = 0;
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(matrix[i][j] == 1){
                    max = getMinSumOfMatrix(matrix, m,n, i,j);
                }
            }
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if(max < matrix[i][j]) {
                    max = matrix[i][j];
                    max_i = i;
                    max_j = j;
                }
            }
        }
        for (int i = max_i; i > max_i - max ; i--) {

            for (int j = max_j; j > max_j-max ; j--) {
                System.out.print(matrix[i][j] + " ");

            }
            System.out.println();
        }
        return max;
    }

    private int getMinSumOfMatrix(int[][] matrix, int m, int n, int i, int j) {
        if(i >= m  || j >= n ) {
            return 0;
        }
        if(matrix[i][j] == 0) {
            return 0;
        }
        return 1 + Math.min(Math.min(getMinSumOfMatrix(matrix, m,n, i+1, j), getMinSumOfMatrix(matrix, m, n, i, j+1)), getMinSumOfMatrix(matrix, m,n, i+1,j+1));
    }
}
