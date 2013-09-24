package com.headius.talks.rabbithole;

public class Concurrency {
    public static void main(String[] args) {
        System.out.println(getTime());
        System.out.println(getTimeSynchronized());
        
        long dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += getTime();
        }
        System.out.println(dummy);
        
        dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += getTimeSynchronized();
        }
        System.out.println(dummy);
    }
    
    public static long getTime() {
        return System.currentTimeMillis();
    }
    
    public static synchronized long getTimeSynchronized() {
        return System.currentTimeMillis();
    }
}
