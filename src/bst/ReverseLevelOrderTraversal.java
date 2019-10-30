package bst;

import Utills.Stack;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by amit on 2/4/19.
 */
public class ReverseLevelOrderTraversal {

    public static void main(String[] args) throws IllegalAccessException {
        BST<Integer> root = new BST<>(1);
        root.left = new BST<>(2);
        root.right = new BST<>(3);
        root.left.left = new BST<>(4);
        root.left.right = new BST<>(5);
        root.right.left = new BST<>(6);
        root.right.right = new BST<>(7);
        root.left.left.left = new BST<>(8);
        root.left.left.right =  new BST<>(9);
        root.left.right.left = new BST<>(10);
        root.left.right.right = new BST<>(11);

        ReverseLevelOrderTraversal obj = new ReverseLevelOrderTraversal();
        obj.reverseOrderTraversal(root);

        obj.reverseLevelOrderTraversalRecursive(root);
    }

    void reverseLevelOrderTraversalRecursive(BST<Integer> root) {
        int height = heightOfTree(root);
        System.out.println("\n###### Recursive Level Order Traversal #######");
        for (int i = 1; i <= height; i++) {
            reverseLevelOrderTraversalRecursiveUtills(root, i);
            System.out.println();
        }

        System.out.println("\n###### Recursive Reverse Level Order Traversal #######");
        for (int i = height; i >=1; i--) {
            reverseLevelOrderTraversalRecursiveUtills(root, i);
            System.out.println();
        }

        System.out.println("\n###### Recursive Reverse alternate Level Order Traversal #######");
        boolean b = false;
        for (int i = height; i >=1; i--) {
            reverseLevelOrderTraversalRecursiveUtills(root, i, b);
            System.out.println();
            b ^= true;
        }
    }

    void reverseLevelOrderTraversalRecursiveUtills(BST<Integer> root, int level, boolean itr) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data+ " ");
        } else {
            if(itr) {
                reverseLevelOrderTraversalRecursiveUtills(root.left, level -1);
                reverseLevelOrderTraversalRecursiveUtills(root.right, level -1);
            } else {
                reverseLevelOrderTraversalRecursiveUtills(root.right, level -1);
                reverseLevelOrderTraversalRecursiveUtills(root.left, level -1);
            }

        }
    }

    void reverseLevelOrderTraversalRecursiveUtills(BST<Integer> root, int level) {
        if(root == null) {
            return;
        }
        if(level == 1) {
            System.out.print(root.data+ " ");
        } else {
            reverseLevelOrderTraversalRecursiveUtills(root.left, level -1);
            reverseLevelOrderTraversalRecursiveUtills(root.right, level -1);
        }
    }

    int heightOfTree(BST<Integer> root) {
        if(root == null) {
            return 0;
        }
        int left = heightOfTree(root.left);
        int right = heightOfTree(root.right);

        if(left > right) {
            return left + 1;
        }
        return right +1;
    }
    void reverseOrderTraversal(BST<Integer> root) throws IllegalAccessException {
        Queue<BST<Integer>> queue = new ArrayDeque<>();
        Stack<Integer> stack = new Stack<Integer>();

        if(root == null) {
            return;
        }
        queue.add(root);
        queue.add(new BST<>(-1));
        while (!queue.isEmpty()) {
            BST node= queue.remove();
            if (node!= null && (int)node.data != -1){
                if(node.right!=null) {
                    queue.add(node.right);
                }
                if(node.left!=null) {
                    queue.add(node.left);
                }

                stack.push((int)node.data);
            } else {
                if(!queue.isEmpty()) {
                    queue.add(node);
                    stack.push(-1);
                }
            }

        }

        while (!stack.isEmpty()) {
            Integer d = stack.pop();
            if(d!= -1) {
                System.out.print(d.toString()+" ");
            } else {
                System.out.println();
            }
        }
    }
}
