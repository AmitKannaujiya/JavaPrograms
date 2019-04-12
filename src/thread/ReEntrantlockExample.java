package thread;

import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * Created by amit on 11/4/19.
 */
public class ReEntrantlockExample {

    public static void main(String[] args) {
        Counter counter = new Counter(new ReentrantLock());
         Runnable runnable = new Runnable() {
             @Override
             public void run() {
                 System.out.println("Current Thread : " + Thread.currentThread().getName() + " count : " + counter.getCount());
             }
         };
        Thread T1 = new Thread(runnable, "T1");
        Thread T2 = new Thread(runnable, "T2");
        Thread T3 = new Thread(runnable, "T3");

        T1.start();
        T2.start();
        T3.start();
        
    }

    static class Counter {
        Lock lock;
        int count = 0;
        Counter(Lock lock) {
            this.lock = lock;
        }

        public int getCount() {
            lock.lock();
            count++;
            lock.unlock();
            return count;
        }
    }

}
