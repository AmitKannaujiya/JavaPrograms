/**
 * Created by amit on 5/3/19.
 */
public class PureNumber {

    public static void main(String[] args) {
        for (int i = 1; i < 16; i++) {
            find(i);
        }
    }

    static int getNthPureNumber(int n) {
        int a = 4;
        int b = 5;
        String last = "";
        int size = 2;
        for (int i = 0; i < n; i++) {

        }

        return a;
    }

//    int generateNum(int size) {
//        String c = "";
//        int a = 4;
//        int b = 5;
//        for (int i = 0; i < size; i++) {
//            c +=String.valueOf(a);
//        }
//    }


    static void find(int n)
    {
        // An array of strings to store first n numbers. arr[i] stores i'th number
        String[] arr = new String[n+1];

        // arr[0] stores the empty string (String with 0 digits)
        arr[0] = "";

        // size indicates number of current elements in arr[], m indicates
        // number of elements added to arr[] in previous iteration
        int size = 1, m = 1;

        // Every iteration of following loop generates and adds 2*m numbers to
        // arr[] using the m numbers generated in previous iteration
        while (size <= n)
        {
            // Consider all numbers added in previous iteration, add a prefix
            // "3" to them and add new numbers to arr[]
            for (int i=0; i<m && (size+i)<=n; i++)
                arr[size + i] = "3" + arr[size - m + i];

            // Add prefix "4" to numbers of previous iteration and add new
            // numbers to arr[]
            for (int i=0; i<m && (size + m + i)<=n; i++)
                arr[size + m + i] = "4" + arr[size - m + i];

            // Update no. of elements added in previous iteration
            m = m << 1; // Or m = m*2;

            // Update size
            size = size + m;
        }
        System.out.println(arr[n]);
    }
}
