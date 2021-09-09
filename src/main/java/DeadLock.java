
import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

public class DeadLock {

    public static class MyRunable implements Runnable {
        private Object obj1;
        private Object obj2;
        private Boolean mark;

        MyRunable(Object obj1, Object obj2, Boolean mark) {
            this.obj1 = obj1;
            this.obj2 = obj2;
            this.mark = mark;
        }

        @Override
        public void run() {
            try {
                if (mark) {
                    synchronized (obj1) {
                        Thread.sleep(1000);
                        System.out.println("get obj1");
//                        synchronized (obj2) {
//                            Thread.sleep(1000);
//                            System.out.println("get obj2");
//                        }
                    }
                } else {
                    synchronized (obj2) {
                        Thread.sleep(1000);
                        System.out.println("get obj2");
//                        synchronized (obj1) {
//                            Thread.sleep(1000);
//                            System.out.println("get obj1");
//                        }
                    }
                }
            } catch (InterruptedException e) {
                    e.printStackTrace();
            }

        }
    }

    /**
     * thread.run : 不会创建新的线程，会在原本的线程中执行 runnable 里的方法，可反复调用
     * thread.start : 会创建新的线程 thread中的方法，一个对象只能掉调用一次 调用多次会出现IllegalThreadStateException
     * @param args
     */
    public static void main(String[] args) {
        List<Integer> x = new ArrayList<>();
//        x.remove
        Object obj1 = new Object();
        Object obj2 = new Object();
        MyRunable myRunable1 = new MyRunable(obj1, obj2, true);
        MyRunable myRunable2 = new MyRunable(obj1, obj2, false);
        Thread thread1 = new Thread(myRunable1);
        thread1.setName("thread1");
        Thread thread2 = new Thread(myRunable2);
        thread2.setName("thread2");
        thread1.start();
        thread1.start();
        thread2.start();
    }
}
