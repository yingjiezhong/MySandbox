package dynamicProgramming;

import java.util.EmptyStackException;
import java.util.Stack;

public class LongestParentheses {

    static public int longestValidParentheses(String s) {
        int maxans = 0;
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
            } else {
                stack.pop();
                if (stack.empty()) {
                    stack.push(i);
                } else {
                    maxans = Math.max(maxans, i - stack.peek());
                }
            }
        }
        return maxans;
    }

    private static int solution(String s) {
        int ret = 0;
        int sec = 0;
        s = s+"(";
        int n = s.length();
        Stack<Integer> stack = new Stack();

        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '(') {
                stack.push(i);
                ret += sec;
                sec = 0;
            } else {
                try {
                    Integer r = stack.pop();
                    if (sec < i - r + 1) {
                        sec = i - r + 1;
                    }
                } catch (EmptyStackException e){
                    ret += sec;
                    break;
                }
            }
        }
        return ret;
    }

    public static void main(String[] argv) {
        String s = "()((()))()";
        System.out.println(s + ": " + solution(s));
        System.out.println(s + ": " + longestValidParentheses(s));
    }

}
