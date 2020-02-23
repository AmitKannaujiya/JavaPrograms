package bst;

public class LCABinaryTree {
    static boolean v1 = false;
    static boolean v2 =  false;
    public static void main(String[] args) {
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

        BST lca = findLCA(root1, 4, 9);
        System.out.println(lca !=null ? lca.data : "Node");

        /*
              1
              /\
             2  3
            /\  /\
           4  5 6 7
          /  /    \
         8   9      10

         */

    }

    static BST findLCA(BST<Integer> root, int n1, int n2) {
        if(root == null) {
            return null;
        }

        BST<Integer> node = findLCAUtills(root, n1, n2);
        if(v1 && v2) {
            return node;
        }
        return null;
    }

    static BST findLCAUtills(BST<Integer> root, int n1, int n2) {
        if(root == null) {
            return null;
        }
        BST<Integer> node = null;
        if(root.data == n1) {
            v1 = true;
            node = root;
        }
        if(root.data == n2) {
            v2 = true;
            node = root;
        }

        BST<Integer> left = findLCAUtills(root.left, n1, n2);
        BST<Integer> right = findLCAUtills(root.right, n1, n2);
        if(node !=null) {
            return node;
        }
        if(left != null && right !=null) {
            return root;
        }
        return left != null ? left : right;
    }

    


}
