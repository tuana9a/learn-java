package com.tuana9a.learn.thread;

public class ThreadMain {
    public static void main(String[] args) throws InterruptedException {
        NormalRunnable t1 = new NormalRunnable("tuan");
        GeneralRunnable t2 = new GeneralRunnable("long") {
            @Override
            public void run() {
                for (int i = 0; i < 2; ++i) {
                    System.out.println("THREAD_" + name + ": " + i);
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                System.out.println(1/0);
                System.out.println("=========== END THREAD " + name + " ===============");
            }
        };
        new Thread(t1).start();
        new Thread(t2).start();

        Thread.sleep(4000);
        System.out.println(1/0);





        //TEST sequence thread

//        ThreadSequence t1 = new ThreadSequence("tuan", lock,0);
//        ThreadSequence t2 = new ThreadSequence("long", lock,1);
//        t2.start();
//        t1.start();

        //TEST synchronized thread

//        ThreadSynchronized t1 = new ThreadSynchronized("tuan",lock);
//        ThreadSynchronized t2 = new ThreadSynchronized("long",lock);
//        t1.start();
//        t2.start();

        //TEST shared resource thread

//        ThreadUseResource t1 = new ThreadUseResource("tuan", resource);
//        ThreadCheckResource t2 = new ThreadCheckResource("long", resource);
//        t1.start();
//        t2.start();
    }
}
