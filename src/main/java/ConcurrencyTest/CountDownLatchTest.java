package ConcurrencyTest;

import java.util.concurrent.*;

// 这个await 必须等count down latch清0才可以被唤醒
//  我等别人
public class CountDownLatchTest {
    private static CountDownLatch countDownLatch = new CountDownLatch(2);

    public static class Test implements Runnable{

        @Override
        public void run() {
            System.out.println(countDownLatch.getCount());
            countDownLatch.countDown();
        }
    }


    public static void main(String[] args) throws InterruptedException {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Test());
        executorService.submit(new Test());
        System.out.println(countDownLatch.getCount());
        countDownLatch.await();
        System.out.println("end");
    }
}
