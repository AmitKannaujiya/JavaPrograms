package array;


public class FloodFillLeetCode {
    public static void main(String[] args) {
        FloodFillLeetCode obj = new FloodFillLeetCode();
        int [][] image = {{0,0,0},{0,1,1}};
        int sr = 1;
        int sc = 1;
        int oldColor = 1;
        obj.dfs(image, sr, sc, image.length-1, image[0].length, newColor, oldColor);
    }
    private boolean isValid(int[][] image, int i, int j, int row, int col, int oldColor) {
        if(i < 0 || i > row) {
            return false;
        }
        if(j < 0  || j > col) {
            return false;
        }
        if(image[i][j] == oldColor) {
            return true;
        }
        return false;
    }
    
    private void dfs(int[][] image, int i, int j, int row,int col, int newColor, int oldColor) {
        if(!isValid(image, i, j, row, col, oldColor)) {
            return;
        }
        image[i][j] = newColor;
        dfs(image, i+1, j, row, col, newColor, oldColor);
        dfs(image, i, j+1, row, col, newColor, oldColor);
        dfs(image, i-1, j, row, col, newColor, oldColor);
        dfs(image, i, j-1, row, col, newColor, oldColor);
    }
}