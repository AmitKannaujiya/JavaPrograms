package designpattern.adapter;

/**
 * Created by amit on 27/7/18.
 */
public enum VoltEnum {
    VoltEnum_3_VOLT(3),
    VoltEnum_12_VOLT(12),
    VoltEnum_120_VOLT(120);
    int voltVal;

    private VoltEnum(int voltVal) {
        this.voltVal = voltVal;
    }
}
