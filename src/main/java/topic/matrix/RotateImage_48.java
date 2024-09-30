package topic.matrix;

/**
 * 48. 旋转图像
 * 你将以 原地 旋转图像，也就是直接修改输入的二维矩阵。请不要 使用另一个矩阵来旋转图像。
 */
public class RotateImage_48 {
    public void rotate(int[][] matrix) {
        int length = matrix.length;
        int line = length / 2;
        for (int i = 0; i <= line; i++) {
            for(int j = i; j < length - i - 1; j++) {
                rotatePart(matrix, i, j);
            }
        }
    }

    public void rotatePart(int[][] matrix, int row, int column) {
        int temp = matrix[row][column];
        matrix[row][column] = matrix[matrix.length - 1 - column][row];
        matrix[matrix.length - 1 - column][row] = matrix[matrix.length - 1 - row][matrix.length - 1 - column];
        matrix[matrix.length - 1 - row][matrix.length - 1 - column] = matrix[column][matrix.length - 1 - row];
        matrix[column][matrix.length - 1 - row] = temp;
    }

    public static void main(String[] args) {
        int[][] matrix = {{1,2,3},{4,5,6},{7,8,9}};
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
        System.out.println("+++++++++++++++++++++++");
        new RotateImage_48().rotate(matrix);
        for (int[] ints : matrix) {
            for (int anInt : ints) {
                System.out.print(anInt + " ");
            }
            System.out.println();
        }
    }


}
