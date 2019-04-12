package array;

/**
 * Created by amit on 16/7/18.
 */
public class MazorityElement {
//    Majority Element: Amajority element in an arrayA[] ofsize n isan element thatappears morethan n/2 times (and hencethereisatmost one
//            such element).
public static void main(String[] args) {
    int a[]={3 ,3, 4, 2, 4, 4, 2, 4, 4};
    int b [] = {3, 3, 4, 2, 4, 4, 2, 4};
    MazorityElement majority = new MazorityElement();
    int me = majority.candidateMajority(a);
    System.out.println("Is Majority Element "+ majority.isMajority(a, me, a.length));

    me = majority.candidateMajority(b);
    System.out.println("Is Majority Element "+ majority.isMajority(b, me, b.length));

}
//    Moores Voting Algorithm)
    private int candidateMajority(int a[]) {
        int count = 1, majority=0;

        for (int i = 1; i < a.length; i++) {

            if(a[majority] == a[i]) {
                count++;
            } else {
                count--;
            }
            if(count == 0) {
                majority = i;
                count=1;
            }
        }
        return a[majority];
    }

    public boolean isMajority(int a[], int majority, int n) {
        int count = 0;
        for (int i: a) {
            if(i == majority) {
                count++;
            }
        }

        if (count > n/2) {
            return true;
        } else {
            return false;
        }
    }
}
