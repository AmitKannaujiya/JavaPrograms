package practice;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

public class AmazonTestFeb {
    public static void main(String[] args) {
        int rows =5;
        int columns = 5;
        int[][] array = new int[][]{{1, 0, 0, 0, 0}, {0,1,0,0,0}, {0,0,1,0,0}, {0,0,0,1,0}, {0,0,0,0,1}};
        int hours = 0;
        int noOfZero =rows;
//        int currentNo = 1;
//        do{
//            noOfZero = 0;
//            for(int i=0; i< rows; i++) {
//                for(int j=0; j<columns; j++) {
//                    if(array[i][j] == 1) {
//                        dfs(array, i, j, rows, columns);
//                    }
//                }
//            }
//
//            hours++;
//             for(int i=0; i< array.length; i++) {
//                 for(int j =0; j< array[i].length; j++) {
//                     if(array[i][j] == -1) {
//                         array[i][j] = 1;
//                     } else if(array[i][j]== 0) {
//                         noOfZero++;
//                     }
//                 }
//             }
//
//        } while (noOfZero !=0);
//        System.out.println(hours);

//        List<String> list = Arrays.asList("C", "C++", "Java");
//        String[] a = list.toArray(new String[list.size()]);
//        System.out.println(Arrays.toString(a));
//
//        List<Integer> list2 = Arrays.asList(1,2,3);
//        Integer[] b = list2.stream().toArray(Integer[]::new);
//        System.out.println(b);
//        System.out.println("Am,it.".replaceAll("[^a-zA-z]"," ").toLowerCase());


    }

    private static void dfs(int[][] grid, int i, int j, int row, int col) {
        if(i< 0 || j<0 || i> row-1 || j> col-1  || grid[i][j] != 1 ) {
            return;
        }
        grid[i][j]= -1;
        if(isValid(i+1, j, row, col)) {
            grid[i+1][j]= -1;
        }
        if(isValid(i-1, j, row, col)) {
            grid[i-1][j]= -1;
        }
        if(isValid(i, j+1, row, col)) {
            grid[i][j+1]= -1;
        }
        if(isValid(i, j-1, row, col)) {
            grid[i][j-1]= -1;
        }

        dfs(grid, i, j+1, row, col);
        dfs(grid, i, j-1, row, col);
        dfs(grid, i+1, j, row, col);
        dfs(grid, i-1, j, row, col);
    }

    private static boolean isValid(int i, int j, int row, int col) {
        if(i< 0 || j<0 || i> row-1 || j> col-1 ) {
            return false;
        }
        return true;
    }
}
