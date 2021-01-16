package com.denofprogramming.algo.dp;

public class Abbreviation {
    /**
     * You can perform the following operations on the string, :
     *
     * Capitalize zero or more of 's lowercase letters.
     * Delete all of the remaining lowercase letters in .
     * Given two strings,  and , determine if it's possible to make  equal to  as described. If so, print YES on a new line. Otherwise, print NO.
     *
     * For example, given  and , in  we can convert  and delete  to match . If  and , matching is not possible because letters may only be capitalized or discarded, not changed.
     *
     * Function Description
     *
     * Complete the function  in the editor below. It must return either  or .
     *
     * abbreviation has the following parameter(s):
     *
     * a: the string to modify
     * b: the string to match
     *
     *
     * We have  daBcd and  ABC. We perform the following operation:
     *
     * Capitalize the letters a and c in  so that  dABCd.
     * Delete all the remaining lowercase letters in  so that  ABC.
     * Because we were able to successfully convert  to , we print YES on a new line.
     */


    /**
     * solution:
     * change a to upper case, and check if b is a sequence in a
     * remove lower case in a, and check the remaining is a sequence in b
     */

    public static String abbreviation(String a, String b) {


        boolean r1 = subsequence(b, a.toUpperCase());

        StringBuilder upper = new StringBuilder();
        for (int i =0; i<=a.length()-1; i++) {
            upper.append(Character.isUpperCase(a.charAt(i)) ? a.charAt(i) : "");
        }

        boolean r2 = subsequence(upper.toString(), b);

        return r1 && r2 ? "yes" : "no";
    }

    // if a is subsequence of b
    public static boolean subsequence(String as, String bs) {
        char[] a = as.toCharArray();
        char[] b = bs.toCharArray();
        int i=0,j=0;

        while (true) {
            if (i <= a.length -1) {
                while (j <= b.length - 1 && a[i] != b[j]) {
                        j++;
                }
                if (j == b.length -1 && i < a.length -1) {
                    return false;
                }
                i++;
                j++;
            } else {
                return true;
            }
        }

    }

}
