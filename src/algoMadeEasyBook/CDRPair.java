package algoMadeEasyBook;

public class CDRPair {
    public static void main(String[] args) {
        String pair = cons(1234, 5678);
        System.out.println(car(pair));
        System.out.println(cdr(pair));
    }

    static String cons(int a, int b) {
        return new StringBuilder().append(a).append("|").append(b).toString();
    }

    static String car(String pair) {
        return pair.split("[|]")[0];
    }

    static String cdr(String pair) {
        return pair.split("[|]")[1];
    }

}
