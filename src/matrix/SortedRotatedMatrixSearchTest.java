package matrix;

/**
 * Created by amit on 16/5/19.
 */
public class SortedRotatedMatrixSearchTest {

    public static void main(String[] args) {
        int a[][] = new int[][] {
                {1,2,3,4,5},
                {6,7,8,9,10},
                {11,12,13,14,15},
                {16,17,18,19,20}
        };
        SortedRotatedMatrixSearchTest obj = new SortedRotatedMatrixSearchTest();
        System.out.println(obj.searchInRotatedArray(a, 14, 5, 4));

    }

    int searchInRotatedArray(int a[][], int x, int n, int m) {
        int i = 0, j=m-1;
        for (;i < n; i++) {
            if(a[i][j] == x) {
                return x;
            }else if(a[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return -1;
    }
}
