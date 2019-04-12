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
