package interfaces;
interface IAnial{
    default void walk(){System.out.println("animal walk");} void fly(); void makeSound(); }
public class InterfaeTest {
    public static void main(String[] args) {
        IAnial python = new Python();
        python.fly();

        python.makeSound();
        python.walk();

        Ireptile python1 = new Python();
        python1.crawal();

        python1.makeSound();
        python1.makeEggs();


    }
}
interface Ireptile{default void crawal(){System.out.println("reptile crawal");}  void makeSound();void makeEggs(); }
class Cat implements IAnial {
    @Override
    public void fly() {
        System.out.println("Can't fly");
    }

    @Override
    public void makeSound() {
        System.out.println("meoo meoo");
    }
}
class Python implements IAnial,Ireptile {
    @Override
    public void fly() {
        System.out.println("Can't fly");
    }

    @Override
    public void makeSound() {
        System.out.println("sshii");
    }

    @Override
    public void makeEggs() {
        System.out.println("Giving egg");
    }
}