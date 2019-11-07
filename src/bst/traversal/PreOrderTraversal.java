package bst.traversal;

import Utills.Stack;
import bst.BST;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

/**
 * Created by amit on 22/7/18.
 */
public class PreOrderTraversal {

    public static void main(String[] args) throws IllegalAccessException {
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

        BST<Integer> root2 = new BST<>(4);
        root2.left = new BST<>(2);
        root2.right = new BST<>(5);
        root2.left.left = new BST<>(1);
        root2.left.right = new BST<>(3);
//        java.util.Stack<BST> stack = new java.util.Stack<>();
//        stack.empty();
//        stack.pop();
//        stack.push()
        Queue<BST> queue = new ArrayDeque<>();
        queue.remove();

        PreOrderTraversal obj = new PreOrderTraversal();

        System.out.println("##############PRE ORDER TRAVERSAL###############");
        obj.preorderRecursive(root2);
        System.out.println();
        obj.preorderIterative(root2);

        System.out.println("\n##############POST ORDER TRAVERSAL###############");
        obj.postorderRecursive(root2);
        System.out.println();
        obj.postorderIterative(root2);

        System.out.println("\n##############IN-ORDER TRAVERSAL###############");
        obj.inorderRecursive(root2);
        System.out.println();
        //obj.inorderIterativeV2(root2);
        System.out.println();
        obj.inorderIterative(root2);

        System.out.println("\n##############LEVEL ORDER TRAVERSAL###############");
        obj.inorderRecursive(root2);
        System.out.println();
    }


    public void preorderRecursive(BST<Integer> root) {
        if (root != null) {
            System.out.print(root.data + ", ");
            preorderRecursive(root.left);
            preorderRecursive(root.right);
        }

    }

    public void preorderIterative(BST<Integer> root) throws IllegalAccessException {
        if (root == null)
            return;

        Stack<BST> stack = new Stack<BST>();

        stack.push(root);
        while (!stack.isEmpty()) {
            BST node = stack.pop();
            System.out.print(node.data + ",");
            if (node.right != null) {
                stack.push(node.right);
            }
            if (node.left != null) {
                stack.push(node.left);
            }
        }

    }

    public void postorderRecursive(BST<Integer> root) {
        if (root != null) {
            postorderRecursive(root.left);
            postorderRecursive(root.right);
            System.out.print(root.data + ", ");
        }

    }

    public void postorderIterative(BST<Integer> root) throws IllegalAccessException {
        if (root == null)
            return;

        Stack<BST> stack1 = new Stack<BST>();
        Stack<BST> stack2 = new Stack<BST>();
        stack1.push(root);
        while (!stack1.isEmpty()) {
            BST node = stack1.pop();
            stack2.push(node);
            if (node.left != null) {
                stack1.push(node.left);
            }

            if (node.right != null) {
                stack1.push(node.right);
            }
        }

        while (!stack2.isEmpty()) {
            System.out.print(stack2.pop().data + ", ");
        }

    }

    public void inorderRecursive(BST<Integer> root) {
        if (root != null) {
            inorderRecursive(root.left);
            System.out.print(root.data + ", ");
            inorderRecursive(root.right);
        }

    }


    public void inorderIterative(BST<Integer> root) throws IllegalAccessException {
        if (root == null)
            return;

        Stack<BST> stack = new Stack<BST>();
        //stack.push(root);
        while (true) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            if (stack.isEmpty())
                break;
            //stack.pop();
            BST node = stack.pop();
            System.out.print(node.data + ", ");
            root = node.right;
            //stack.push(root);
        }
    }

    public void inorderIterativeV2(BST<Integer> root) throws IllegalAccessException {
        if (root == null)
            return;

        Stack<BST> stack = new Stack<BST>();
        stack.push(root);
        while (true) {
            if (root != null) {
                stack.push(root);
                root = root.left;
            } else {
                if (stack.isEmpty()) {
                    break;
                }

                root = stack.pop();
                System.out.print(root.data + ", ");
                root = root.right;
            }
        }
    }

    public void levelOrderTraversalV1(BST<Integer> root) {
        if (root == null)
            return;
        Queue<BST> queue = new ArrayDeque<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            ArrayList<Integer> list = new ArrayList<>();
            while (size > 0) {
                BST<Integer> node = queue.remove();
                list.add(node.data);
                if (node.left != null) {
                    queue.add(node.left);
                }
                if (node.right != null) {
                    queue.add(node.right);
                }
                size--;
            }
            for (Integer data : list) {
                System.out.print(data + " ");
            }
            System.out.println();
        }

    }

    public List<List<Integer>> levelOrderTraversal(BST<Integer> root) {
        if (root == null)
            return null;
        Queue<BST> queue = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        List<List<Integer>> pList = new ArrayList<>();

        queue.add(root);
        list.add(root.data);
        while (!queue.isEmpty()) {
            int size = queue.size();
            while (size > 0) {
                BST<Integer> node = queue.remove();
                List<Integer> list1 = pList.get(size);
                if (list1 == null) {
                    list1 = new ArrayList<>();
                }
                if (node.left != null) {

                }

            }

        }
        return pList;

    }


}
