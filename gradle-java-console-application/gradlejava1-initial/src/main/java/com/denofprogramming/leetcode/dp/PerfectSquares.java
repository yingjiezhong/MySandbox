package com.denofprogramming.leetcode.dp;

import java.util.HashMap;
import java.util.Stack;

/**
 * Given a positive integer n, find the least number of perfect square numbers (for example, 1, 4, 9, 16, ...) which sum to n.
 *
 * Example 1:
 *
 * Input: n = 12
 * Output: 3
 * Explanation: 12 = 4 + 4 + 4.
 * Example 2:
 *
 * Input: n = 13
 * Output: 2
 * Explanation: 13 = 4 + 9.
 *
 */
public class PerfectSquares {
    HashMap<Integer, Integer> map = new HashMap<>();

    public int solution(int n) {
        Stack<Integer> stack = new Stack<Integer>();
        int count = 0;

        for (int i = 1; i*i <= n; i++) {
            stack.push(i*i);
        }

        while (n != 0 && !stack.isEmpty()) {
            int s = stack.pop();
            if (s > n) continue;
            n -= s;
            count++;
            if (n >= s) stack.push(s);
        }

        return count;
    }

    /**
     * returns the count
     * @param n
     * @return
     */
    public int dpSolution(int n) {
        if (map.containsKey(n)) {
            return map.get(n);
        }

        int count = 1000;
        int temp;

        if (n <= 3) {
            count = n;
        }

        for (int i = 1; i <= n; i++) {
            if (i*i <= n) {
                temp = 1 + dpSolution(n - i*i);
                count = Math.min(count, temp);
            }
        }
        map.put(n, count);
        return count;
    }
}
