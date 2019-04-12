package array;

/**
 * Created by amit on 30/10/18.
 */
public class ArrayRotation {

    public static void main(String[] args) {

        int a [] = {1,2,3,4,5,6,7,8,9,10,11,12};
        int d = 3;

        ArrayRotation arrayRotation =  new ArrayRotation();
        a = arrayRotation.rotationArray(a,  d, a.length);
        for (int i = 0; i < a.length; i++) {
            System.out.println(a[i]);
        }


    }

    public int[] rotationArray(int a[], int d, int n) {
        int gcd = gcd(d, n);
        for (int i = 0; i < gcd; i++) {
            int temp = a[i];
            int j = i;

            while (true) {
                int k = j + d;
                if (k >= n)
                    k = k - n;

                if(k==i)
                    break;

                a[j] = a[k];
                j = k;
            }
            a[j] = temp;

        }

        return a;
    }


    public int gcd(int a, int b) {
        if(b == 0)
            return a;
        return gcd(b, b%a);
    }
}
