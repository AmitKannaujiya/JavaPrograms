package threading;

public class ThreadBasic {
    public static void main(String[] args) {
        System.out.println("Hello Thread");
        ThreadBasic obj = new ThreadBasic();
        obj.makeTask();
    }
    public void makeTask() {
        Task task = new Task();
        Thread thread = new Thread(new MyRunnable(task), "Thread 1");
        thread.start();

//        Thread thread2 = new Thread(new MyRunnable(task), "Thread 2");
//        thread2.start();
//
//        Thread thread3 = new Thread(new MyRunnable(task), "Thread 3");
//        thread3.start();

        for (int i = 1; i <= 10; i++) {
            System.out.println("^^print doc : #" +i + " - printer 1");
        }

    }

    class  Task {
        int count;

        public int increment() {
            return ++count;
        }
        public int getCount() {
            return count;
        }

        public void setCount(int count) {
            this.count = count;
        }
    }

    class MyRunnable implements Runnable {
        private Task task;
        public MyRunnable(Task task) {
            this.task = task;
        }
        @Override
        public void run() {
            System.out.println("My task : thread"+ Thread.currentThread().getName() + " count : " + this.task.increment());
            for (int i = 1; i <= 10; i++) {
                System.out.println("@@print doc : #" +i + " - printer 2");
            }
        }
    }
}
