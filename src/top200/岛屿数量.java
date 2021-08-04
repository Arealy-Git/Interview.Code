package top200;

public class 岛屿数量 {
    
    public int solve(char[][] grid) {
        //边界条件判断
        if (grid == null || grid.length == 0) {
            return 0;
        }
        //统计岛屿的个数
        int count = 0;
        //两个for循环遍历每一个格子
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                //只有当前格子是1才开始计算
                if (grid[i][j] == '1') {
                    //如果当前格子是1，岛屿的数量加1
                    count++;
                    //然后通过dfs把当前格子的上下左右4
                    //个位置为1的都要置为0，因为他们是连着
                    //一起的算一个岛屿，
                    dfs(grid, i, j);
                }
            }
        }
        //最后返回岛屿的数量
        return count;
    }

    private void dfs(char[][] grid, int i, int j) {
    }

}
