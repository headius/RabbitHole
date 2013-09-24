package com.headius.talks.rabbithole;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.function.Function;
import java.util.function.UnaryOperator;
import java.util.stream.Collectors;

public class LambdaStuff {
    public static void main(String[] args) {
        List<String> list = Arrays.asList(
                "Clojure",
                "Java",
                "Ruby",
                "Groovy",
                "Scala"
        );
        
        for (int i = 0; i < 100000; i++) {
            doSort(list);
            getRest(list);
            getAllCaps(list);
            getInitials(list);
            getInitialsManually(list);
        }
        
        Function<List<String>, String> getInitials = LambdaStuff::getInitials;
        Function<List<String>, String> getInitialsManually = LambdaStuff::getInitialsManually;
        
        for (int i = 0; i < 10; i++) {
            time("getInitials", 1000000, ()->getInitials.apply(list));
            time("getInitialsManually", 1000000, ()->getInitialsManually.apply(list));
        }
        
        System.out.println(list);
    }
    
    public static int compareStrings(String a, String b) {
        return a.compareTo(b);
    }
    
    public static void time(Object name, int iterations, Runnable body) {
        long start = System.currentTimeMillis();
        for (int i = 0; i < iterations; i++) {
            body.run();
        }
        System.out.println(name.toString() + ": " + (System.currentTimeMillis() - start));
    }
    
    public static void doSort(List<String> input) {
        Collections.sort(input, (a,b)->Integer.compare(a.length(), b.length()));
    }
    
    public static String getInitials(List<String> input) {
        return input.stream()
                .map(x->x.substring(0,1))
                .collect(Collectors.joining());
    }
    
    public static String getRest(List<String> input) {
        return input.stream()
                .map(x->x.substring(1))
                .collect(Collectors.joining());
    }
    
    public static String getAllCaps(List<String> input) {
        return input.stream()
                .map(x->x.toUpperCase())
                .collect(Collectors.joining());
    }
    
    public static String getInitialsManually(List<String> input) {
        StringBuilder builder = new StringBuilder();
        UnaryOperator<String> initial = (String x)->x.substring(0,1);
        for (String s : input) {
            builder.append(initial.apply(s));
        }
        return builder.toString();
    }
}
