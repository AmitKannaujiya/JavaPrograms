package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public class Volt {
    int volt;

    public int getVolt() {
        return volt;
    }

    public Volt(int volt) {
        this.volt = volt;
    }

    public void setVolt(int volt) {
        this.volt = volt;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Volt volt1 = (Volt) o;

        return volt == volt1.volt;

    }

    @Override
    public String toString() {
        return  String.valueOf(volt) + 'V';
    }

    @Override
    public int hashCode() {
        return volt;
    }
}
