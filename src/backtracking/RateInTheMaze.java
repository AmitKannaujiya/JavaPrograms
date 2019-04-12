package backtracking;

/**
 * Created by amit on 10/4/19.
 */
public class RateInTheMaze {

    public static void main(String[] args) {
        int maze[][]  = { {1, 0, 0, 0},
            {1, 1, 0, 1},
            {0, 1, 0, 0},
            {1, 1, 1, 1}
        };

        solveMaze(maze);

    }

    static void solveMaze(int[][] a) {
        int sol[][]  = { {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0}
        };

        if(solveMazeUtils(a, 0,0, sol)) {
            printSolution(sol);
        } else{
            System.out.println("No Solution");
        }

    }

    static boolean solveMazeUtils(int a[][], int i, int j, int sol[][]){
        if(i== 3 && j==3) {
            sol[i][j]=1;
            return true;
        }
        if(isSafe(a, i, j)) {
            sol[i][j]=1;
            if(solveMazeUtils(a, i+1, j, sol)) {
                return true;
            }
            if(solveMazeUtils(a, i, j+1, sol)) {
                return true;
            }
            sol[i][j]=0;
            return false;
        }
        return false;
    }

   static boolean isSafe(int[][]a, int i, int j) {
        if((i<4 && i>=0 )&& (j<4 && j>=0) & a[i][j]==1) {
            return true;
        }
        return false;
    }

    static void printSolution(int sol[][])
    {
        for (int i = 0; i < 4; i++)
        {
            for (int j = 0; j < 4; j++)
                System.out.print(" " + sol[i][j] +
                        " ");
            System.out.println();
        }
    }
}
