package com.denofprogramming.leetcode.queue;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.concurrent.ArrayBlockingQueue;

/**
 * Given an m x n 2d grid map of '1's (land) and '0's (water), return the number of islands.
 *
 * An island is surrounded by water and is formed by connecting adjacent lands horizontally or vertically. You may assume all four edges of the grid are all surrounded by water.
 *
 *
 *
 * Example 1:
 *
 * Input: grid = [
 *   ["1","1","1","1","0"],
 *   ["1","1","0","1","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","0","0","0"]
 * ]
 * Output: 1
 *
 * Example 2:
 *
 * Input: grid = [
 *   ["1","1","0","0","0"],
 *   ["1","1","0","0","0"],
 *   ["0","0","1","0","0"],
 *   ["0","0","0","1","1"]
 * ]
 * Output: 3
 *
 * Constraints:
 *
 * m == grid.length
 * n == grid[i].length
 * 1 <= m, n <= 300
 * grid[i][j] is '0' or '1'.
 */
public class NumberOfIslands {

    int solution(char[][] grid) {
        int m = grid.length;    //row
        int n = grid[0].length; //column
        boolean[][] visited = new boolean[m][n];
        int numOfIslands = 0;

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j] == true) {
                    continue;
                } else {
                    if (grid[i][j] == '0') {
                        visited[i][j] = true;
                        continue;
                    } else {
                        markIsland(grid, visited, i, j);
                        numOfIslands++;
                    }
                }
            }
        }

        System.out.println("num of island: " + numOfIslands);
        return numOfIslands;
    }

    class element {
        int row;
        int col;

        element(int i, int j) {
            row = i;
            col = j;
        }
    }

    /**
     * use BFS
     * since search from 0 to m, and 0 to n, only consider to right and downward.
     * @param grid
     * @param i
     * @param j
     */
    private void markIsland(char[][] grid, boolean[][] visited, int i, int j) {
        Queue<element> queue = new ArrayDeque<>();
        int step = 0;
        int m = grid.length;    //row
        int n = grid[0].length; //column
        System.out.println("mark is island: [" + i + "," + j + "]");

        queue.add(new element(i,j));
        while (!queue.isEmpty()) {
           element e = queue.poll();

           // mark as visited
           visited[e.row][e.col] = true;

           // add the next round
           if (e.row + 1 < m) {
               if (grid[e.row+1][e.col] == '1') {
                   queue.add(new element(e.row + 1, e.col));
               }
           }
           if (e.col + 1 < n) {
               if (grid[e.row][e.col+1] == '1') {
                   queue.add(new element(e.row, e.col+1));
               }
           }
           step++;
           System.out.println("step: " + step);
        }

    }
}
