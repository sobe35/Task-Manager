package com.example.TaskManager.singleton;

public class B {
    public static void main(String[] args) {
        A a1 = A.getInstance();
        System.out.println(a1);
        A a2 = A.getInstance();
        System.out.println(a2);
    }
}
