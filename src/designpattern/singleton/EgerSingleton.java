package designpattern.singleton;

/**
 * Created by amit on 26/7/18.
 */
public class EgerSingleton {
    private static EgerSingleton INSTANCE =  new EgerSingleton();

    private EgerSingleton(){}

    public static EgerSingleton getInstance(){
        return INSTANCE;
    }

}
