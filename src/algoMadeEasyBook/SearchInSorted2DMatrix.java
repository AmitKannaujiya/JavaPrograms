package algoMadeEasyBook;

public class SearchInSorted2DMatrix {
    public static void main(String[] args) {
        int[][] matrix = { { 0, 6, 8, 9, 11 },
                { 20, 22, 28, 29, 31 },
                { 36, 38, 50, 61, 63 },
                { 64, 66, 100, 122, 128 } };
        int n = matrix.length;
        int m = matrix[0].length;
        int key = 61;
        SearchInSorted2DMatrix obj =new SearchInSorted2DMatrix();
        obj.findElementInSortedArray(matrix, n-1, m-1, key);

    }

    void findElementInSortedArray(int[][] matrix, int n, int m, int key) {
        int low = 0;
        int high = n-1;
        int mid = low + (high - low)/2;
        while (low < high) {

            if (matrix[mid][0] == key) {
                System.out.println("found element at : row " + mid + " column " + 0);
                return;
            }
            if (matrix[mid][m - 1] == key) {
                System.out.println("found element at : row " + mid + " column " + (mid - 1));
                return;
            }
            if (matrix[mid][0] < key && matrix[mid][m - 1] > key) {
                int index = binarySearchOnMatrix(matrix, mid, 0, m - 1, key);
                if(index == -1) {
                    System.out.println("Element not found");
                    return;
                } else {
                    System.out.println("found element at : row " + mid + " column " + index);
                    return;
                }
            }
            if (matrix[mid][0] > key) {
                high = mid - 1;
            }
            if (matrix[mid][m - 1] < key) {
                low = mid + 1;
            }
        }

    }

    private int binarySearchOnMatrix(int[][] matrix, int mid, int i, int j, int key) {
        int low = 0;
        int high = j;
        while (low < high) {
            int m = low+(high-low)/2;
            if(matrix[mid][m] == key) {
                return m;
            }else if (matrix[mid][m] > key) {
                low = m +1;
            } else {
                high = mid - 1;
            }
        }
        return -1;
    }

}
