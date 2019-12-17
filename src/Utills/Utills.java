package Utills;

import bst.BST;

import java.util.ArrayList;
import java.util.Iterator;

/**
 * Created by amit on 14/7/18.
 */
public class Utills {

    public static int maxElementOfArray(int a[]) {
        int max = Integer.MIN_VALUE;
        for (int i : a) {
            if (i > max) {
                max = i;
            }
        }
        return max;
    }

    public static void swapArray(int a[], int i, int j) {
        int temp = a[i];
        a[i] = a[j];
        a[j] = temp;
    }

    public static int max(int a, int b) {
        return a > b ? a : b;
    }

    public static boolean isBST(BST<Integer> root) {
        return isBSTUtills(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private static boolean isBSTUtills(BST<Integer> root, int minValue, int maxValue) {
        if (root == null) {
            return true;
        }
        if (root.data > maxValue || root.data < minValue) {
            return false;
        }
        return isBSTUtills(root.left, minValue, root.data - 1) && isBSTUtills(root.right, root.data + 1, maxValue);
    }

    public static boolean isSameBSTTree(BST<Integer> root1, BST<Integer> root2) {
        if (root1 == null && root2 == null) {
            return true;
        }
        if (root1 == null || root2 == null) {
            return false;
        }

        return root1.data == root2.data && isSameBSTTree(root1.left, root2.left) && isSameBSTTree(root1.right, root2.right);
    }

    public static int sizeOfTree(BST<Integer> root) {
        if (root == null) {
            return 0;
        }
        int left = sizeOfTree(root.left);
        int right = sizeOfTree(root.right);
        return left + right + 1;
    }

    public static void printArray(int a[]) {
        for (int i : a) {
            System.out.print(i + ", ");
        }
        System.out.println();
    }

    public static void printArrayList(ArrayList<String> arrayList) {
        System.out.println("List Contents : ");
        Iterator iterator = arrayList.listIterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println(count + ") " + iterator.next());
        }
    }
    public static void printArrayListInteger(ArrayList<Integer> arrayList) {
        System.out.println("List Contents : ");
        Iterator iterator = arrayList.listIterator();
        int count = 1;
        while (iterator.hasNext()) {
            System.out.println(count + ") " + iterator.next());
        }
    }

    public static double getMedian(int a[]) {
        int len = a.length;
        if (len % 2 == 0) {
            return (a[len / 2] + a[len / 2 - 1]) / 2.0;
        }
        return a[len / 2];
    }
}
