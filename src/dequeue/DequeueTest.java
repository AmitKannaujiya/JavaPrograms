package dequeue;

import java.util.Iterator;

public class DequeueTest {
    public static void main(String[] args) {
        Dequeue<Integer> dequeue = new Dequeue<>();
        dequeue.add(1);
        dequeue.add(3);
        dequeue.addLast(5);
        dequeue.addLast(6);

        Iterator iterator = dequeue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        System.out.println("-----------------");

        dequeue.addFirst(7);
        iterator = dequeue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        dequeue.remove();
        dequeue.remove();
        dequeue.removeLast();
        System.out.println("-----------------");

       /// dequeue.addFirst(7);
        iterator = dequeue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        dequeue.removeLast();
        dequeue.removeLast();
        System.out.println("-----------------");

        /// dequeue.addFirst(7);
        iterator = dequeue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        dequeue.removeLast();
        System.out.println("-----------------");
        iterator = dequeue.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
        dequeue.add(3);
        dequeue.addLast(4);
        dequeue.addLast(5);
        for(Object obj : dequeue) {
            System.out.println(obj);
        }
    }
}

