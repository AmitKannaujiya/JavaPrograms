package algoMadeEasyBook;

import bst.BST;
import java.util.Stack;

public class ConstructBSTFromPreorder {
    public static void main(String[] args) {
        ConstructBSTFromPreorder obj = new ConstructBSTFromPreorder();
        int[] preorder = new int[] { 25, 15, 12, 20, 18, 30, 28, 26, 40 };
        obj.constructBST(preorder);
    }

    public BST<Integer> constructBST(int[] preorder) {
        BST<Integer> bst = new BST<>(preorder[0]);
        Stack<BST> stack = new Stack<>();
        stack.push(bst);

        for (int i = 1; i < preorder.length; i++) {
            BST<Integer> node = null;
            while (!stack.isEmpty() && (int) stack.peek().data < preorder[i]) {
                node = stack.pop();
            }
            if (node != null) {
                node.right = new BST<Integer>(preorder[i]);
                stack.push(node.right);
            } else {
                stack.peek().left = new BST<Integer>(preorder[i]);
                stack.push(stack.peek().left);
            }
        }
        return bst;
    }
}