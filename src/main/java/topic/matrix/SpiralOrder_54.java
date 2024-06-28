package topic.matrix;

import java.util.ArrayList;
import java.util.List;

public class SpiralOrder_54 {
    public static List<Integer> spiralOrder(int[][] matrix) {
        int i = 0, j = 0;
        int compass = 0;
        int count = 0;
        List<Integer> result = new ArrayList<>();
        while (count < matrix.length * matrix[0].length) {
            switch (compass%4) {
                    case 0:
                        while (j < matrix[0].length && matrix[i][j] != 200 && count < matrix.length * matrix[0].length) {
                            result.add(matrix[i][j]);
                            matrix[i][j] = 200;
                            j++;
                            count++;
                        }
                        j--;
                        i++;
                        compass++;
                        continue;
                    case 1:
                        while (i < matrix.length && matrix[i][j] != 200 && count < matrix.length * matrix[0].length) {
                            result.add(matrix[i][j]);
                            matrix[i][j] = 200;
                            i++;
                            count++;
                        }
                        i--;
                        j--;
                        compass++;
                        continue;
                    case 2:
                        while (j >= 0 && matrix[i][j] != 200 && count < matrix.length * matrix[0].length) {
                            result.add(matrix[i][j]);
                            matrix[i][j] = 200;
                            j--;
                            count++;
                        }
                        j++;
                        i--;
                        compass++;
                        continue;
                    case 3:
                        while (i >= 0 && matrix[i][j] != 200 && count < matrix.length * matrix[0].length) {
                            result.add(matrix[i][j]);
                            matrix[i][j] = 200;
                            i--;
                            count++;
                        }
                        i++;
                        j++;
                        compass++;
                        continue;
            }
        }
        return result;
    }



    public static void main(String[] args)
    {
        int[][] matrix = new int[][]{{1,2,3},{4,5,6},{7,8,9}};
        List<Integer> res = spiralOrder(matrix);
        for (int i = 0; i < res.size(); i++) {
            System.out.println(res.get(i));
        }
    }
}
