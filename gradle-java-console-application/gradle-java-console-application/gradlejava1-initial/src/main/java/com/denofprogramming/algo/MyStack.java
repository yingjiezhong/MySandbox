package com.denofprogramming.algo;

import java.util.Stack;

public class MyStack {

    static void reverse(Stack s) {
        if (s.size() > 0) {
            Integer v = (Integer)s.pop();
            reverse(s);
            System.out.println("popped " + v);
            insertAtBottom(s, v);
            System.out.println("pushed " + v);
        }
        return;
    }

    static void insertAtBottom(Stack s, Integer v) {
        if (s.size() == 0) {
            s.push(v);
        } else {
            Integer i = (Integer)s.pop();
            insertAtBottom(s, v);
            s.push(i);
        }

    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);

        MyStack.reverse(stack);

        System.out.println(stack);
    }


}
