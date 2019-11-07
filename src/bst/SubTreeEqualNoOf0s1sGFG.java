package bst;

import bst.traversal.PreOrderTraversal;

/**
 * Created by amit on 19/3/19.
 */
public class SubTreeEqualNoOf0s1sGFG {

    public static void main(String[] args) throws IllegalAccessException {

        BST<Integer> root = new BST<>(1);

        root.right = new BST<>(0);
        root.right.right = new BST<>(1);
        root.right.right.right = new BST<>(1);

        root.left = new BST<>(0);
        root.left.left = new BST<>(1);
        root.left.left.left = new BST<>(1);
        root.left.right = new BST<>(0);


        root.left.right.left = new BST<>(1);
        root.left.right.left.left = new BST<>(1);
        root.left.right.right = new BST<>(0);
        root.left.right.right.left = new BST<>(1);
        root.left.right.right.left.left = new BST<>(1);


        PreOrderTraversal orderTraversal = new PreOrderTraversal();
        orderTraversal.preorderIterative(root);
        System.out.println();
        orderTraversal.inorderIterative(root);
        System.out.println();

        SubTreeEqualNoOf0s1sGFG obj = new SubTreeEqualNoOf0s1sGFG();
        // obj.sumTree(root);
        boolean hasValidSubTree = false;
        // obj.size(root, hasValidSubTree);

        obj.convert(root);
        obj.sumTreeV2(root);
        obj.checkTree(root, hasValidSubTree);

        orderTraversal.preorderIterative(root);
        System.out.println();
        System.out.println();
        orderTraversal.levelOrderTraversalV1(root);
        System.out.println();
        if (hasValidSubTree) {
            System.out.println("Has Valid SubTree");
        } else {
            System.out.println("Not Has Valid SubTree");
        }

    }

    public int sumTree(BST<Integer> root) {
        int a = 0, b = 0;
        if (root == null) {
            return 0;
        }
        if (root.left != null) {
            a = sumTree(root.left);
        }
        if (root.right != null) {
            b = sumTree(root.right);
        }

        root.data += a + b;
        return root.data;
    }

    public int size(BST<Integer> root, boolean hasValidSubTree) {
        int a = 0, b = 0;
        if (root == null || hasValidSubTree) {
            return 0;
        }

        a = size(root.left, hasValidSubTree);

        a = a + 1;

        b = size(root.right, hasValidSubTree);

        a = a + b;

        if (a % 2 == 0 && root.data == a / 2) {
            hasValidSubTree = true;
        }

        return a;
    }


    public void convert(BST<Integer> root) {
        if (root == null) {
            return;
        }
        convert(root.left);
        if (root.data == 0) {
            root.data = -1;
        }

        convert(root.right);
    }

    public int sumTreeV2(BST<Integer> root) {
        int a = 0, b = 0;
        if (root == null) {
            return 0;
        }
        a = sumTreeV2(root.left);
        b = sumTreeV2(root.right);
        root.data = root.data + a + b;
        return root.data;
    }

    public boolean checkTree(BST<Integer> root, boolean hasValidTree) {
        if (root == null) {
            return false;
        }
        if (!hasValidTree) {
            hasValidTree = checkTree(root.left, hasValidTree);
        }


        if (root.data == 0) {
            hasValidTree = true;
            return hasValidTree;
        }

        if (!hasValidTree) {
            hasValidTree = checkTree(root.right, hasValidTree);
        }
        return hasValidTree;

    }
}
