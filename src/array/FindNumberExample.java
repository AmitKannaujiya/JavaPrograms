package array;

/**
 * Created by amit on 14/4/19.
 */
public class FindNumberExample {

    public static void main(String[] args) {
        int a[] = {1,1,1,2,2,2,3,3,4,5,8,10,10,12};

        FindNumberExample obj = new FindNumberExample();
        System.out.println(obj.findNumber(a, 0, a.length-1));
    }

    int findNumber(int a[], int start, int end) {
        if(start > end) {
            return -1;
        }
        int mid = (start + end)/2;
        if(a[start] == 0) {
            return start;
        }

        if(a[mid]==mid && a[mid-1] < mid) {
            return mid;
        }
        if(a[mid+1] <= mid+1 && a[mid] == mid) {

        }

        if(a[mid] >= mid ) {
            return findNumber(a, start, mid - 1);
        }else{
            return findNumber(a, mid+1, end);
        }

    }
}
