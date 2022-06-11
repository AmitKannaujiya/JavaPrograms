package algoMadeEasyBook;

import Utills.Utills;

import java.util.LinkedList;
import java.util.Queue;

public class FloodFill {
    public static void main(String[] args) {
        int data[][] = {{ 1, 1, 1, 1, 1, 1, 1, 1 },
                { 1, 1, 1, 1, 1, 1, 0, 0 },
                { 1, 0, 0, 1, 1, 0, 1, 1 },
                { 1, 2, 2, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 0, 1, 0 },
                { 1, 1, 1, 2, 2, 2, 2, 0 },
                { 1, 1, 1, 1, 1, 2, 1, 1 },
                { 1, 1, 1, 1, 1, 2, 2, 1 }};
        int m = data.length-1;
        int n = data[0].length-1;
        int i= 4;
        int j= 4;
        int newCol =3;
        int[][] visited = new int[m+1][n+1];
        FloodFill obj =new FloodFill();
        obj.bfs(data,m,n, i,j,newCol,visited );
        for (int k = 0; k <= m; k++) {
            for (int l = 0; l <= n; l++) {
                System.out.print(data[k][l] + " ");
            }
            System.out.println();
        }
    }

    public void bfs(int [][] matrix, int m, int n, int i,int j, int newCol,int[][] visited) {
        Queue<Point> queue=new LinkedList<>();
        int oldColor = matrix[i][j];
        matrix[i][j] = newCol;
        visited[i][j] = 1;
        Point p = new Point(i, j);
        queue.add(p);

        while (!queue.isEmpty()) {
            Point point = queue.remove();
            if(isValidPoint(matrix, m,n,point.x+1,point.y,oldColor, visited)) {
                matrix[point.x+1][point.y] = newCol;
                visited[point.x+1][point.y] = 1;
                queue.add(new Point(point.x+1, point.y));
            }
            if(isValidPoint(matrix, m,n,point.x-1,point.y,oldColor,visited)) {
                matrix[point.x-1][point.y] = newCol;
                visited[point.x-1][point.y] = 1;
                queue.add(new Point(point.x-1, point.y));
            }
            if(isValidPoint(matrix, m,n,point.x,point.y+1,oldColor,visited)) {
                matrix[point.x][point.y+1] = newCol;
                visited[point.x][point.y+1] = 1;
                queue.add(new Point(point.x, point.y+1));
            }
            if(isValidPoint(matrix, m,n,point.x,point.y-1,oldColor, visited)) {
                matrix[point.x][point.y-1] = newCol;
                visited[point.x][point.y-1] = 1;
                queue.add(new Point(point.x, point.y-1));
            }
        }

    }

    public boolean isValidPoint(int [][] matrix, int m, int n, int i,int j, int oldCol,int[][] visited) {
        if(i < 0 || j < 0 || i > m || j > n) {
            return false;
        }
        if(matrix[i][j] != oldCol) {
            return false;
        }
        if(visited[i][j] == 1) {
            return false;
        }
        return true;
    }
}

class Point {
    int x;
    int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
}