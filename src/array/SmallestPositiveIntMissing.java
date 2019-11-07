package array;

/**
 * Created by amit on 3/6/19.
 */
public class SmallestPositiveIntMissing {


    public static void main(String[] args) {
        int a[] = {1, 3, 6, 4, 1, 2};
        SmallestPositiveIntMissing obj = new SmallestPositiveIntMissing();
    }

    int smallestMissingNo(int a[]) {
        int b[] = new int[a.length + 1];
        int missingNo = 1;
        for (int i = 0; i < a.length; i++) {
            if (b[i] == missingNo++) {
                missingNo++;
            } else {
                missingNo--;
            }
        }
        return missingNo;
    }

}

