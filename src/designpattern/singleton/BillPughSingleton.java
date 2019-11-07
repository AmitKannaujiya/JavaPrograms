package designpattern.singleton;

import com.sun.org.apache.bcel.internal.generic.INSTANCEOF;

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
