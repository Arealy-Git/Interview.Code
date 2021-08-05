package top200;

import java.util.*;

public class t24_螺旋矩阵 {

    public ArrayList<Integer> spiralOrder(int[][] matrix) {
        ArrayList<Integer> path = new ArrayList<>();
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return path;
        }

        printMatrix(0, 0, matrix.length - 1, matrix[0].length - 1, matrix, path);
        return path;
    }

    private void printMatrix(int startRow, int startCol, int endRow, int endCol, int[][] matrix, ArrayList<Integer> path) {
        if (startRow < endRow && startCol < endCol) {
            //Right
            for (int r = startCol; r <= endCol; r++) {
                path.add(matrix[startRow][r]);
            }
            //Down
            for (int d = startRow + 1; d <= endRow - 1; d++) {
                path.add(matrix[d][endCol]);
            }
            //Left
            for (int l = endCol; l >= startCol; l--) {
                path.add(matrix[endRow][l]);
            }
            //Up
            for (int u = endRow - 1; u >= startRow + 1; u--) {
                path.add(matrix[u][startCol]);
            }
            printMatrix(startRow + 1, startCol + 1, endRow - 1, endCol - 1, matrix, path);
        }
        //Last Row
        else if (startRow == endRow && startCol < endCol) {
            for (int lr = startCol; lr <= endCol; lr++) {
                path.add(matrix[startRow][lr]);
            }
        }
        //Last Col
        else if (startRow < endRow && startCol == endCol) {
            for (int lc = startRow; lc <= endRow; lc++) {
                path.add(matrix[lc][startCol]);
            }
        }
        //Last One
        else if (startRow == endRow && startCol == endCol) {
            path.add(matrix[startRow][startCol]);
        } else {
            return;
        }
    }

}
