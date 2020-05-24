package algoMadeEasyBook;

import javax.lang.model.element.Element;

import Utills.Utills;
import bst.BST;
import jdk.jshell.execution.Util;

public class ConstructBSTFromInorder {
    public static void main(String[] args) {
        int []  array = new int[]{10,20,25,28,32,34,50};
        ConstructBSTFromInorder oBstFromInorder = new ConstructBSTFromInorder();
        BST<Integer> root = oBstFromInorder.constructBST(array, 0, array.length-1, null);
        oBstFromInorder.inorder(root);
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