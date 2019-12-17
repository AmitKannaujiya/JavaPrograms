package bst;

public class BSTInorderSuccesor {
    public static void main(String[] args) {
        BST<Integer> root = new BST<>(20);
        root.left = new BST<>(8);
        root.right = new BST<>(22);
        root.left.left = new BST<>(4);

        root.left.right = new BST<>(12);
        root.left.right.left = new BST<>(10);
        root.left.right.right = new BST<>(14);
        System.out.println("Inorder travesal ");
        inorderTraversal(root);
        System.out.println();
        getInorderSuccessor(root, root.left.left);

        getInorderSuccessor(root, root.left);
        getInorderSuccessor(root, root.right);

        getInorderSuccessor(root, root.left.right);
        getInorderSuccessor(root, root.left.right.left);
        getInorderSuccessor(root, root.left.right.right);

        
    }
    static void inorderTraversal(BST<Integer> root) {
        if(root != null) {
            inorderTraversal(root.left);
            System.out.print(root.data + " ");
            inorderTraversal(root.right);
        }
    }

    static void getInorderSuccessor(BST<Integer> root, BST<Integer> node) {
        BST<Integer> succ = getInorderSuccesor(root, node);
        if(succ != null) {
            System.out.println("Inorder succesor of " + node.data +"  is " + succ.data);
        } else {
            System.out.println("No Inorder succesor of " + node.data );
        }
    }

    static BST<Integer> getMinimumValueNode(BST<Integer> node) {
        while(node.left !=null) {
            node = node.left;
        }
        return node;
    }

    static BST<Integer> getInorderSuccesor(BST<Integer> root, BST<Integer> node) {
        if(root == null || node == null) {
            return null;
        }
        if(node.right != null) {
            return getMinimumValueNode(node.right);
        }
        BST<Integer> temp = root;
        BST<Integer> succ = null;
        while(temp !=null ) {

            if(temp.data > node.data) {
                succ = temp;
                temp = temp.left;
            }else if(temp.data < node.data) {
                temp = temp.right;
            } else {
                break;
            }
        }
        return succ;
    }
}
