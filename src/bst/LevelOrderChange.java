package bst;

import Utills.Utills;

import java.util.*;

/**
 * Created by amit on 17/7/18.
 */
public class LevelOrderChange {

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
        LevelOrderChange obj =  new LevelOrderChange();
        obj.printLevelOrder1(root);
        System.out.println(obj.getMaxPathSum(root));

    }

    int height(BST<Integer> root) {
        if(root == null)
            return 0;

        int left = height(root.left);
        int right = height(root.right);
        return 1 + Utills.max(right, left);
    }


    void printLevelOrder1(BST<Integer> root) {
        int h =  height(root);
        for (int i = 1; i <= h; i++) {
            // Zig Zag  print
           // printLevelOrder1(root, i, i%2 ==0);
            // level order print
            printLevelOrder1(root, i, false);
            System.out.println();
        }
    }


    public List<List<Integer>> levelOrder(BST<Integer>  root) {
        List<List<Integer>> list = new ArrayList<>();
        HashMap<Integer, List<Integer>> hashMap = new LinkedHashMap<>();
        Queue<BST> queue = new ArrayDeque<>();
        if(root == null ){
            return null;
        }
        queue.add(root);
        while (!queue.isEmpty()) {
            int size = queue.size();
            List<Integer> list1 = new ArrayList<>();
            while (size-- > 0) {
                BST<Integer> node = queue.remove();
                list1.add(node.data);
                if(node.left!=null) {
                    queue.add(node.left);
                }
                if(node.right!=null) {
                    queue.add(node.right);
                }
            }
            list.add(list1);
        }
        return list;
    }


    void printLevelOrder1(BST<Integer> root, int level, boolean flag) {
        if(root == null) {
            return;
        }
        if(level ==1) {
            System.out.print(root.data + " ");
            return;
        }

            if(flag) {
                printLevelOrder1(root.right, level-1, flag);
                printLevelOrder1(root.left, level -1 , flag);
            } else {
                printLevelOrder1(root.left, level-1, flag);
                printLevelOrder1(root.right, level -1 , flag);
            }

    }



    int getMaxPathSum(BST<Integer> root) {
        if(root.left == null && root.right == null) {
            return root.data;
        }
        return root.data + Math.max(getMaxPathSum(root.left), getMaxPathSum(root.right));
    }



    void printlevelorder(BST<Integer> root) {
        int h = height(root);
        int flag = 0;
        for (int i = 1; i<=h; i++){
            printLevel(root, i, flag);
            if(i%2==0) {
                flag=1;
            } else {
                flag=0;
            }
        }
    }

    void printLevel (BST<Integer>root, int level, int flag) {
        if(root== null) {

            return;
        }
        if (level == 1){
            System.out.print(root.data + " ");
            return;
        }
        if (flag==0) {
            printLevel(root.left, level-1, flag);
            printLevel(root.right, level-1, flag);

        } else {
            printLevel(root.right, level-1, flag);
            printLevel(root.left, level-1, flag);
        }
        System.out.println();
    }
}
