package array;

public class ArrayDecodingProblem {
    public static void main(String[] args) {
        System.out.println(getTotalWaysOfDecoding("111"));
    }

    static int getTotalWaysOfDecoding(String s) {
        String zeroCheck = s.substring(0,1);
        if(zeroCheck == "0") {
            return 0;
        }
        int [] cache = new int[27];
        return getTotalWaysOfDecoding(s,  0);
    }

   static int getTotalWaysOfDecoding(String s, int i) {
        if(s== "") {
            return 0;
        }
//        if(i == s.length()) {
//            return 0;
//        }
        int index= Integer.parseInt(s);
        if(index == 0) {
            return 0;
        }
        if(index <= 26) {
            return 1 ;
        }

        return getTotalWaysOfDecoding(s.substring(i, i+1),  i+1) + getTotalWaysOfDecoding(s.substring(i , i+2), i+1);

    }
}
