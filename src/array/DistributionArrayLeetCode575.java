package array;
import java.util.List;
import java.util.ArrayList;

public class DistributionArrayLeetCode575 {
    public static void main(String[] args) {
        int [] array = new int[]{90,15,41,51,36,41,51,85,32,23,6,69,43,36,16,78,26,34,96,17,84,66,54,69,3,56,18,84,49,82,3,75,70,
                16,3,42,1,95,20,60,5,3,5,78,96,42,25,34,71,70,68,20,57,62,77,48,62,29,79,8,44,13,89,82,93,44,66,33,61,30,
                73,85,55,90,94,57,42,42,17,25,37,34,89,53,92,28,49,53,3,96,6,87,98,35,20,79,67,66,4,94};
        DistributionArrayLeetCode575 obj = new DistributionArrayLeetCode575();

        System.out.println(obj.distributeCandies(array));
        System.out.println(obj.distributeCandies(new int[]{3,1,1,1}));
        obj.getDuplicates(array);
    }

    public int distributeCandies(int[] candies) {
        List<Integer> sisters = new ArrayList<>();
        List<Integer> brothers = new ArrayList<>();
        int count = 0;
        for(int candy : candies) {
            if(sisters.contains(candy)) {
                brothers.add(candy);
            } else if(sisters.size() <= brothers.size()) {
                sisters.add(candy);
            } else if (brothers.size() > sisters.size()){
                sisters.add(candy);
            } else {
                brothers.add(candy);
            }
        }
        System.out.println("Sisters :" + sisters.size() + " brothers : " + brothers.size()  );
        return sisters.size();
    }

    public void getDuplicates(int[] array) {
        List<Integer> uniques = new ArrayList<>();
        List<Integer> duplicates = new ArrayList<>();
        int count = 0;
        for (int item : array) {
            if(uniques.contains(item)) {
                duplicates.add(count++, item);
            } else {
                uniques.add(item);
            }
        }
        System.out.println(duplicates.size());
        System.out.println(uniques.size());
    }
}
