package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public class SocketAdapterClassImpl extends Socket implements SocketAdapter {
    @Override
    public Volt get3Volt() {
        Volt volt = getVolt();
        volt.setVolt(volt.volt / 40);
        return volt;
    }

    @Override
    public Volt get120Volt() {
        return getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt volt = getVolt();
        volt.setVolt(volt.volt / 10);
        return volt;
    }
}
