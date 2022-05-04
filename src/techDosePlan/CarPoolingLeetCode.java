package techDosePlan;

import java.util.ArrayList;

public class CarPoolingLeetCode {
    public static void main(String[] args) {
        CarPoolingLeetCode  obj = new CarPoolingLeetCode();
        int trips[][]= new int[][]{

                {2, 1,3},{3,3,7}
        };
        int capacity= 5;
        System.out.println();
    }

    public boolean isTripPossible(int[][]trips,int capacity) {
        ArrayList<Trip> trip= new ArrayList<>();
//        for (trips: t) {
//            Trip  trp = new Trip(t[0], t[1], 0);
//
//
//        }
        return false;
    }

    class Trip {
        int passengers;
        int from;
        int status;

        public Trip(int passangers, int from,int status) {
            this.passengers= passangers;
            this.from = from;
            this.status= status;
        }

    }

}
