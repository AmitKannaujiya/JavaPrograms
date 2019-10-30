package array;

public class LongestAlternatSubSeq {

//    Input : a[] = {1, -5, 1, -5}
//    Output : For index 0, {1, -5, 1, -5} = 4
//    index 1, {-5, 1, -5} = 3
//    index 2, {1, -5} = 2
//    index 3, {-5} = 1.
//
//    Input :a[] = {-5, -1, -1, 2, -2, -3}
//    Output : index 0 = 1,
//    index 1 = 1,
//    index 2 = 3,
//    index 3 = 2,
//    index 4 = 1,
//    index 5 = 1,

    public static void main(String[] args) {
        int a[] = { -5, -1, -1, 2, -2, -3 };
        int n = 6;
        longestAlternating(a, n);
    }

    private static void longestAlternating(int[] a, int n) {
        int count[] = new int[n];
        count[n-1] = 1;
        for (int i = n-2; i >=0; i--) {
            if(a[i] * a[i+1] < 0) {

                count[i] = count[i+1] +1 ;
            } else {
                count[i] =1;
            }
        }

        for (int i : count) {
          System.out.println(i + " ");
        }
    }
}
