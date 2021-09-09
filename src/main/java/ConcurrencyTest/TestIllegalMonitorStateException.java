package ConcurrencyTest;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class TestIllegalMonitorStateException {
    static Object test = new Object();

    // 这样写，到最后没有部分可以释放锁，会造成一定的问题
    public static class Test1 implements Runnable {

        @Override
        public void run() {
            try {
                for (int i=0; i<10; i++) {
                    synchronized (test) {
                        test.notify();
                        System.out.println(i);
                        test.wait();
                    }
                }
            } catch (Exception e) {
                System.out.println(1);
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.execute(new Test1());
        executorService.execute(new Test1());
        executorService.shutdown();
    }
}
