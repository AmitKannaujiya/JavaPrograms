package dp;

import java.util.ArrayList;
import java.util.List;

public class TriangleSumLeetCode {
    public static void main(String[] args) {
//        [[2],[3,4],[6,5,7],[4,1,8,3]]
        List<List<Integer>> lists= new ArrayList<>();

        List<Integer> row1= new ArrayList<>();
        row1.add(2);

        lists.add(row1);
        List<Integer> row2= new ArrayList<>();
        row2.add(3);
        row2.add(4);
        lists.add(row2);

        List<Integer> row3= new ArrayList<>();
        row3.add(6);
        row3.add(5);
        row3.add(7);
        lists.add(row3);

        List<Integer> row4= new ArrayList<>();
        row4.add(4);
        row4.add(1);
        row4.add(8);
        row4.add(3);
        lists.add(row4);
        TriangleSumLeetCode  obj = new TriangleSumLeetCode();
        System.out.println(obj.minimumTotal(lists));

    }

    public int minimumTotal(List<List<Integer>> triangle) {
        return minimumTotal(triangle, 0, 0, 0);
    }

    private int minimumTotal(List<List<Integer>> triangle, int sum,int index, int itemIndex) {
        if(index >= triangle.size()) {
            return sum;
        }
        List<Integer> integers = triangle.get(index);
        if(itemIndex + 1 < integers.size()) {
            int s= integers.get(itemIndex);
            int s2= integers.get(itemIndex + 1);
            if(s > s2) {
                itemIndex++;
                sum += s2;

            } else {
                sum += s;
            }
        } else {
            sum += integers.get(itemIndex);
        }

        return minimumTotal(triangle, sum, index+1,itemIndex);
    }
    private int minimumTotal1(List<List<Integer>> triangle, int sum,int index, int itemIndex) {
        if(index >= triangle.size()) {
            return sum;
        }
        List<Integer> integers = triangle.get(index);
        
        if(itemIndex + 1 < integers.size()) {
            int s= integers.get(itemIndex);
            int s2= integers.get(itemIndex + 1);
            if(s > s2) {
                itemIndex++;
                sum += s2;

            } else {
                sum += s;
            }
        } else {
            sum += integers.get(itemIndex);
        }

        return minimumTotal(triangle, sum, index+1,itemIndex);
    }
}
