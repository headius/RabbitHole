package com.headius.talks.rabbithole;

public class EscapeAnalysis {
    public static void main(String[] args) {
        System.out.println(adderThin(50));
        
        int dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += adderThin(i % 50);
        }
        System.out.println(dummy);
        
        dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += adderFat1(i % 50);
        }
        System.out.println(dummy);
        
        dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += adderFat2(i % 50);
        }
        System.out.println(dummy);
        
        dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += adderFat3(i % 50);
        }
        System.out.println(dummy);
        
        dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += adderFat4(i % 50);
        }
        System.out.println(dummy);
        
        dummy = 0;
        for (int i = 0; i < 100000; i++) {
            dummy += doAlmostNothing(i % 50);
        }
        System.out.println(dummy);
    }
    
    public static int adderThin(int a) {
        int k = 0;
        
        while (a > 0) {
            k += a--;
        }
        
        return k;
    }
    
    public static Integer adderFat1(Integer... a) {
        Integer k = 0;
        
        while (a[0] > 0) {
            k += a[0]--;
        }
        
        return k;
    }
    
    public static int adderFat2(Integer a) {
        Integer k = 0;
        
        while (a > 0) {
            k += a--;
        }
        
        return k;
    }
    
    public static int adderFat3(int a) {
        int[] k = {0};
        
        while (a > 0) {
            k = new int[]{k[0] + a--};
        }
        
        return k[0];
    }
    
    private static class Holder {
        Holder(int a) { this.k = a; }
        final int k;
    }
    
    public static int adderFat4(int a) {
        Holder k = new Holder(0);
        
        while (a > 0) {
            k = new Holder(k.k + a--);
        }
        
        return k.k;
    }
    
    public static int doAlmostNothing(int a) {
        return new Integer(a) + new Integer(a);
    }
}
