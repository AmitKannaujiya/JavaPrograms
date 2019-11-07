package bst;

/**
 * Created by amit on 15/3/19.
 */
public class SearchInBSTTusharRoy {

    public static void main(String[] args) {

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

        SearchInBSTTusharRoy obj = new SearchInBSTTusharRoy();
        System.out.println(obj.searchKey(root, 7));

        System.out.println(obj.searchKey(root, 8));

        System.out.println(obj.searchKey(root, 4));

        System.out.println(obj.searchKey(root, 14));

        System.out.println(obj.searchKey(root, 10));

    }

    boolean searchKey(BST<Integer> root, int key) {
        if (root == null) {
            return false;
        }
        if (root.data == key) {
            return true;
        }
        if (root.data > key) {
            return searchKey(root.left, key);
        }
        return searchKey(root.right, key);
    }
}
