package inheritance;

public class Truck extends Vehical implements IPower, Ispeed {
    @Override
    public int getTopPower() {
        return 0;
    }

    @Override
    public int getMaxSpeed() {
        return 0;
    }

    @Override
    public int getTopSpeed() {
        return 0;
    }

//    @Override
//    public int getMaxSpeed() {
//        return 0;
//    }

    @Override
    public String getMaxPower() {
        return null;
    }
}
