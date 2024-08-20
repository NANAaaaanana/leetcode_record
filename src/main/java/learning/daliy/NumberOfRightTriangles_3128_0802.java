package learning.daliy;

/**
 * 3128. 直角三角形
 * 给你一个二维 boolean 矩阵 grid 。
 * 请你返回使用 grid 中的 3 个元素可以构建的 直角三角形 数目，且满足 3 个元素值 都 为 1 。
 * 注意：
 * 如果 grid 中 3 个元素满足：一个元素与另一个元素在 同一行，同时与第三个元素在 同一列 ，那么这 3 个元素称为一个 直角三角形 。
 * 这 3 个元素互相之间不需要相邻。
 */
public class NumberOfRightTriangles_3128_0802 {

    private int result = 0;
    public long numberOfRightTriangles(int[][] grid) {
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    int cnt = isRightTriangle(grid, i, j);
                    result += cnt;
                }
            }
        }
        return result;
    }

    private int isRightTriangle(int[][] grid, int i, int j) {
        int rowCnt = 0;
        for(int n = 0; n < grid.length; n++) {
            if ( grid[n][j] == 1 && n != i) {
                rowCnt++;
            }
        }

        int colCnt = 0;
        for(int n = 0; n < grid[0].length; n++) {
            if ( grid[i][n] == 1 && n != j){
                colCnt++;
            }
        }

        if (rowCnt > 0 && colCnt > 0) {
            return rowCnt * colCnt;
        }
        return 0;
    }

    public static void main(String[] args) {
        int[][] grid = {{1,0,0},{0,0,1},{1,0,0}};
        System.out.println(new NumberOfRightTriangles_3128_0802().numberOfRightTriangles(grid));
    }
}
