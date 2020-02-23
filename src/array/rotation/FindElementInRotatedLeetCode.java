package array.rotation;

public class FindElementInRotatedLeetCode {

    public static void main(String[] args) {
        FindElementInRotatedLeetCode obj = new FindElementInRotatedLeetCode();
        obj.findElementInSortedArray();
    }

    private void findElementInSortedArray() {
        int[] array = new int[]{4,5,6,7,0,1,2};
        int target = 0;
        System.out.println(binarySearchModified(array, target, 0, array.length-1));

        array = new int[] {1, 3, 5};
        target = 3;
        System.out.println(binarySearchModified(array, target, 0, array.length-1));

        array = new int[] {1,3,1,1,1};

        target = 3;
        System.out.println(binarySearchModified2(array, target, 0, array.length-1));

    }

    boolean binarySearchModified2(int a[], int target, int low, int high) {
        if(low > high) {
            return false;
        }

        int mid = (low + high)/2;
        if(a[mid] == target) {
            return true;
        }
        while((low < a.length && a[low] == a[mid] ) && (high > 0 && a[mid] == a[high])) {
            if(a[low] == target) {
                return true;
            }
            low++;
            high--;
        }
        if(high < 0 || low>= a.length) {
            return false;
        }
        if(a[low] <= a[mid]) {
            if(target >= a[low] && target < a[mid]) {
                return binarySearchModified2(a, target, low, mid -1);
            }
            return binarySearchModified2(a, target, mid +1, high);
        }
        if(target > a[mid] && target <= a[high]) {
            return binarySearchModified2(a, target, mid +1, high);
        }
        return binarySearchModified2(a, target, low, mid-1);
    }

    int getPivotPoint(int a[], int low, int high) {

        if (low > high) {
            return -1;
        }
//        if (low == high) {
//            return low;
//        }
        int mid = (low + high) / 2;
        if (mid < high && a[mid] > a[mid + 1]) {
            return mid;
        } else if (mid > low && a[mid] < a[mid - 1]) {
            return mid - 1;
        } else if (a[mid] > a[high]) {
            return getPivotPoint(a, mid + 1, high);
        } else {
            return getPivotPoint(a, low, mid - 1);
        }
    }

    int binarySearch(int a[], int target, int low, int high) {
        if(low >  high) {
            return -1;
        }
        int mid = (low + high) / 2;
        if (a[mid] == target) {
            return mid;
        } else if (a[mid] > target) {
            return binarySearch(a, target, low, mid - 1);
        } else {
            return binarySearch(a, target, mid + 1, high);
        }

    }

    int binarySearchModified(int a[], int target, int low, int high) {
        int pivot = getPivotPoint(a, low, high);
        if (pivot == -1) {
            return binarySearch(a, target, low, high);
        }
        if (a[pivot] == target) {
            return pivot;
        }

        if(a[low] > target ) {
            return binarySearch(a, target, pivot+1, high);
        } else {
            return binarySearch(a, target,low, pivot-1);
        }
    }

}
