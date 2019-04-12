package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public class Socket {

    Volt getVolt() {
        return new Volt(120);
    }

}
