package com.leet.graphs;

public class NumberOfIsland {


    final int[] r = new int[]{-1, 1, 0, 0};
    final int[] c = new int[]{0, 0, 1, -1};

    public int numIslands(char[][] A) {

        int row = A.length;
        int col = A[0].length;
        int count = 0;
        boolean[][] visited = new boolean[row + 1][col + 1];

        for (var i = 0; i < row; i++) {
            for (var j = 0; j < col; j++) {
                if (A[i][j] == '1' && !visited[i][j]) {
                    dfs(A, i, j, visited);
                    count++;
                }
            }
        }

        return count;
    }

    public void dfs(char[][] A, int row, int col, boolean[][] visited) {

        visited[row][col] = true;

        for (int z = 0; z < 4; z++) {
            if (isSafe(A, row + r[z], col + c[z], visited)) {
                dfs(A, row + r[z], col + c[z], visited);
            }
        }
    }

    public boolean isSafe(char[][] A, int row, int col, boolean[][] visited) {
        return row >= 0 && row < A.length && col >= 0 && col < A[0].length && A[row][col] == '1' && !visited[row][col];
    }
}
