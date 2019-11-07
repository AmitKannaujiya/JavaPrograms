package threading;

/**
 * Created by amit on 29/11/18.
 */
public class NotThreadSafeTest {
    StringBuilder sb = new StringBuilder();

    public String add(String text) {
        return this.sb.append(text).toString();
    }


    public static void main(String[] args) {
        NotThreadSafeTest notThreadSafe = new NotThreadSafeTest();
        notThreadSafe.startThread(notThreadSafe);
    }

    public void startThread(NotThreadSafeTest notThreadSafe) {

        Thread thread1 = new Thread(new NotThreadSafeTest.MyRunnable(new NotThreadSafeTest()));
        Thread thread2 = new Thread(new NotThreadSafeTest.MyRunnable(new NotThreadSafeTest()));
        thread1.start();
        thread2.start();

    }

    class MyRunnable implements Runnable {
        NotThreadSafeTest obj;

        MyRunnable(NotThreadSafeTest obj) {
            this.obj = obj;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + " => " + this.obj.add("This is text \n"));
        }
    }
}
