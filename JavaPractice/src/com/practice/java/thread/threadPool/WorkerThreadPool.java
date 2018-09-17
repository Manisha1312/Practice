package com.practice.java.thread.threadPool;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class WorkerThreadPool {

    public static void main(String[] args) {
        ExecutorService executor = Executors.newFixedThreadPool(2);//two threads, try setting by 1 to observe time
        System.out.println("Starting ...");
        long start = System.currentTimeMillis();
        Worker worker = new Worker();
        for (int i = 0; i < 2; i++) {//worker.run is called 2 (threads started) times by two threads
            executor.submit(worker);
        }
        executor.shutdown(); //prevents new tasks from being accepted by the ExecutorService
        try {
            executor.awaitTermination(1, TimeUnit.DAYS);
            // How long should I wait for termination If I do not know exactly when threads are done with the tasks ?
            // Source:http://stackoverflow.com/questions/1250643/how-to-wait-for-all-threads-to-finish-using-executorservice
            // For a perpetually running batch kind of thing u need to submit jobs and wait for them to
            // finish before jumping ahead.
            // In Such a case a latch or a barrier makes more sense than a shutdown (see CountDownLatch_6.App).
        } catch (InterruptedException ex) {
            System.out.println(ex.getMessage());
        }
        long end = System.currentTimeMillis();
        System.out.println("Time taken: " + (end - start));
        System.out.println("List1: " + worker.list1.size() + "; List2: " + worker.list2.size());
    }

}
