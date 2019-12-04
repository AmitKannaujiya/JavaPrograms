package dequeue;
import java.util.Iterator;

public class Dequeue<T>  implements Iterable<T>{
    private MyLinkList<T> queue ;
    MyLinkList head = null;
    MyLinkList tail = null;
    public Dequeue() {
        //this.queue = new MyLinkList();
    }

    public void add(T t) {
        MyLinkList list = new MyLinkList(t);
        if(head == null) {
            head = list;
            tail = list;
        } else {
            list.next = head;
            head = list;
            MyLinkList temp = tail;
            while(temp.next !=null) {
                temp = temp.next;
            }
            tail = temp;
        }

    }

    public void addFirst(T t) {
         add(t);
    }

    public void addLast(T t) {
        MyLinkList list = new MyLinkList(t);
        if(tail == null) {
            tail = list;
            head = list;
        } else {
            MyLinkList temp = tail;
            while(temp.next != null) {
                temp =temp.next;
            }
            temp.next = list;
            tail = list;
        }
    }

    public Object remove() {
        if(head  == null) {
            return null;
        }
        MyLinkList t = null;
        if(head !=null) {
            t = head;
            head = head.next;
            if(t == tail) {
                tail = head;
            }
            t.next = null;
            return t;

        }
        return null;
    }
    public Object removeFirst() {
        return remove();
    }
    public Object removeLast() {
        if(tail == null) {
            return null;
        }
        if(tail == head ) {
            Object d = head.data;
            head = tail = null;
            return d;
        }
        MyLinkList t = head;
        while (t.next!=tail) {
            t = t.next;
        }

        if(t!=null) {
            tail = t;
            t.next = null;
            return tail.data;
        }

        return null;
    }

    public Object peakFirst() {
        if(head!=null) {
            return head.data;
        }
        return null;
    }
    public Object peakLast() {
        if(tail!=null) {
            return tail.data;
        }
        return null;
    }

    @Override
    public Iterator<T> iterator() {
        return new DequeueIterator();
    }


    class DequeueIterator<T> implements Iterator<T> {
        MyLinkList<T> nextHead = head;

        @Override
        public boolean hasNext() {
            return nextHead != null;
        }

        @Override
        public T next() {
            MyLinkList temp = nextHead;
            if(temp!=null) {
                nextHead = nextHead.next;
                return (T)temp.data;
            }
            return null;
        }
        @Override
        public void remove() {

        }
    }



    class MyLinkList<T> {
        T data;
        MyLinkList next;
        public MyLinkList(T t) {
            this.data = t;
            this.next = null;
        }
    }

}

