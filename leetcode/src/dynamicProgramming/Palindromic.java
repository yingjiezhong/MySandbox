package dynamicProgramming;

public class Palindromic {
    private static String solution(String s) {
        String longest = "";
        int longestInt = 0;
        int length = s.length();
        int[][] P = new int[length][length];

        for (int x = 0; x < length; x++) {
            P[x][x] = 1;
            if ((x < length - 1) && s.charAt(x) == s.charAt(x+1)) {
                P[x][x+1] = 1;
                if (longestInt < 1) {
                    longestInt = 1;
                    longest = s.substring(x,x+2);
                }
            }

            int i = 2;
            int y1 = x+i;
            int x1 = x+2-i;
            while (y1 < length && x1 >= 0) {
                if (s.charAt(x1) == s.charAt(y1)) {
                    P[x1][y1] = 1;
                    if (y1 - x1 > longestInt) {
                        longestInt = y1 - x1;
                        longest = s.substring(x1, y1+1);
                        System.out.println("found longer one: " + longest);
                    }
                    i++;
                    y1 = x+i;
                    x1 = x+2-i;
                } else {
                    break;
                }
            }
        }

        return longest;
    }

    public static void main(String[] argv) {
        String s = "bdbcacbdbcacbd";
        System.out.println("longest:" + solution(s));
    }

}
