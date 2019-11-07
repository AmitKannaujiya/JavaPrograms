package bst;

public class DiameterOfTree {
    public static void main(String[] args) {
 /* Constructed binary tree is
            1
          /   \
        2      3
      /  \
    4     5
  */
        BST root = new BST(1);
        root.left = new BST(2);
        root.right = new BST(3);
        root.left.left = new BST(4);
        root.left.right = new BST(5);
        System.out.println(diameter2(root));

        System.out.println(diameter(root));

    }

    static int height(BST tree) {
        if (tree == null) {
            return 0;
        }
        return Math.max(height(tree.left), height(tree.right)) + 1;
    }

    static int diameter2(BST tree) {
        if (tree == null) {
            return 0;
        }
        int lh = height(tree.left);
        int rh = height(tree.right);

        int ldia = diameter2(tree.left);
        int rdia = diameter2(tree.right);
        return Math.max(lh + rh + 1, Math.max(ldia, rdia));
    }

    static int diameter(BST tree) {
        Height height = new Height();
        return diameterUtills(tree, height);
    }

    static int diameterUtills(BST tree, Height height) {
        Height lh = new Height();
        Height rh = new Height();

        if (tree == null) {
            height.h = 0;
            return height.h;
        }

        int ldia = diameterUtills(tree.left, lh);
        int rdia = diameterUtills(tree.right, rh);

        height.h = Math.max(lh.h, rh.h) + 1;
        return Math.max(lh.h + rh.h + 1, Math.max(ldia, rdia));
    }
}

class Height {
    int h;
}


