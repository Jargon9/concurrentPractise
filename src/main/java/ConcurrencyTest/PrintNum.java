package ConcurrencyTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.locks.ReentrantLock;

public class PrintNum {
    public static Boolean order = true;

    public static class Print1 implements Runnable {
        ReentrantLock lock;
        Print1(ReentrantLock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                while (order){}
                System.out.println(i);
                synchronized (order) {
                    order = true;
                }
            }
        }
    }
    public static class Print2 implements Runnable {
        ReentrantLock lock;
        Print2(ReentrantLock lock) {
            this.lock = lock;
        }
        @Override
        public void run() {
            for (int i=0; i<10; i++) {
                while (!order){}
                System.out.println(i);
                synchronized (order) {
                    order = false;
                }
            }
        }
    }




    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Print1 print1 = new Print1(lock);
        Print2 print2 = new Print2(lock);
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(print1);
        executorService.execute(print2);
        executorService.shutdown();
    }
}
