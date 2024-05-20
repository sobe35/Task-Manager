package com.example.TaskManager.singleton;

public class A {
    private static A a1;
    private A(){}
    public static  A getInstance(){
        if(a1==null){
            a1=new A();
        }
        return a1;
    }

}
