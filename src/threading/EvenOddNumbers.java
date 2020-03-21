package threading;

public class EvenOddNumbers {
    public static void main(String[] args) {
//        Thread evenThread = new Thread( new Task(true), "EVEN Thread");
//        Thread oddThread = new Thread( new Task(false), "ODD Thread");
//        evenThread.start();
//        oddThread.start();

//        Object lock = new Object();
//        Thread EThread = new Thread(new OddEvenCounter(0, lock), "EVEN THREAD");
//        Thread OThread = new Thread(new OddEvenCounter(1, lock), "ODD THREAD");
//        EThread.start();
//        OThread.start();


        OddEvenRunnable oddRunnable=new OddEvenRunnable(1);
        OddEvenRunnable evenRunnable=new OddEvenRunnable(0);

        Thread t1=new Thread(oddRunnable,"Odd");
        Thread t2=new Thread(evenRunnable,"Even");

        t1.start();
        t2.start();
    }
}

class OddEvenRunnable implements Runnable{

    public int PRINT_NUMBERS_UPTO=10;
    static int  number=1;
    int remainder;
    static Object lock=new Object();

    OddEvenRunnable(int remainder)
    {
        this.remainder=remainder;
    }

    @Override
    public void run() {
        while (number < PRINT_NUMBERS_UPTO) {
            synchronized (lock) {
                while (number % 2 != remainder) { // wait for numbers other than remainder
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(Thread.currentThread().getName() + " " + number);
                number++;
                lock.notifyAll();
            }
        }
    }
}

class OddEvenCounter implements Runnable {
    int remainder;
    Object lock;
    public OddEvenCounter(int remainder, Object lock) {
        this.remainder = remainder;
        this.lock = lock;
    }
    static int no;

    int WAIT_TILL = 10;
    @Override
    public void run() {
        String thred = Thread.currentThread().getName();
        while (no <= WAIT_TILL) {
            synchronized (lock) {
                while (no % 2 != remainder) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                    //System.out.println("Thread : " + thred + " waiting ");
                }
                System.out.println("Thread : " + thred + " no : " + no);
                ++no;
                lock.notifyAll();
            }
        }
    }
}

class Task implements Runnable{
    boolean type;
    int no;
    public Task(boolean type) {
        this.type = type;
        this.no = 0;
    }

    @Override
    public void run() {
        String threadName =  Thread.currentThread().getName();
        while (no <= 10) {
            if(no % 2 == 0) {
                if (type) {
                    System.out.println("Thread : " + threadName + " sequence no : " + no);
                }
            }else {
                if (!type) {
                    System.out.println("Thread : " + threadName + " sequence no : " + no);
                }
            }
            no++;
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
