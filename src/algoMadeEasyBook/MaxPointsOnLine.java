package algoMadeEasyBook;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class MaxPointsOnLine {
    public static void main(String[] args) {
        int[][] points = new int[][]{{1,1},{3,2},{5,3},{4,1},{2,3},{1,4}};
        MaxPointsOnLine obj = new MaxPointsOnLine();
        System.out.println(obj.getMaximumNosOfPOints(points));
    }

    public int getMaximumNosOfPOints(int[][] array) {
        int len = array.length;
        List<Point> list=new ArrayList<>();
        HashMap<Float, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            list.add(new Point(array[i][0],array[i][1]));
        }
        int max = 0;
        for (int i = 0; i < list.size()-max; i++) {
            Point p1 = list.get(i);
            for (int j = i+1; j <list.size() ; j++) {
                Point p2 = list.get(j);
                if((p2.x - p1.x ) != 0) {
                    float slop = (p2.y - p1.y)/ (p2.x -  p1.x);
                    int value = map.getOrDefault(slop,0)+1;
                    map.put(slop, value);
                    max = Math.max(max, value);
                }
            }
        }
        return max;
    }
}

