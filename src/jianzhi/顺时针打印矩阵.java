package jianzhi;

import java.util.ArrayList;

public class 顺时针打印矩阵 {

    public ArrayList<Integer> printMatrix(int[][] matrix) {
        ArrayList<Integer> result = new ArrayList<>();

        if (matrix == null || matrix.length == 0) {
            return result;
        }

        printMatrixClockWisely(matrix, result, 0, 0, matrix.length - 1, matrix[0].length - 1);

        return result;
    }

    public void printMatrixClockWisely(int[][] matrix, ArrayList<Integer> result, int startRow, int endRow, int startCol, int endCol) {
        if (startRow < endRow && startCol < endCol) {
            //Right
            for (int r = startCol; r <= endCol; r++) {
                result.add(matrix[startRow][r]);
            }

            //Down
            for (int d = startRow + 1; d <= endRow - 1; d++) {
                result.add(matrix[d][endCol]);
            }

            //Left
            for (int l = endCol; l >= startCol; l--) {
                result.add(matrix[endRow][l]);
            }

            //Up
            for (int u = endRow - 1; u >= startRow + 1; u--) {
                result.add(matrix[u][startCol]);
            }
            printMatrixClockWisely(matrix, result, startRow + 1, endRow - 1, startCol + 1, endCol - 1);
        }

        // Last Row
        else if (startRow == endRow && startCol < endCol) {
            for (int lc = startCol; lc <= endCol; lc++) {
                result.add(matrix[startRow][lc]);
            }
        }
        // Last Col
        else if (startRow < endRow && startCol == endCol) {
            for (int lr = startRow; lr <= endRow; lr++) {
                result.add(matrix[lr][startCol]);
            }
        }
        // Last One
        else if (startRow == endRow && startCol == endCol) {
            result.add(matrix[startRow][startCol]);
        } else {
            return;
        }
    }

}
