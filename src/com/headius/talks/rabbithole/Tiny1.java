package com.headius.talks.rabbithole;

public class Tiny1 {
    public static void main(String[] args) {
        for (int i = 0; i < 100000; i++) {
            tiny();
        }
    }
    
    public static int tiny() {
        return 1 + 1;
    }
}
