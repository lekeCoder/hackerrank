package com.test.hackerrant;

public class Test4Interface extends BaseC implements BaseI {
    public static void main(String[] args) {
        (new Test4Interface()).method();
    }
}

interface BaseI {
    void method();
}

class BaseC {
    public void method(){
        System.out.println("Inside BaseC:method");
    }
}