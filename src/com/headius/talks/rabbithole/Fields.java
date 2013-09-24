package com.headius.talks.rabbithole;

public class Fields {
    private static final String MY_STRING = "This is a static string";
    private static final String MY_PROPERTY = System.getProperty("java.home");
    
    private final String myString = "This is an instance string";
    private final String myProperty = System.getProperty("java.home");
    
    public static void main(String[] args) {
        System.out.println(MY_STRING);
        System.out.println(MY_PROPERTY);
        
        int hash = 1;
        for (int i = 0; i < 100000; i++) {
            hash += addHashes();
        }
        System.out.println(hash);
        
        Fields constants = new Fields();
        
        hash = 1;
        for (int i = 0; i < 100000; i++) {
            hash += constants.addHashes2();
        }
        System.out.println(hash);
        
        hash = 1;
        for (int i = 0; i < 100000; i++) {
            hash += constants.addHashes3();
        }
        System.out.println(hash);
    }
    
    private static int addHashes() {
        return MY_STRING.hashCode() + MY_PROPERTY.hashCode();
    }
    
    private int addHashes2() {
        return myString.hashCode() + myProperty.hashCode();
    }
    
    public String getMyString() {
        return myString;
    }
    
    public String getMyProperty() {
        return myProperty;
    }
    
    public int addHashes3() {
        return getMyString().hashCode() + getMyProperty().hashCode();
    }
}
