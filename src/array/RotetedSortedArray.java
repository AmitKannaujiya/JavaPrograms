package array;

/**
 * Created by amit on 3/8/18.
 */
public class RotetedSortedArray {

    public static void main(String[] args) {
        int a[] = {3, 4, 5, 0, 1, 2};
        RotetedSortedArray obj = new RotetedSortedArray();
        System.out.println(obj.findElement(a, 2, 0, a.length - 1));
        System.out.println(obj.search(a, 1, 0, a.length - 1));

    }

    int search(int a[], int key, int low, int high) {
        if (low > high)
            return -1;
        int mid = (low + high) / 2;
        if (a[mid] == key)
            return mid;

        if (a[mid] >= a[low]) {
            if (key >= a[low] && a[mid] >= key)
                return search(a, key, low, mid - 1);
            return search(a, key, mid + 1, high);
        }

        if (key >= a[mid] && key < a[high])
            return search(a, key, mid + 1, high);
        return search(a, key, low, mid - 1);

    }

    int findElement(int a[], int key, int low, int n) {
        int pivot = findPivot(a, low, n);
        if (pivot == -1)
            return -1;
        if (a[pivot] == key) {
            return pivot;
        }
        if (a[0] < key) {
            return binarySearch(a, key, low, pivot - 1);
        } else {
            return binarySearch(a, key, pivot + 1, n);
        }
    }

    int binarySearch(int a[], int key, int low, int high) {
        if (low > high)
            return -1;
        int mid = (high + low) / 2;
        if (a[mid] == key)
            return mid;
        if (a[mid] > key) {
            return binarySearch(a, key, low, mid - 1);
        }
        return binarySearch(a, key, mid + 1, high);
    }

    int findPivot(int a[], int low, int n) {
        int mid = (low + n) / 2;
        if (low > n)
            return -1;
        if (low == n)
            return low;
        if (mid < n && a[mid] > a[mid + 1])
            return mid;
        if (low < mid && a[mid] < a[mid - 1])
            return mid - 1;
        if (a[low] <= a[mid])
            return findPivot(a, mid + 1, n);

        return findPivot(a, low, mid - 1);
    }

}
