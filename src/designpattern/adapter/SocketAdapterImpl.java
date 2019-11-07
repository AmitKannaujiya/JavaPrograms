package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public class SocketAdapterImpl implements SocketAdapter {
    Socket socket = new Socket();

    @Override
    public Volt get3Volt() {
        Volt volt = socket.getVolt();
        volt.setVolt(volt.volt / 40);
        return volt;
    }

    @Override
    public Volt get120Volt() {
        return socket.getVolt();
    }

    @Override
    public Volt get12Volt() {
        Volt volt = socket.getVolt();
        volt.setVolt(volt.volt / 10);
        return volt;
    }
}
