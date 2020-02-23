package designpattern.singleton;


/**
 * Created by amit on 26/7/18.
 */
public class BillPughSingleton {
    public BillPughSingleton INSTANCE;

    static class BillPughSingleToneInner {
        public static BillPughSingleton INSTANCE = new BillPughSingleton();
    }

    public static BillPughSingleton getInstance() {
        return BillPughSingleToneInner.INSTANCE;
    }
}
