package inheritance;

public interface IPower {
    int maxSpeed = 120;
    String maxPower = "250Hz";
    int getTopPower();
    default int getMaxSpeed() {
        return this.maxSpeed;
    }
    default String getMaxPower() {
        return this.maxPower;
    }
}
