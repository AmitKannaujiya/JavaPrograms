package algoMadeEasyBook;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.Stack;

public class ActivityProblem {



    public static void main(String[] args) {
        int[] start = new int[]{900, 940, 950, 1100, 1500, 1800};
        int[] end = new int[]{910, 1200, 1120, 1130, 1900, 2000};
        ActivityProblem obj = new ActivityProblem();
        System.out.println(obj.getMinimumNoOfPlatforms(start, end));

        System.out.println(obj.getMinimumNoOfPlatforms(new int[]{100, 140, 150, 200, 215, 400}, new  int[]{110, 300,220,230,315,600}));
    }

    public int getMinimumNoOfPlatforms(int[] start, int[] end) {
        List<Railway> list = new ArrayList<>();
        for (int i = 0; i < start.length ; i++) {
            Railway railway = new Railway(start[i], end[i]);
            list.add(railway);
        }
        int platform = 0;
        list.sort(new Comparator<Railway>() {
            @Override
            public int compare(Railway first, Railway second) {
                return first.endtime- second.endtime;
            }
        });
        Railway railway =  list.get(0);
        for (int i = 1; i< start.length; i++) {
            Railway railway1 =  list.get(i);
            if(railway1.starttime <= railway.endtime) {
                platform++;
            } else {
                railway = railway1;
            }

        }
        return platform;
    }
}

class Railway  {
    int starttime;
    int endtime;
    Railway(int starttime, int endtime) {
        this.starttime=starttime;
        this.endtime = endtime;
    }

}
