package com.denofprogramming.collection;

import java.util.ArrayList;

public class MyArrayList {

    public static void main(String[] args) {
        ArrayList<MyClass> list = new ArrayList<>();

        MyClass v1 = new MyClass("v1", "abe");
        MyClass v2 = new MyClass("v2", "xyz");
        MyClass v3 = new MyClass("v3", "abe");

        list.add(v1);
        list.add(v2);
        list.add(v3);

        list.forEach(m -> System.out.println(m.getValue()));
    }
}
