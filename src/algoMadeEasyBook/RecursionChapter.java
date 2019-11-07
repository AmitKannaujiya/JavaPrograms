package algoMadeEasyBook;

/**
 * Created by amit on 19/3/19.
 */
public class RecursionChapter {

    public static void main(String[] args) {
        RecursionChapter recursionChapter = new RecursionChapter();
        System.out.println(recursionChapter.fab(9));

        recursionChapter.printNto1(new int[]{1, 2, 3, 4, 5, 6}, 5);

        recursionChapter.towerOfHenoi(3, 5, 10, 4);

        System.out.println(recursionChapter.isSorted(new int[]{1, 2, 3, 4, 5, 6}, 6));

        recursionChapter.generateBinary(new int[]{0, 0, 0}, 3);

        recursionChapter.kArryString(new int[]{0, 0, 0}, 3, 3);

    }

    public int fab(int n) {
        if (n == 0) {
            return 1;
        } else if (n == 1) {
            return 1;
        } else {
            return n * fab(n - 1);
        }
    }

    public void printNto1(int a[], int n) {
        if (n < 0) {
            return;
        }
        System.out.println(a[n]);
        printNto1(a, n - 1);
        //System.out.println(a[n]);

    }

    public void towerOfHenoi(int n, int fromPeg, int toPeg, int auxPeg) {
        if (n == 1) {
            System.out.println(" Transfering 1 peg from " + fromPeg + " toPeg " + toPeg + " using auxPeg " + auxPeg);
            return;
        }
        towerOfHenoi(n - 1, fromPeg, auxPeg, toPeg);

        System.out.println(" Transfering n " + n + " peg from " + fromPeg + " toPeg " + auxPeg + " using auxPeg " + toPeg);

        towerOfHenoi(n - 1, auxPeg, toPeg, fromPeg);
    }

    public boolean isSorted(int a[], int n) {
        if (n == 1) {
            return true;
        }

        if (a[n - 1] < a[n - 2]) {
            return false;
        }
        return isSorted(a, n - 1);
    }

    public void generateBinary(int a[], int n) {
        if (n < 1) {
            System.out.println();
            for (int i : a) {
                System.out.print(i);
            }
        } else {
            a[n - 1] = 0;
            generateBinary(a, n - 1);
            a[n - 1] = 1;
            generateBinary(a, n - 1);
        }
    }

    public void kArryString(int a[], int n, int k) {
        if (n < 1) {
            System.out.println();
            for (int i : a) {
                System.out.print(i);
            }
        } else {
            for (int i = 0; i < k; i++) {
                a[n - 1] = i;
                kArryString(a, n - 1, k);
            }
        }
    }
}
