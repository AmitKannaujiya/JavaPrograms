package array.rotation;

/**
 * Created by amit on 8/3/19.
 */
public class SearchInRoted {

    public static void main(String[] args) {
        int [] a = {6,7,8,9,10,1,2,3,4,5};
        System.out.println(search(a,0, 9, 11));
        System.out.println(searchp(a,0, 9, 11));

        System.out.println(search(a,0, 9, 8));
        System.out.println(searchp(a,0, 9, 8));

        System.out.println(search(a,0, 9, 5));
        System.out.println(searchp(a,0, 9, 5));

        System.out.println(search(a,0, 9, 6));
        System.out.println(searchp(a,0, 9, 6));
    }

    static int search(int a[], int l, int n, int key) {
        if(l > n) {
            return -1;
        }
        int mid= (l+n)/2;
        if(a[mid] == key){
            return mid;
        }

        if(a[l] <= a[mid]) {

            if(a[l] <= key && key <= a[mid]) {
                return search(a, l, mid-1,key);
            }
            return search(a, mid+1, n, key);
        }

            if(a[mid] <= key && key <= a[n]) {
                return search(a, mid+1,n,key);
            }
            return search(a, l, mid-1, key);

    }

    static  int binarySearch(int a[], int l, int n, int key) {
        if (l>n) {
            return -1;
        }
        int mid= (l+n)/2;
        if(a[mid] == key){
            return mid;
        }
        if(a[mid] > key ) {
            return binarySearch(a, l, mid-1, key);
        }
        return binarySearch(a, mid +1, n, key);
    }

    static int pivot(int a[], int l, int n) {
        if(l> n) {
            return -1;
        }
        if(n==l) {
            return l;
        }
        int mid= (l+n)/2;
        if(mid <n && a[mid] > a[mid+1]) {
            return mid;
        }
        if(mid > l && a[mid-1] > a[mid]) {
            return mid -1;
        }
        if(a[l]>=a[mid]) {
            return pivot(a, l, mid-1);
        }
        return pivot(a, mid+1, l);
    }

    static int searchp(int a[], int l, int n, int key) {
        int pivot = pivot(a, l, n);
        if(pivot==-1)
            return binarySearch(a, l, n, key);
        if(a[pivot] == key)
            return pivot;
        if(a[0] > key) {
            return binarySearch(a, pivot+1, n, key);
        }
        return binarySearch(a, l, pivot-1, key);

//        if(a[pivot] > key && key >= a[n]) {
//            return binarySearch(a, pivot+1, n, key);
//        }
//        return binarySearch(a, l, pivot-1, key);
    }


}
