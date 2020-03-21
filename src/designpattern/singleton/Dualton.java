package designpattern.singleton;

public class Dualton {

    static private Dualton firstInstance = null;
    static private Dualton secondInstance = null;
    static int COUNT = 0;
    public String name;
    private Dualton(String name) {
        this.name = name;
    }
    public static Dualton getInstance(String name) {
        COUNT++;
        if(COUNT % 2 == 0) {
            if(firstInstance == null) {
                firstInstance = new Dualton(name);
            }
            return firstInstance;
        }
        if(secondInstance == null) {
            secondInstance = new Dualton(name);
        }
        return secondInstance;
    }

    public String getName() {
        return this.name;
    }


    public static void main(String[] args) {
        for (int i = 0; i < 10; i++) {
            Dualton instance = Dualton.getInstance("index : " + i);
            System.out.println("i : " + i + " Count : " + Dualton.COUNT + " name : " + instance.getName() );
        }
    }
}
