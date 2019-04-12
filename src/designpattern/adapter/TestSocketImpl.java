package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public class TestSocketImpl {

    public static void main(String[] args) {
        SocketAdapterClassImpl socketAdapterClass = new SocketAdapterClassImpl();

        SocketAdapterImpl socketAdapter = new SocketAdapterImpl();
        System.out.println("Socket Adapter " + getVolt(VoltEnum.VoltEnum_3_VOLT, socketAdapter));
        System.out.println("Socket Adapter Class" + getVolt(VoltEnum.VoltEnum_3_VOLT, socketAdapterClass));

        System.out.println("Socket Adapter " + getVolt(VoltEnum.VoltEnum_12_VOLT, socketAdapter));
        System.out.println("Socket Adapter Class " + getVolt(VoltEnum.VoltEnum_12_VOLT, socketAdapterClass));

        System.out.println("Socket Adapter " + getVolt(VoltEnum.VoltEnum_120_VOLT, socketAdapter));
        System.out.println("Socket Adapter class " + getVolt(VoltEnum.VoltEnum_120_VOLT, socketAdapterClass));


    }

    public  static String getVolt(VoltEnum voltEnum, SocketAdapter adapter) {
        switch (voltEnum) {
            case VoltEnum_3_VOLT:
              return adapter.get3Volt().toString();
            case VoltEnum_12_VOLT:
                return adapter.get12Volt().toString();
            case VoltEnum_120_VOLT:
                return adapter.get120Volt().toString();
            default:
                return  adapter.get120Volt().toString();
        }
    }
}
