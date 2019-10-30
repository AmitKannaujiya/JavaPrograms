package bst;

/**
 * Created by amit on 15/4/19.
 */
public class LeftViewTest {

    public static void main(String[] args) {
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
        LeftViewTest obj = new LeftViewTest();
        obj.leftView(root);
        int x= 12;
        System.out.println(x& x-1);

    }
    void leftViewUtills(BST<Integer> tree, int level, int maxLevel) {
        if(tree==null) {
            return;
        }
        if(maxLevel < level) {
            System.out.println("Node : " + tree.data + " level : " + level);
            maxLevel = level;
        }
        leftViewUtills(tree.left, level +1, maxLevel);
        leftViewUtills(tree.right, level +1, maxLevel);
    }

    void leftView(BST<Integer> tree) {
        leftViewUtills(tree, 1, 0);
    }
}
