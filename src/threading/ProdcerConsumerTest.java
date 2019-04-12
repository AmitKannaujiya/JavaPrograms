package threading; /**
 * Created by amit on 1/7/18.
 */

import java.lang.Thread;
import java.util.ArrayList;

public class ProdcerConsumerTest {

    public static void main(String[] args) {

    int size = 4;
        ArrayList<Integer> arrayList = new ArrayList<>();

    Thread producer = new Thread(new Producer(arrayList, size), "P");
    Thread consumer = new Thread(new Consumer(arrayList, size), "C");

    consumer.start();
    producer.start();
    }

}

class Producer implements Runnable {
    ArrayList queue;
    int SIZE;


    public Producer(ArrayList<Integer> arrayList, int size) {
        this.queue = arrayList;
        this.SIZE = size;

    }

    @Override
    public void run() {
        for (int i=0; i< 7; i++ ) {
            produce(i);
        }

    }

    private void produce(int i) {
        while (queue.size()== SIZE) {
            synchronized (queue) {
                try {
                    System.out.println("Queue is full " + Thread.currentThread().getName()
                            + " is waiting , size: " + queue.size());


                   // Read more: http://www.java67.com/2012/12/producer-consumer-problem-with-wait-and-notify-example.html#ixzz5K1kPmCXD
                    queue.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

        synchronized (queue) {
            System.out.println("Thread : " + Thread.currentThread().getName() + " adds : " + i);
            queue.add(i);
            queue.notifyAll();
        }
    }
}

class Consumer implements Runnable {
    ArrayList queue;
    int SIZE;

    public Consumer(ArrayList<Integer> arrayList, int size) {
        this.queue = arrayList;
        this.SIZE = size;
    }

    @Override
    public void run() {
        while (true) {

            while (queue.isEmpty()) {
                synchronized (queue) {
                    try {
                        queue.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }

            synchronized (queue) {
                System.out.println("Thread Name : " + Thread.currentThread().getName() + " consumed : " + queue.remove(0));
                queue.notifyAll();
                try {
                    Thread.sleep(50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }

    }

    private void consume() {

    }
}
