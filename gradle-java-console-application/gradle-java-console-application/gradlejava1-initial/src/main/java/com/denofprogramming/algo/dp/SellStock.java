package com.denofprogramming.algo.dp;

public class SellStock {

    public int maxProfit(int[] stocks) {

        int mins = stocks[0];
        int maxp = 0;
        String e = "";

        for (int s : stocks) {
            int p = s - mins;
            if (maxp < p) {
                e = s + " - " + mins;
            }
            maxp = Math.max(maxp, p);
            mins = Math.min(mins, s);
        }
        System.out.println(e);
        return maxp;
    }

}
