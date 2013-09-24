package com.headius.talks.rabbithole;

public class StringSwitch {
    public static void main(String[] args) {
        String count = "unknown";
        switch (args.length) {
            case 0: count = "zero"; break;
            case 1: count = "one"; break;
            case 2: count = "two"; break;
        }
        
        switch (args.length) {
            case 200000: count = "two million"; break;
            case 100000: count = "one million"; break;
            case 300000: count = "three million"; break;
        }
        
        System.out.println(count);
        
        System.out.println(chooseGreeting("Java"));
        
        for (int i = 0; i < 100000; i++) {
            chooseGreeting("Java");
            chooseGreeting("Scala");
            chooseGreeting("Ruby");
        }
        
        for (int i = 0; i < 100000; i++) {
            chooseGreeting("Java");
            chooseGreeting("Scala");
            chooseGreeting("Ruby");
        }
    }
    
    static String chooseGreeting(String language) {
        switch (language) {
            case "Java": return "I love to hate you!";
            case "Scala": return "I love you, I think!";
            case "Clojure": return "(love I you)";
            case "Groovy": return "I love ?: you";
            case "Ruby": return "I.love? you # => true";
            default: return "Who are you?";
        }
    }
    
    static String chooseGreeting2(String language) {
        int hash = language.hashCode();
        int target = -1;
        switch (hash) {
            case 2301506: if (language.equals("Java")) target = 0; break;
            case 79698214: if (language.equals("Scala"))target = 1; break;
            case -1764029756: if (language.equals("Clojure"))target = 2; break;
            case 2141368366: if (language.equals("Groovy"))target = 3; break;
            case 2558458: if (language.equals("Ruby"))target = 3; break;
        }
        switch (target) {
            case 0: return "I love to hate you!";
            case 1: return "I love you, I think!";
            case 2: return "(love I you)";
            case 3: return "I love ?: you";
            case 4: return "I.love? you # => true";
            default: return "Who are you?";
        }
    }
    
    static int chooseTarget(String language) {
        int hash = language.hashCode();
        int target = -1;
        switch (hash) {
            case 2301506: if (language.equals("Java")) target = 0; break;
            case 79698214: if (language.equals("Scala"))target = 1; break;
            case -1764029756: if (language.equals("Clojure"))target = 2; break;
            case 2141368366: if (language.equals("Groovy"))target = 3; break;
            case 2558458: if (language.equals("Ruby"))target = 3; break;
        }
        return target;
    }
}
