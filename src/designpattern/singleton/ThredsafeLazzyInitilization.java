package designpattern.singleton;

/**
 * Created by amit on 26/7/18.
 */
public class ThredsafeLazzyInitilization {
    public static ThredsafeLazzyInitilization INSTANCE;

    private ThredsafeLazzyInitilization() {
    }

    public static synchronized ThredsafeLazzyInitilization getInstance() {
        if (INSTANCE == null) {
            INSTANCE = new ThredsafeLazzyInitilization();
        }
        return INSTANCE;
    }
}
