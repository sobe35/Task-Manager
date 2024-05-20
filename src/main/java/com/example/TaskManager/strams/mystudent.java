package com.example.TaskManager.strams;

import java.util.ArrayList;
import java.util.List;

public class mystudent {
    public static void main(String[] args) {
        List<student> list= new ArrayList<>();
        Address a1= new Address(111,"abc");
        Address a2= new Address(101,"atc");
        Address a3= new Address(111,"bvc");
        student m1 = new student(1,"anh",a1);
        student m2 = new student(2,"bhh",a2);
        student m3 = new student(3,"seh",a3);
        list.add(m1);
        list.add(m2);
        list.add(m3);

        System.out.println(list);
        List<student> l =list.stream().filter(std->std.getAddress().getPincode()==111).toList();
        System.out.println(l);
        List<student> l2 = new ArrayList<>();
        for(student s : list) {
            if (s.getAddress().getPincode() == 101) {
                l2.add(s);
            }

        }
        System.out.println(l2);
    }
}
