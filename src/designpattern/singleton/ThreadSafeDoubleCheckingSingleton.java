package designpattern.singleton;

/**
 * Created by amit on 26/7/18.
 */
public class ThreadSafeDoubleCheckingSingleton {

    public static ThreadSafeDoubleCheckingSingleton INSTANCE;

    private ThreadSafeDoubleCheckingSingleton() {
    }

    public static synchronized ThreadSafeDoubleCheckingSingleton getInstance() {
        if (INSTANCE == null) {
            synchronized (ThreadSafeDoubleCheckingSingleton.class) {
                if (INSTANCE == null) {
                    INSTANCE = new ThreadSafeDoubleCheckingSingleton();
                }
            }

        }
        return INSTANCE;
    }
}
