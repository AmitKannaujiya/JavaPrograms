package algoMadeEasyBook;


import Utills.Utills;
import bst.BST;

public class ConstructBSTFromInorder {
    public static void main(String[] args) {
        int []  array = new int[]{10,20,25,28,32,34,50};
        ConstructBSTFromInorder oBstFromInorder = new ConstructBSTFromInorder();
        BST<Integer> root = oBstFromInorder.constructBST(array, 0, array.length-1, null);
        oBstFromInorder.inorder(root);
        int [] array2 = new int[]{5, 10, 40, 30, 28};
        System.out.println();
        BST<Integer> root2 = oBstFromInorder.constructBST(array2, 0, array2.length-1, null);
        oBstFromInorder.inorder(root2);
        //6,7,8,2,7,1,3,9,null,1,4,null,null,null,5


    }

    private void inorder(BST<Integer> root) {
        if(root != null) {
            inorder(root.left);
            System.out.println(root.data);
            inorder(root.right);
        }
    }

    private BST<Integer> constructBST(int[] array, int start, int end, BST<Integer> root) {
        if(start > end) {
            return null;
        }
        int mid = (start + end) / 2;
        root = new BST<Integer>(array[mid]);
        root.left = constructBST(array, start, mid -1, root);
        root.right = constructBST(array, mid + 1, end, root);
        return root;
    }
}