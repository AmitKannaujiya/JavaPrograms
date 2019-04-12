package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public interface SocketAdapter {
    Volt get3Volt();
    Volt get120Volt();
    Volt get12Volt();
}
