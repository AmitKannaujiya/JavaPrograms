package thread;

/**
 * Created by amit on 11/4/19.
 */
public class ThreadJoinExample {

    public static void main(String[] args) {
        ParallelTask task1 =  new ParallelTask();
        ParallelTask task2 =  new ParallelTask();
        ParallelTask task3 =  new ParallelTask();
        Thread T1 = new Thread(task1, "T1");
        Thread T2 = new Thread(task2, "T2");
        Thread T3 = new Thread(task3, "T3");

        task2.setPredecessorThread(T1);
        task3.setPredecessorThread(T2);
        T1.start();
        T2.start();
        T3.start();

    }

    public static class ParallelTask implements Runnable {
        Thread predecessorThread ;
        @Override
        public void run() {
            System.out.println("Current Thread started : " + Thread.currentThread().getName());
            if (predecessorThread!=null) {
                try {
                    predecessorThread.join();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("Current Thread finished : " + Thread.currentThread().getName());
        }

        public void setPredecessorThread(Thread predecessorThread) {
            this.predecessorThread = predecessorThread;
        }
    }
}
