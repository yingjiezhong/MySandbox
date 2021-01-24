package com.denofprogramming.leetcode.stack;

import java.util.Stack;

/**
 * Given an encoded string, return its decoded string.
 *
 * The encoding rule is: k[encoded_string], where the encoded_string inside the square brackets is being repeated exactly k times. Note that k is guaranteed to be a positive integer.
 *
 * You may assume that the input string is always valid; No extra white spaces, square brackets are well-formed, etc.
 *
 * Furthermore, you may assume that the original data does not contain any digits and that digits are only for those repeat numbers, k. For example, there won't be input like 3a or 2[4].
 *
 * Example 1:
 *
 * Input: s = "3[a]2[bc]"
 * Output: "aaabcbc"
 * Example 2:
 *
 * Input: s = "3[a2[c]]"
 * Output: "accaccacc"
 * Example 3:
 *
 * Input: s = "2[abc]3[cd]ef"
 * Output: "abcabccdcdcdef"
 * Example 4:
 *
 * Input: s = "abc3[cd]xyz"
 * Output: "abccdcdcdxyz"
 *
 * =========================
 * Input : str[] = "1[b]"
 * Output : b
 *
 * Input : str[] = "2[ab]"
 * Output : abab
 *
 * Input : str[] = "2[a2[b]]"
 * Output : abbabb
 *
 * Input : str[] = "3[b2[ca]]"
 * Output : bcacabcacabcaca
 *
 */
public class DecodeString {

    public String solution1(String s) {

        char[] cs = s.toCharArray();
        int i = 0;
        StringBuilder sb = new StringBuilder();
        Stack<Integer> numS = new Stack();
        Stack<Character> charS = new Stack();

        while (i<s.length()) {
            if (Character.isDigit(cs[i])) {
                numS.push(Character.getNumericValue(cs[i]));
            } else {
                if (cs[i] != ']') {
                    charS.push(cs[i]);
                } else {
                    // s = "3[a2[c]]";
                    // pop element and form the String
                    char c = charS.pop();
                    StringBuilder sbt = new StringBuilder();
                    while(c != '[' ) {
                        sbt.insert(0, c);
                        c = charS.pop();
                    }

                    // push back into the stack again
                    int r = numS.pop();
                    for (int j=0; j< r; j++) {
                        char[] cs1 = sbt.toString().toCharArray();
                        for (int k=0; k<cs1.length; k++) {
                            charS.push(cs1[k]);
                        }
                    }
                }
            }
            i++;
        }

        // push all out to sb
        while (!charS.isEmpty()) {
            char c = charS.pop();
            sb.insert(0,c);
        }

        return sb.toString();

    }

}
