package array;
import java.util.PriorityQueue;
import java.util.Comparator;

public class KClosestPointsFromOriginLeetCode {
    public static void main(String[] args) {
        KClosestPointsFromOriginLeetCode obj = new KClosestPointsFromOriginLeetCode();
        int[][] points = new int[][]{{3,3},{5,-1},{-2,4}}; int K = 2;
        int [][] result = obj.kClosest(points, K);
    }

    public int[][] kClosest(int[][] points, int K) {
        PriorityQueue<Distance> queue = new PriorityQueue<>(new Comparator<Distance>() {
            
            @Override
            public int compare(Distance i, Distance j) {
                // TODO Auto-generated method stub
                if(j.distance > i.distance) {
                    return 1;
                } else if( i.distance > j.distance) {
                    return -1;
                }
                return 0;
            }
        });
        for(int i=0; i < points.length; i++) {
            double distance = Math.sqrt((points[i][0] * points[i][0]) + (points[i][1] * points[i][1]));
            queue.add(new Distance(i, distance));
        }
        int [][] result = new int[K][2];
        for(int i=0; i< K; i++) {
            Distance d = queue.remove();
            result[i][0] = points[d.index][0];
            result[i][1] = points[d.index][1];
        }
        return result;
    }
}
class Distance {
    double distance;
    int index;
    public Distance(int index, double distance) {
        this.index = index;
        this.distance = distance;
    }
}