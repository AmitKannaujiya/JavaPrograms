package Revision;

public class SearchInSortedRotated {

    public static void main(String[] args) {
        int arr[] = {5, 6, 7, 8, 9, 10, 1, 2, 3};
        int key = 3;

        SearchInSortedRotated obj = new SearchInSortedRotated();
        System.out.println(obj.search1(arr, key));

        System.out.println(obj.search1(arr, 1));

        System.out.println(obj.search2(arr, 2, 0, arr.length - 1));

        System.out.println(obj.search2(arr, 8, 0, arr.length - 1));
    }

    public int search2(int a[], int key, int low, int high) {
        if (low > high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] == key) {
            return mid;
        }
        if (a[low] <= a[mid]) {
            if (key >= a[low] && key <= a[mid]) {
                return search2(a, key, low, mid - 1);
            }
            return search2(a, key, mid + 1, high);
        }
        if (key >= a[mid] && key <= a[high]) {
            return search2(a, key, mid + 1, high);
        }
        return search2(a, key, low, mid - 1);

    }


    public int search1(int a[], int key) {
        int pivot = findPivot(a, 0, a.length - 1);
        if (pivot == -1) {
            return -1;
        }

        if (a[pivot] == key) {
            return a[pivot];
        }
        if (a[0] > key) {
            return binarySearch(a, key, pivot + 1, a.length - 1);
        }
        return binarySearch(a, key, 0, pivot);
    }

    public int binarySearch(int a[], int key, int low, int high) {

        int mid = (low + high) / 2;
        if (a[mid] == key) {
            return mid;
        }

        //
        if (mid < high && a[mid] < key) {
            return binarySearch(a, key, mid + 1, high);
        }
        if (mid > low && a[mid] > key) {
            return binarySearch(a, key, low, mid - 1);
        }
        return -1;
    }

    public int findPivot(int a[], int low, int high) {
        // Base Cases
        if (high < low) {
            return -1;
        }
        if (high == low) {
            return low;
        }

        int mid = (low + high) / 2;
        if (mid < high && a[mid] > a[mid + 1]) {
            return mid;
        }
        if (mid > low && a[mid] < a[mid - 1]) {
            return mid - 1;
        }

        if (a[low] > a[mid]) {
            return findPivot(a, low, mid - 1);
        }
        return findPivot(a, mid + 1, high);
    }
}
