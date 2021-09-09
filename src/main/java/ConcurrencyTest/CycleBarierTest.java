package ConcurrencyTest;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

// await 后大家都到一个起点上进行操作
public class CycleBarierTest {
     static CyclicBarrier cyclicBarrier = new CyclicBarrier(2);

    public static class Test implements Runnable{

        @Override
        public void run() {
            try {
                if (cyclicBarrier.getNumberWaiting() == 0) {
                    Thread.sleep(1000);
                }
                System.out.println(cyclicBarrier.getNumberWaiting());
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (BrokenBarrierException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {
        ExecutorService executorService = Executors.newFixedThreadPool(2);
        executorService.submit(new Test());
        executorService.submit(new Test());
        executorService.shutdown();
    }




}
