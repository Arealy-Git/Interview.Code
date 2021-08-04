package jianzhi;

public class 矩阵中的路径 {
    public boolean hasPath(char[][] matrix, String word) {
        //循环多次找到首个字母的初始位置
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[0].length; col++) {
                if (matrix[row][col] == word.charAt(0)) {
                    //找到初始位置，设置访问标记数组，可能不是一个，所有每次都创建新数组
                    boolean[][] flag = new boolean[matrix.length][matrix[0].length];
                    //dfs传入初始位置，访问数组，矩阵，寻找的字符位置，字符串
                    if (DFS(row, col, flag, matrix, 0, word) == true) {
                        return true;
                    }
                }
            }
        }
        return false;
    }

    public boolean DFS(int row, int col, boolean[][] flag, char[][] matrix, int index, String word) {
        //如果m，n位置在矩阵外返回false，如果这一节点走过返回false
        if (row < 0 || col < 0 || row >= matrix.length || col >= matrix[0].length || flag[row][col] == true) {
            return false;
        }
        //如果这个位置字母和字符串尾字母一样，且字符串序号就是最后一个，代表遍历完了，返回true，不在遍历
        if (word.charAt(word.length() - 1) == matrix[row][col] && (index == word.length() - 1)) {
            return true;
        }
        //字符串字母是序号对应字母
        if (word.charAt(index) == matrix[row][col]) {
            //访问过了
            flag[row][col] = true;
            //如果上下左右有下一个字母（k+1）则继续遍历，否则访问设置为未访问（每个字母这能经过一次，没有找到下一个字母，所以其实没有访问过）
            if (DFS(row + 1, col, flag, matrix, index + 1, word)
                    || DFS(row, col + 1, flag, matrix, index + 1, word)
                    || DFS(row - 1, col, flag, matrix, index + 1, word)
                    || DFS(row, col - 1, flag, matrix, index + 1, word)) {
                return true;
            } else {
                flag[row][col] = false;
                return false;
            }
        }
        //当前不是对应字母，返回false
        else {
            flag[row][col] = false;
            return false;
        }
    }
}
