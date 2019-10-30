package array;

/**
 * Created by amit on 21/5/19.
 */
public class Sort01Arrays {

    public static void main(String[] args) {
        int[] a = {1,0,1,0,1,0,0,1,0};
        Sort01Arrays obj = new Sort01Arrays();
        obj.sort01Array(a);
        for (int i = 0; i < a.length; i++) {
            System.out.print(a[i] + " ");
        }
        System.out.println("\nSorting done");

    }

    public void sort01Array(int a[]) {
        int start = 0; int end= a.length-1;
        while (start < end) {
            while (a[start] == 0) {
                start++;
            }
            while (a[end] == 1) {
                end--;
            }
            if(start < end) {
                swap(a, start, end);
            }
        }
    }

    public void swap(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j]= temp;
    }
}
