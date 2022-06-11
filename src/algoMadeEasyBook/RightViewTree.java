package algoMadeEasyBook;

import bst.BST;

import java.util.ArrayList;
import java.util.List;

public class RightViewTree {
    public static void main(String[] args) {
        RightViewTree obj = new RightViewTree();
        obj.rightViewOfTree(new BST<Integer>(0), new MaxLevel(), 1, new ArrayList<>());
    }

    public void rightViewOfTree(BST<Integer> bst, MaxLevel level, int clevel, List<Integer> list) {
        if(bst == null){
            return;
        }
        if(level.level < clevel){
            list.add(bst.data);
            level.level = clevel;
        }
        rightViewOfTree(bst.right, level, clevel+1, list);
        rightViewOfTree(bst.left, level, clevel+1, list);
    }
}
class MaxLevel {
    int level;
}
