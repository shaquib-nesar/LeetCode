package com.leet.graphs;

import java.util.LinkedList;
import java.util.Queue;

public class RottingOranges {
    final int[] R = new int[]{-1, 0, 0, 1};
    final int[] C = new int[]{0, -1, 1, 0};

    public int orangesRotting(int[][] grid) {

        if (grid == null || grid.length == 0) return 0;

        var row = grid.length;
        var col = grid[0].length;

        int fresh = 0;
        Queue<int[]> q = new LinkedList<>();

        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                if (grid[i][j] == 2) q.add(new int[]{i, j});
                if (grid[i][j] == 1) fresh++;
            }
        }

        if (fresh == 0) return 0;
        var time = -1;

        while (!q.isEmpty()) {
            var n = q.size();
            time++;

            for (var i = 0; i < n; i++) {
                int[] element = q.poll();

                for (var k = 0; k < 4; k++) {
                    var x = element[0] + R[k];
                    var y = element[1] + C[k];

                    if (x >= 0 && x < row && y >= 0 && y < col && grid[x][y] == 1) {
                        fresh--;
                        grid[x][y] = 2;
                        q.add(new int[]{x, y});
                    }
                }
            }
        }

        return fresh == 0 ? time : -1;
    }
}
