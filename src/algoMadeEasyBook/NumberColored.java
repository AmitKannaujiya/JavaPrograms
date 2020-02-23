package algoMadeEasyBook;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.lang.String;
import java.lang.Integer;
import java.util.*;

public class NumberColored {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
//        int T = Integer.parseInt(br.readLine());
//        while(T-- > 0) {
//            String[] line = br.readLine().split("\\s+");
//            int a = Integer.parseInt(line[0]);
//            int b = Integer.parseInt(line[1]);
//            System.out.println(gcd(a, b));
//        }
        NumberColored numberColored = new NumberColored();

        numberColored.testLeader();
    }

    private void testLeader() {
//        Leaderboard leaderboard = new Leaderboard();
//
//        leaderboard.addScore(1,73);   // leaderboard = [[1,73]];
//        leaderboard.addScore(2,56);   // leaderboard = [[1,73],[2,56]];
//        leaderboard.addScore(3,39);   // leaderboard = [[1,73],[2,56],[3,39]];
//        leaderboard.addScore(4,51);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
//        leaderboard.addScore(5,4);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard.top(1));           // returns 73;
//        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
//        leaderboard.reset(2);         // leaderboard = [[3,39],[4,51],[5,4]];
//        leaderboard.addScore(2,51);   // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
//        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;

//        ["Leaderboard","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","addScore","top","reset","reset","addScore","addScore","top","reset","reset","addScore","reset"]
//[[],[1,13],[2,93],[3,84],[4,6],[5,89],[6,31],[7,7],[8,1],[9,98],[10,42],[5],[1],[2],[3,76],[4,68],[1],[3],[4],[2,70],[2]]

        Leaderboard leaderboard = new Leaderboard();

        leaderboard.addScore(1, 13);   // leaderboard = [[1,73]];
        leaderboard.addScore(2, 93);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(3, 84);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(4, 6);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(5, 89);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];

        leaderboard.addScore(6, 31);   // leaderboard = [[1,73]];
        leaderboard.addScore(7, 7);   // leaderboard = [[1,73],[2,56]];
        leaderboard.addScore(8, 1);   // leaderboard = [[1,73],[2,56],[3,39]];
        leaderboard.addScore(9, 98);   // leaderboard = [[1,73],[2,56],[3,39],[4,51]];
        leaderboard.addScore(10, 42);    // leaderboard = [[1,73],[2,56],[3,39],[4,51],[5,4]];

        System.out.println(leaderboard.top(5));           // returns 73;
        leaderboard.reset(1);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(2);
        // leaderboard = [[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.leaderBoard);
        leaderboard.addScore(3, 76);
        leaderboard.addScore(4, 68);     // leaderboard = [[2,51],[3,39],[4,51],[5,4]];
        System.out.println(leaderboard.leaderBoard);
        System.out.println(leaderboard.top(1));           // returns 73;
        leaderboard.reset(3);         // leaderboard = [[2,56],[3,39],[4,51],[5,4]];
        leaderboard.reset(4);

        leaderboard.addScore(2, 70);
        leaderboard.reset(2);
        System.out.println(leaderboard.top(3));           // returns 141 = 51 + 51 + 39;

    }

    static String gcd(int a, int b) {
        while (a > 0) {
            int t = a;
            a = a > b ? a % b : b % a;
            b = t > b ? b : t;
        }
        if (b == 1) {
            return "Finite";
        } else {
            return "Infinite";
        }
    }

    public List<Integer> transformArray(int[] a) {
        List<Integer> list = new ArrayList<>();
        boolean done = true;
        do {
            done = true;
            list = new ArrayList<>();
            list.add(a[0]);
            for (int i = 1; i < a.length - 1; i++) {
                if (a[i - 1] < a[i] && a[i] > a[i + 1]) {
                    done = false;
                    list.add(a[i] - 1);
                } else if (a[i - 1] > a[i] && a[i] < a[i + 1]) {
                    done = false;
                    list.add(a[i] + 1);
                } else {
                    list.add(a[i]);
                }
            }
            list.add(a[a.length - 1]);
            if (!done) {
                for (int i = 0; i < list.size(); i++) {
                    a[i] = list.get(i);
                }
            }
        } while (!done);

        return list;

    }

    class Leaderboard {
        public HashMap<Integer, Integer> leaderBoard;

        public Leaderboard() {
            this.leaderBoard = new LinkedHashMap<>();
        }

        public void addScore(int playerId, int score) {
            //System.out.println(leaderBoard);
            leaderBoard.put(playerId, score);

        }

        public int top(int k) {
            int sum = 0;
            int count = 0;
            List<Integer> list = new ArrayList<>(this.leaderBoard.values());
            Collections.sort(list, new Comparator<Integer>() {
                @Override
                public int compare(Integer integer, Integer t1) {
                    return t1 - integer;
                }
            });
            for (Integer integer : list) {
                count++;
                sum += integer;
                if (count == k) {
                    break;
                }
            }
            return sum;
        }

        public void reset(int playerId) {
            if (this.leaderBoard.containsKey(playerId)) {
                this.leaderBoard.remove(playerId);
            }
        }
    }
}
