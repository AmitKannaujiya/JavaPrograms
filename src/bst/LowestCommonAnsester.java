package bst;

/**
 * Created by amit on 29/7/18.
 */
public class LowestCommonAnsester {

    public static void main(String[] args) {
        BST<Integer> root2 = new BST<>(4);
        root2.left = new BST<>(2);
        root2.right = new BST<>(5);
        root2.left.left = new BST<>(1);
        root2.left.right = new BST<>(3);
        LowestCommonAnsester lca = new LowestCommonAnsester();
        System.out.println(lca.LowestCommonAnsester(root2, 2, 5));

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
        System.out.println(lca.LowestCommonAnsester(root1, 4, 7));


    }

    public int LowestCommonAnsester(BST<Integer> node, int node1, int node2) {
        if (node.data >= node1 && node.data <= node2)
            return node.data;
        else if (node.data > node1 && node.data > node2)
            return LowestCommonAnsester(node.left, node1, node2);
        else
            return LowestCommonAnsester(node.right, node1, node2);
    }
}
