package com.svit.java.exercise;
import java.util.*;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

public class ScheduledTask {
    public static void main(String... args){
        long time = System.nanoTime();
        try {
            scheduledTasks(time);
        } catch (Exception e){
            return;
        }
    }

    private static void scheduledTasks(long time) throws InterruptedException{

        ScheduledExecutorService ses = Executors.newScheduledThreadPool(3);
        Runnable t1 = () -> System.out.println("Scheduling T1: " + (System.nanoTime() - time));
        Runnable t2 = () -> System.out.println("Scheduling T2: " + (System.nanoTime() - time));
        Runnable t3 = () -> System.out.println("Scheduling T3: " + (System.nanoTime() - time));
        ses.scheduleAtFixedRate(t1, 1, 1, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(t2, 2, 2, TimeUnit.SECONDS);
        ses.scheduleAtFixedRate(t3, 3, 3, TimeUnit.SECONDS);
        //Thread.sleep();
        //ses.shutdown();
        ses.awaitTermination(20, TimeUnit.SECONDS);
    }
}


