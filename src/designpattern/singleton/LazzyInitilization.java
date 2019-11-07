package designpattern.singleton;

/**
 * Created by amit on 26/7/18.
 */
public class LazzyInitilization {
    public static LazzyInitilization INSTANCE;

    private LazzyInitilization() {
    }

    public static LazzyInitilization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new LazzyInitilization();
        }
        return INSTANCE;
    }


}
