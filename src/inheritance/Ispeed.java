package inheritance;

public interface Ispeed {
    int getTopSpeed();
    int maxSpeed = 110;
    default int getMaxSpeed() {
        return this.maxSpeed;
    }
}
