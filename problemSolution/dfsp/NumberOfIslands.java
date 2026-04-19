package problemSolution.dfsp;

import java.util.Arrays;

public class NumberOfIslands {
    public static int numIslands(char[][] grid) {
        int numberOfIsLand = 0;
        if (grid == null || grid.length == 0 || grid[0].length == 0) {
            return numberOfIsLand;
        }
        int rows = grid.length;
        int cols = grid[0].length;
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (grid[i][j] == '1') {
                    dfs(grid, i, j);
                    System.out.println(Arrays.deepToString(grid));
                    numberOfIsLand++;
                }
            }
        }
        return numberOfIsLand;
    }

    public static void dfs(char[][] grid, int i, int j) {
        if (i < 0 || i >= grid.length || j < 0 || j >= grid[i].length || grid[i][j] != '1') {
            return;
        }
        grid[i][j] = '2';
        dfs(grid, i, j + 1);
        dfs(grid, i, j - 1);
        dfs(grid, i + 1, j);
        dfs(grid, i - 1, j);
    }


    static void main() {
        char[][] grid = {
                {'0', '1', '1', '1', '0'},
                {'1', '1', '0', '1', '0'},
                {'1', '1', '0', '0', '0'},
                {'0', '0', '0', '0', '0'}
        };
        var result = numIslands(grid);
        System.out.println(result);
    }

}
