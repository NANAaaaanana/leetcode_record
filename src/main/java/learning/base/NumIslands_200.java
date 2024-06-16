package learning.base;

public class NumIslands_200 {
    public int numIslands(char[][] grid) {
        int result = 0;
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (grid[i][j] == '1') {
                    infect(grid, i,j);
                    result++;
                }
            }
        }
        return result;
    }

    public void infect(char[][] grid, int x, int y) {
        if (x < 0 || x > grid.length
            || y < 0 || y >= grid[0].length
            || grid[x][y] != '1') {
            return;
        }

        grid[x][y] = '2';
        infect(grid, x + 1, y);
        infect(grid, x - 1, y);
        infect(grid, x, y + 1);
        infect(grid, x, y - 1);
    }

    public static void main(String[] args) {
        System.out.println("===============test 1===============");
    }
}
