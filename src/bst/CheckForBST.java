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


    }
}
