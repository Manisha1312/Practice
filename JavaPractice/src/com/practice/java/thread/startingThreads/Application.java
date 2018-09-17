package com.practice.java.thread.startingThreads;

public class Application {

    public static void main(String[] args) {
    	RunnerExtends runner1 = new RunnerExtends();
    	RunnerExtends runner2 = new RunnerExtends();
        runner1.start();
        runner2.start();
        
        
        Thread thread1 = new Thread(new RunnerRunnable());
        Thread thread2 = new Thread(new RunnerRunnable());
        thread1.start();
        thread2.start();
    }

}
