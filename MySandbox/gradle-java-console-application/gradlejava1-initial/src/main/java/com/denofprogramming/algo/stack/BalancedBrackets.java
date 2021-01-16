package com.denofprogramming.algo.stack;

import java.util.EmptyStackException;
import java.util.Stack;

public class BalancedBrackets {
    // Complete the isBalanced function below.
    static String isBalanced(String s) {
        Stack<Character> stack = new Stack<Character>();

        for (int i=0; i<s.length(); i++) {
            try {
                if (left(s.charAt(i))) {
                    stack.push(s.charAt(i));
                } else {
                    Character c = stack.pop();
                    if (c == null) {
                        return "NO";
                    } else {
                        if (match(c, s.charAt(i)) == false) {
                            return "NO";
                        }
                    }
                }
            } catch (EmptyStackException e) {
                return "NO";
            }
        }
        return "YES";
    }

    static boolean left(char c) {
        return c == '{' || c == '[' || c == '(';
    }

    static boolean match(char l, char r) {
        switch (l) {
            case '{':
                return r == '}';
            case '[':
                return r == ']';
            case '(':
                return r == ')';
            default:
                return false;
        }
    }
}
