package threading;

import static java.lang.Thread.sleep;

public class WaitNotifyTest {

    class Monitor {}
    class Waiter implements Runnable {
        private Monitor monitor;
        public Waiter(Monitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            String threadName =  Thread.currentThread().getName();
            System.out.println(threadName + " is going o wait " + System.currentTimeMillis());
            synchronized (monitor) {
                try {
                    monitor.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println(threadName + " is out of wait " + System.currentTimeMillis());
        }
    }
    class Notifer implements Runnable {
        private Monitor monitor;
        public Notifer(Monitor monitor) {
            this.monitor = monitor;
        }

        @Override
        public void run() {
            String threadName =  Thread.currentThread().getName();
            System.out.println(threadName + " is going ot release wait " + System.currentTimeMillis());
            synchronized (monitor) {
                try {
                    sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                monitor.notify();
                System.out.println(threadName + " notified " + System.currentTimeMillis());
            }
        }
    }
    class Waitnotify {
        private Monitor monitor= new Monitor();
        private boolean wait = false;
        void doWait() throws InterruptedException {
            synchronized (monitor) {
                monitor.wait();
                wait = true;
                while(wait) {
                    System.out.println(Thread.currentThread().getName() + " Sleeping for 2 seconds");
                    sleep(2000);
                }
                System.out.println(Thread.currentThread().getName() + " Thread is awake ");
            }
        }

        void doNotify() {
            synchronized(monitor) {
                System.out.println(Thread.currentThread().getName() + " Thread is releasing lock");
                monitor.notify();
                wait = false;
            }
        }
        void doNotifyAll() {
            synchronized(monitor) {
                monitor.notifyAll();
                wait = false;
                System.out.println(Thread.currentThread().getName() + " Thread realising lock for all thread");
            }
        }

    }
    public static void main(String [] args) {
        WaitNotifyTest object = new WaitNotifyTest();
        object.startest();

    }

    private void startest() {
        Monitor monitor = new Monitor();
        Waiter waiter1 = new Waiter(monitor);
        Thread t1 = new Thread(waiter1, "waiter1");

        Waiter waiter2 = new Waiter(monitor);
        Thread t2 = new Thread(waiter2, "waiter2");
        Notifer notifer = new Notifer(monitor);
        Thread not= new Thread(notifer, "notifire");

        t1.start();
        t2.start();

        not.start();
    }
}
