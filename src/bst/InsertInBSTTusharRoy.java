package bst;

import Utills.Utills;
import bst.traversal.PreOrderTraversal;

/**
 * Created by amit on 15/3/19.
 */
public class InsertInBSTTusharRoy {

    public static void main(String[] args) throws IllegalAccessException {

        BST<Integer> root = new BST<>(12);
        root.left = new BST<>(5);
        root.right = new BST<>(15);
        root.left.left = new BST<>(3);
        root.left.right = new BST<>(8);
        root.right.left = new BST<>(13);
        root.right.right = null;
        root.left.left.left = null;
        root.left.left.right = new BST<>(4);
        root.left.right.left = null;
        root.left.right.right = new BST<>(9);

        root.right.left.left = null;
        root.right.left.right = new BST<>(14);

        InsertInBSTTusharRoy obj = new InsertInBSTTusharRoy();
        //obj.insertIntoBinaryTree(root, 6);
//        LevelOrderChange orderChange = new LevelOrderChange();
//        orderChange.printlevelorder(root);
        PreOrderTraversal orderTraversal = new PreOrderTraversal();
        orderTraversal.preorderIterative(root);
        System.out.println();
        orderTraversal.inorderIterative(root);

        obj.insertIntoBinaryTree(root, 6);
        System.out.println();
        orderTraversal.preorderIterative(root);
        System.out.println();
        orderTraversal.inorderIterative(root);
        System.out.println();
        System.out.println(Utills.isSameBSTTree(root, root));

        System.out.println("Size of tree " + Utills.sizeOfTree(root));


    }

    public BST<Integer> insertIntoBinaryTree(BST<Integer> root, int data) {

        BST<Integer> node = new BST<>(data);
        if (root == null) {
            return node;
        }
        BST<Integer> current = root;
        BST<Integer> parent = null;
        while (current != null) {
            parent = current;
            if (current.data > data) {
                current = current.left;
            } else {
                current = current.right;
            }
        }
        if (parent.data > data) {
            parent.left = node;
        } else {
            parent.right = node;
        }

        return parent;
    }


}
