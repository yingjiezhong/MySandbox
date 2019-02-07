package dynamicProgramming;

public class BuySellStocks {
    private static int solution(int[] values) {
        int prev = 0;
        int min = 0;
        int max;
        int profit = 0;
        for (int v : values) {
            if (prev == 0) {
                prev = v;
                min = max = v;
            } else {
                if (prev > v) {
                    min = Math.min(min, v);
                    max = v;
                } else {
                    max = v;
                }
                if (max > min) {
                   int p = max - min;
                   if (profit < p) {
                       profit = p;
                   }
                }
                prev = v;
            }
        }
        return profit;
    }

    public static void main(String[] argv) {
        int[] values = {7, 1, 5, 3, 6, 4};
        System.out.println("max profit:" + solution(values));

    }

}
