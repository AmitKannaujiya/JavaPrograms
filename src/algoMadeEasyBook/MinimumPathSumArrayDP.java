package algoMadeEasyBook;

public class MinimumPathSumArrayDP {
    public static void main(String[] args) {
        int [][] grid = {{1,3,1},{1,5,1},{4,2,1}};
        //System.out.println();
        MinimumPathSumArrayDP obj = new MinimumPathSumArrayDP();
        System.out.println(obj.minPathSum(grid));
    }

    public int minPathSum(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        //return minPathSum(grid, 0, 0, m, n);
        return minPathSum(grid, 0, 0, m, n, 0);
    }
    private int minPathSum(int [][] grid, int i, int j, int m, int n, int sum) {
        if(i>= m || j>= n ) {
            return sum;
        }
        sum += grid[i][j];
        if(i== m-1 && j== n-1) {
            return sum;

        } else if(i<m && j<n) {
            return  Math.min(minPathSum(grid, i+1, j, m, n, sum), minPathSum(grid, i, j+1, m, n, sum));
        } else if(i<m) {
            return minPathSum(grid, i+1, j, m, n,sum);
        }
        return  minPathSum(grid, i, j+1, m, n, sum);
    }
    private int minPathSum(int [][] grid, int i, int j, int m, int n) {
        int sum =0;
        if(i>= m || j>= n ) {
            return sum;
        }

        if(i<m && j<n) {
            sum = grid[i][j] + Math.max(minPathSum(grid, i+1, j, m, n), minPathSum(grid, i, j+1, m, n));
        } else if(i<m) {
            sum = grid[i][j] + minPathSum(grid, i+1, j, m, n);
        } else {
            sum = grid[i][j] + minPathSum(grid, i, j+1, m, n);
        }
        return sum;
    }
}
