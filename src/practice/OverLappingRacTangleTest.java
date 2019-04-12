package practice;

import java.awt.*;

/**
 * Created by amit on 8/12/18.
 */
public class OverLappingRacTangleTest {

    public static void main(String[] args) {
        OverLappingRacTangleTest obj = new OverLappingRacTangleTest();
        System.out.println(obj.areaOfSqaure(2, 1, 5, 5, 3, 2, 5, 7));
        System.out.println(obj.areaOfSqaure(2, 1, 5, 5, 2, 5, 5, 7));

    }

     int areaOfSqaure(int x1, int y1, int xx1, int yy1, int x2, int y2, int xx2, int yy2) {
        Point LBR1 = new Point(x1, y1);
        Point LBR2 = new Point(x2, y2);
        Point TRR1 = new Point(xx1, yy1);
        Point TRR2 = new Point(xx2, yy2);

        int leftSide = maxPoit(LBR1.x, LBR2.x);
        int rightSide = minPoit(TRR1.x, TRR2.x);
        int x = rightSide - leftSide;
        if(x < 0)
            return  -1;

        int bottomSide = maxPoit(LBR1.y, LBR2.y);
        int topSide = minPoit(TRR1.y, TRR2.y);
        int y = topSide - bottomSide;
        if(y < 0) {
            return -1;
        }
        return y * x;
    }

    int maxPoit (int p1, int p2) {
        return p1 > p2 ? p1 : p2;
    }
    int minPoit (int p1, int p2) {
        return p1 > p2 ? p2 : p1;
    }

    class  Point {
        int x;
        int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
}
