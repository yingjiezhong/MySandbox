package com.denofprogramming.leetcode.stack;

import java.util.Stack;

/**
 * Evaluate the value of an arithmetic expression in Reverse Polish Notation.
 *
 * Valid operators are +, -, *, /. Each operand may be an integer or another expression.
 *
 * Note:
 *
 * Division between two integers should truncate toward zero.
 * The given RPN expression is always valid. That means the expression would always evaluate to a result and there won't be any divide by zero operation.
 * Example 1:
 *
 * Input: ["2", "1", "+", "3", "*"]
 * Output: 9
 * Explanation: ((2 + 1) * 3) = 9
 *
 */
public class EvaluateRPN {

    public int solution(String[] I) {
        Stack<Integer> s = new Stack();

        for (String i : I) {
            if (!isOperator(i)) {
                s.push(Integer.valueOf(i));
            } else {
                int rhs = s.pop();
                int lhs = s.pop();
                int ret = 0;

                switch (i) {
                    case "+":
                        ret = lhs + rhs;
                        break;
                    case "-":
                        ret = lhs - rhs;
                        break;
                    case "*":
                        ret = lhs * rhs;
                        break;
                    case "/":
                        ret = lhs / rhs;
                        break;
                    default:
                        return 1;
                }
                s.push(ret);
            }
        }

        return s.pop();
    }

    private boolean isOperator(String i) {
        return i.equals("+") || i.equals("-") || i.equals("*") || i.equals("/");
    }

}
