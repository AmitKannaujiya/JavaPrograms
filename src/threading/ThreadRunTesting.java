package threading;

/**
 * Created by amit on 14/11/18.
 */
public class ThreadRunTesting extends Thread {
    @Override
    public void run() {
        System.out.println("Thread Name : " + currentThread().getName());
    }

    public static void main(String[] args) throws InterruptedException {
        Thread t = new ThreadRunTesting();
        t.start();
        System.out.println("start :" + currentThread().getName());


        t.join();
        System.out.println("end :" + currentThread().getName());
        System.out.println(t.getName());
    }

    class TestThread extends Thread {

    }
}
