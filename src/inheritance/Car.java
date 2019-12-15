package inheritance;

public class Car extends Vehical implements Ispeed {

    @Override
    public int getTopSpeed() {
        return this.maxSpeed - 10;
    }

    @Override
    public String toString() {
        return "Car : Max Speed " + this.getMaxSpeed() + " top speed " + this.getTopSpeed();
    }
}
