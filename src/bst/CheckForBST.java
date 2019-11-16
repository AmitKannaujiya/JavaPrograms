package bst;

import Utills.Utills;

/**
 * Created by amit on 17/7/18.
 */
public class CheckForBST {

    public static void main(String[] args) {
        BST<Integer> root = new BST<>(1);
        root.left = new BST<>(2);
        root.right = new BST<>(3);
        root.left.left = new BST<>(4);
        root.left.right = new BST<>(5);
        root.right.left = new BST<>(6);
        root.right.right = new BST<>(7);
        root.left.left.left = new BST<>(8);
        root.left.left.right = new BST<>(9);
        root.left.right.left = new BST<>(10);
        root.left.right.right = new BST<>(11);
        System.out.println("Check If BST " + Utills.isBST(root));

//        struct node *root = newNode(4);
//        root->left        = newNode(2);
//        root->right       = newNode(5);
//        root->left->left  = newNode(1);
//        root->left->right = newNode(3);
        BST<Integer> root2 = new BST<>(4);
        root2.left = new BST<>(2);
        root2.right = new BST<>(5);
        root2.left.left = new BST<>(1);
        root2.left.right = new BST<>(3);

        System.out.println("Check If BST Second " + Utills.isBST(root2));
        BST<Integer> root3 =new BST<>(5);
        root3.left = new BST<>(1);
        root3.right = new BST<>(4);
        root3.right.left=new BST<>(3);
        root3.right.right = new BST<>(6);
        System.out.println("Check If BST Second2 " + isBinaryTree(root3));

        root3 =new BST<>(5);
        root3.left = new BST<>(1);
        root3.right = new BST<>(6);
        root3.right.left=new BST<>(4);
        root3.right.right = new BST<>(7);
        System.out.println("Check If Second3 " + isBinaryTree(root3));

        root3 =new BST<>(5);
        root3.left = new BST<>(1);
        root3.right = new BST<>(6);
        root3.right.left=new BST<>(7);
        root3.right.right = new BST<>(8);
        System.out.println("Check If Second4 " + isBinaryTree(root3));

        root3 =new BST<>(5);
        root3.left = new BST<>(1);
        root3.right = new BST<>(7);
        root3.right.left=new BST<>(6);
        root3.right.right = new BST<>(8);
        System.out.println("Check If Second5 " + isBinaryTree(root3));
    }

   static boolean isBinaryTree(BST<Integer> root) {
        if(root== null)
            return true;
        return isBinaryTree(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

   static boolean isBinaryTree(BST<Integer> root, int minValue, int maxValue) {

        if(root==null) {
            return true;
        }

        if(root.data > maxValue || root.data < minValue) {
            return false;

        }

        return isBinaryTree(root.left, minValue, root.data-1) && isBinaryTree(root.right, root.data+1, maxValue);

    }
}
