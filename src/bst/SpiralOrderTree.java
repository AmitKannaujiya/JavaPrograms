package bst;

import java.util.Stack;

/**
 * Created by amit on 28/7/18.
 */
public class SpiralOrderTree {

    public static void main(String[] args) {
        BST<Integer> root2 = new BST<>(4);
        root2.left = new BST<>(2);
        root2.right = new BST<>(5);
        root2.left.left = new BST<>(1);
        root2.left.right = new BST<>(3);
        SpiralOrderTree spiralOrderTree = new SpiralOrderTree();
        spiralOrderTree.spiralPrint(root2);

        BST<Integer> root1 = new BST<>(1);
        root1.left = new BST<>(2);
        root1.right = new BST<>(3);
        root1.left.left = new BST<>(4);
        root1.left.right = new BST<>(5);
        root1.right.left = new BST<>(6);
        root1.right.right = new BST<>(7);

        root1.left.left.left = new BST<>(8);
        root1.left.right.left = new BST<>(9);
        root1.right.right.right = new BST<>(10);
        spiralOrderTree.spiralPrint(root1);


    }

    void spiralPrint(BST<Integer> root) {
        System.out.println("#############Spiral Print Of Tree############");
        if (root == null)
            return;

        Stack<BST> stack1 = new Stack<>();
        Stack<BST> stack2 = new Stack<>();
        stack1.push(root);
        while (!stack1.empty() || !stack2.empty()) {
            while (!stack1.empty()) {
                BST node = stack1.pop();
                if (node.right != null) {
                    stack2.push(node.right);
                }

                if (node.left != null) {
                    stack2.push(node.left);
                }
                System.out.print(node.data + " ");
            }
            System.out.println();
            while (!stack2.empty()) {
                BST node1 = stack2.pop();
                if (node1.left != null) {
                    stack1.push(node1.left);
                }

                if (node1.right != null) {
                    stack1.push(node1.right);
                }
                System.out.print(node1.data + " ");
            }
            System.out.println();
        }

    }
}
