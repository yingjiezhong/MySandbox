package com.denofprogramming.hackerrank;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class RepertedStrings {
    // Complete the repeatedString function below.
    static long repeatedString(String s, long n) {
        int l = s.length();
        long last = n%l;
        int count1 =0, count2=0;
        long round = n/l;

        char[] chars = s.toCharArray();

        for (int i = 0; i<l; i++) {
            if (chars[i]=='a'){
                if (i <= last-1) {
                    count1++;
                }
                count2++;
            }
        }
        System.out.println("c1: " + count1);
        System.out.println("c2: " + count2);
        return round*count2+count1;

    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {

        String s = "a";

        long n = 10000;
        long result = repeatedString(s, n);

        System.out.println(result);

    }

}
