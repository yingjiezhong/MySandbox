package dynamicProgramming;

public class ClimbStairs {
    private static int climbStairs(int n) {
        int[] ways = new int[10];
        ways[0] = 0;
        ways[1] = 1;
        ways[2] = 2;

        for (int i = 3; i<=n; i++) {
            ways[i] = ways[i-1] + ways[i-2];
        }
         return ways[n];
    }

    public static void main(String[] argv) {
        int n = 6;
        System.out.println(n + ":" + climbStairs(n));

    }

}
