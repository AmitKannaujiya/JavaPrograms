package designpattern.singleton;

/**
 * Created by amit on 26/7/18.
 */
public class StaticSingleton {
    private static StaticSingleton INSTANCE;

    private StaticSingleton() {
    }

    static {
        try {
            INSTANCE = new StaticSingleton();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    ;

    public static StaticSingleton getInstance() {
        return INSTANCE;
    }
}
